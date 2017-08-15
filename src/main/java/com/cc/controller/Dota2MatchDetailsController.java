package com.cc.controller;

import com.cc.entity.Dota2MatchDetails;
import com.cc.service.Dota2MatchDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/dota2MatchDetails")
public class Dota2MatchDetailsController {

    @Autowired
    private Dota2MatchDetailsService dota2MatchDetailsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param dota2MatchDetails
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(Dota2MatchDetails dota2MatchDetails) {

        List<Dota2MatchDetails> dota2MatchDetailsList = dota2MatchDetailsService.listPageDota2MatchDetails(dota2MatchDetails);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", dota2MatchDetailsList);
        map.put("page", dota2MatchDetails);
        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param dota2MatchDetails
     * @return
     */
    @RequestMapping(value = "/load")
    public Dota2MatchDetails load(Dota2MatchDetails dota2MatchDetails) {
        dota2MatchDetails = dota2MatchDetailsService.getDota2MatchDetailsById(dota2MatchDetails.getMatchId().intValue());
        return dota2MatchDetails;
    }

    /**
     * 保存
     *
     * @param dota2MatchDetails
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Dota2MatchDetails save(Dota2MatchDetails dota2MatchDetails) {
        try {
            if (dota2MatchDetails.getMatchId() == null || dota2MatchDetails.getMatchId().intValue() == 0) {
                dota2MatchDetailsService.insertSelective(dota2MatchDetails);
            } else {
                dota2MatchDetailsService.updateByPrimaryKeySelective(dota2MatchDetails);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dota2MatchDetails;
    }


    /**
     * 查看详情
     *
     * @param dota2MatchDetails
     */
    @RequestMapping(value = "/delete")
    public String delete(Dota2MatchDetails dota2MatchDetails, ModelMap modelMap) {
        dota2MatchDetailsService.deleteDota2MatchDetails(dota2MatchDetails);
        return "success";
    }

    @RequestMapping(value = "/matchHistory")
    public void matchHistory() {
        System.out.println("开始时间为:" + new Date());
        dota2MatchDetailsService.matchHistory();


        System.out.println("结束时间为:" + new Date());

    }


    @RequestMapping(value = "/leagues")
    public void leagues() {
        System.out.println("开始时间为:" + new Date());
        dota2MatchDetailsService.leagues();


        System.out.println("结束时间为:" + new Date());

    }


    /**
     * 表示每个星期三中午12点
     */
    @RequestMapping(value = "/heros")
    public void heros() {
        System.out.println("开始时间为:" + new Date());
        dota2MatchDetailsService.heroes();

        System.out.println("结束时间为:" + new Date());

    }


    @RequestMapping(value = "/gameItems")
    public void gameItems() {
        System.out.println("开始时间为:" + new Date());
        dota2MatchDetailsService.gameItems();


        System.out.println("结束时间为:" + new Date());

    }

    @RequestMapping
    public void test() {
        System.out.println(new Date());
    }


}
