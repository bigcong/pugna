package com.cc.dota2.util


import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.stereotype.Component
import org.springframework.web.client.{RestOperations, RestTemplate}

/**
  * Created by cong on 2017/7/24.
  */
@Component
class Dota2Util {

  @Value("${steam.key}")
  val steamKey: String = "";

  @Autowired
  private val restTemplate: RestTemplate = null

  def matchHistoryBySequenceNum(): String = {
    val url = "http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1?key=" + steamKey + "&match_id=" + 582

    restTemplate.getForEntity(url, classOf[String]).getBody

  }


}
