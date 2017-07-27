package com.cc.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


/**
  * Created by cong on 2017/7/24.
  */
@Component
class Dota2Util {

  @Value("${steam.key}")
  val steamKey: String = "";


  def get(u: String, map: Map[String, String]) = {

    val url = "http://api.steampowered.com/IDOTA2Match_570/" + u + "/v1?key=" + steamKey;
    val str = new StringBuilder;
    str.append(url)
    map.map(t => str.append("&" + t._1 + "=" + t._2))
    val restTemplate = new RestTemplate();

    restTemplate.getForObject(str.toString(), classOf[String])


  }




}
