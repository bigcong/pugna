package com.cc.controller

import com.cc.entity.Dota2MatchDetails
import com.cc.service.Dota2MatchDetailsService
import com.cc.util.Dota2Util
import com.google.gson.{Gson, JsonObject}
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}


/**
  * Created by cong on 2017/7/24.
  */
@RestController
@RequestMapping(Array("/dota2"))
class Dota2Controller {
  @Value("${steam.key}")
  val steamKey: String = "";
  @Autowired
  val dota2Util: Dota2Util = null;
  @Autowired
  val dota2MatchDetailsService: Dota2MatchDetailsService = null;


  @GetMapping(Array("cc"))
  def test = {
    val url = "http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1?key=" + steamKey + "&match_id=3282763119";
    val g = dota2Util.get("GetMatchDetails", Map("match_id" -> "3282763119"))


    val gg = new Gson();

    val s = gg.fromJson(g, classOf[JsonObject])

    System.out.println(g)


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

    dota2MatchDetailsService.insertSelective(j)
    j


  }


}
