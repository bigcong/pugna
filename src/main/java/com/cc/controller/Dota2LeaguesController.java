package com.cc.controller;

import com.cc.entity.Dota2Leagues;
import com.cc.service.Dota2LeaguesService;
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
@RequestMapping(value = "/dota2Leagues")
public class Dota2LeaguesController {

    @Autowired
    private Dota2LeaguesService dota2LeaguesService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param dota2Leagues
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(Dota2Leagues dota2Leagues) {

        List<Dota2Leagues> dota2LeaguesList = dota2LeaguesService.listPageDota2Leagues(dota2Leagues);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", dota2LeaguesList);
        map.put("page", dota2Leagues);
        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param dota2Leagues
     * @return
     */
    @RequestMapping(value = "/load")
    public Dota2Leagues load(Dota2Leagues dota2Leagues) {
        dota2Leagues = dota2LeaguesService.getDota2LeaguesById(dota2Leagues.getLeagueid());
        return dota2Leagues;
    }

    /**
     * 保存
     *
     * @param dota2Leagues
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Dota2Leagues save(Dota2Leagues dota2Leagues) {
        try {
            if (dota2Leagues.getLeagueid() == null || dota2Leagues.getLeagueid().intValue() == 0) {
                dota2LeaguesService.insertSelective(dota2Leagues);
            } else {
                dota2LeaguesService.updateByPrimaryKeySelective(dota2Leagues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dota2Leagues;
    }


    /**
     * 查看详情
     *
     * @param dota2Leagues
     */
    @RequestMapping(value = "/delete")
    public String delete(Dota2Leagues dota2Leagues, ModelMap modelMap) {
        dota2LeaguesService.deleteDota2Leagues(dota2Leagues);
        return "success";
    }
}
