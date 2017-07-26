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


  def get(u: String, map: Map[String, String]) = {

    val url = "http://api.steampowered.com/IDOTA2Match_570/" + u + "/v1?key=" + steamKey;
    val str = new StringBuilder;
    str.append(url)
    map.map(t => str.append("&" + t._1 + "=" + t._2))
    restTemplate.getForObject(str.toString(), classOf[String])


  }


}
