package com.cc.controller


import com.cc.service.impl.Dota2Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}


/**
  * Created by cong on 2017/7/24.
  */
@RestController
@RequestMapping(Array("/dota2"))
class Dota2Controller {


  @Autowired
  val dota2Service: Dota2Service = null;


  @GetMapping(Array("gg"))
  def gg = {
    val re = dota2Service.matchHistory
    "成功"


  }


}
