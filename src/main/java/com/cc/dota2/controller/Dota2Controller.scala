package com.cc.dota2.controller

import com.cc.dota2.util.Dota2Util
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


  @GetMapping(Array("cc"))
  def test = {
    val g = dota2Util.matchHistoryBySequenceNum()
    System.out.println(g)
    g


  }


}
