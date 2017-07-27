package com.cc.service.impl

import com.cc.entity.Dota2MatchDetails
import com.cc.mapper.Dota2MatchDetailsMapper
import com.cc.service.Dota2MatchDetailsService
import com.cc.util.Dota2Util
import com.google.gson.{Gson, JsonArray, JsonObject}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


/**
  * Created by cong on 2017/7/27.
  */
@Service
class Dota2Service {
  @Autowired
  val dota2Util: Dota2Util = null;


  @Autowired
  val dota2MatchDetailsMapper: Dota2MatchDetailsMapper = null;

  @Autowired
  val dota2MatchDetailsService: Dota2MatchDetailsService = null;

  def matchDetails(match_id: Long) = {
    val g = dota2Util.get("GetMatchDetails", Map("match_id" -> match_id))
    val gg = new Gson();
    val s = gg.fromJson(g, classOf[JsonObject])
    val result = s.get("result").getAsJsonObject
    val j = gg.fromJson(result.toString, classOf[Dota2MatchDetails])
    val play = result.get("players")
    if (play != null) {
      j.setPlayer(play.getAsJsonArray.toString)
    }
    val picksBan = result.get("picks_bans")
    if (picksBan != null) {
      j.setPicksBan(picksBan.getAsJsonArray.toString)
    }

    if (j.getDuration > 600) {
      dota2MatchDetailsService.insertSelective(j)
    }
    j

  }


  def matchHistory = {
    val avg = dota2MatchDetailsMapper.avg();

    val g = dota2Util.get("GetMatchHistory", Map("matches_requested" -> 100, "game_mode" -> 16, "min_players" -> 10, "skill" -> 3,"start_at_match_id"-> avg.toLong))


    val gg = new Gson();

    val s = gg.fromJson(g, classOf[JsonObject])

    System.out.println(g)


    val matches: JsonArray = s.get("result").getAsJsonObject.get("matches").getAsJsonArray


    for (i <- 0 until matches.size()) yield {
      val match_id = matches.get(i).getAsJsonObject.get("match_id").getAsLong
      System.out.println(match_id)
      Future {
        try {
          matchDetails(match_id)


        } catch {
          case ex: Exception => ex.printStackTrace() // Handle missing file

        }
      }
    }

  }


}
