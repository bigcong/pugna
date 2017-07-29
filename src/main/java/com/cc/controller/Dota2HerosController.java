package com.cc.controller;

import com.cc.entity.Dota2Heros;
import com.cc.service.Dota2HerosService;
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
@RequestMapping(value = "/dota2Heros")
public class Dota2HerosController {

	@Autowired
	private Dota2HerosService dota2HerosService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}

	/**
	 * 显示列表
	 * @param dota2Heros
	 * @return
	 */
	@RequestMapping("list")
	public Map<String, Object> list(Dota2Heros dota2Heros) {
		
		List<Dota2Heros> dota2HerosList = dota2HerosService.listPageDota2Heros(dota2Heros);
	    Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", dota2HerosList);
        map.put("page", dota2Heros);
		return map;
	}
	
	/**
	 * 请求编辑页面
	 * @param dota2Heros
	 * @return
	 */
	@RequestMapping(value = "/load")
	public Dota2Heros  load( Dota2Heros dota2Heros) {
	 dota2Heros = dota2HerosService.getDota2HerosById(dota2Heros.getId().intValue());
		return dota2Heros;
	}

	/**
	 * 保存
	 * 
	 * @param dota2Heros
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Dota2Heros save(Dota2Heros dota2Heros) {
	    try {
			if (dota2Heros.getId() == null || dota2Heros.getId().intValue() == 0) {
				dota2HerosService.insertSelective(dota2Heros);
			} else {
				dota2HerosService.updateByPrimaryKeySelective(dota2Heros);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dota2Heros;
	}



	
	/**
	 * 查看详情
	 * @param  dota2Heros
	 */
	@RequestMapping(value = "/delete")
	public String delete(Dota2Heros dota2Heros ,ModelMap modelMap) {
		dota2HerosService.deleteDota2Heros(dota2Heros);
		return "success";
	}
}
