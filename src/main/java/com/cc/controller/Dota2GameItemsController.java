package com.cc.controller;

import com.cc.entity.Dota2GameItems;
import com.cc.service.Dota2GameItemsService;
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
@RequestMapping(value = "/dota2GameItems")
public class Dota2GameItemsController {

	@Autowired
	private Dota2GameItemsService dota2GameItemsService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}

	/**
	 * 显示列表
	 * @param dota2GameItems
	 * @return
	 */
	@RequestMapping("list")
	public Map<String, Object> list(Dota2GameItems dota2GameItems) {
		
		List<Dota2GameItems> dota2GameItemsList = dota2GameItemsService.listPageDota2GameItems(dota2GameItems);
	    Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", dota2GameItemsList);
        map.put("page", dota2GameItems);
		return map;
	}
	
	/**
	 * 请求编辑页面
	 * @param dota2GameItems
	 * @return
	 */
	@RequestMapping(value = "/load")
	public Dota2GameItems  load( Dota2GameItems dota2GameItems) {
	 dota2GameItems = dota2GameItemsService.getDota2GameItemsById(dota2GameItems.getId().intValue());
		return dota2GameItems;
	}

	/**
	 * 保存
	 * 
	 * @param dota2GameItems
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Dota2GameItems save(Dota2GameItems dota2GameItems) {
	    try {
			if (dota2GameItems.getId() == null || dota2GameItems.getId().intValue() == 0) {
				dota2GameItemsService.insertSelective(dota2GameItems);
			} else {
				dota2GameItemsService.updateByPrimaryKeySelective(dota2GameItems);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dota2GameItems;
	}



	
	/**
	 * 查看详情
	 * @param  dota2GameItems
	 */
	@RequestMapping(value = "/delete")
	public String delete(Dota2GameItems dota2GameItems ,ModelMap modelMap) {
		dota2GameItemsService.deleteDota2GameItems(dota2GameItems);
		return "success";
	}
}
