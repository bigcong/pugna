package com.cc.controller;

import com.cc.entity.Config;
import com.cc.service.ConfigService;
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
@RequestMapping(value = "/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}

	/**
	 * 显示列表
	 * @param config
	 * @return
	 */
	@RequestMapping("list")
	public Map<String, Object> list(Config config) {
		
		List<Config> configList = configService.listPageConfig(config);
	    Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", configList);
        map.put("page", config);
		return map;
	}
	
	/**
	 * 请求编辑页面
	 * @param config
	 * @return
	 */
	@RequestMapping(value = "/load")
	public Config  load( Config config) {
	 config = configService.getConfigById(config.getConfigId());
		return config;
	}

	/**
	 * 保存
	 * 
	 * @param config
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Config save(Config config) {
	    try {
			if (config.getConfigId() == null || config.getConfigId().intValue() == 0) {
				configService.insertSelective(config);
			} else {
				configService.updateByPrimaryKeySelective(config);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return config;
	}



	
	/**
	 * 查看详情
	 * @param  config
	 */
	@RequestMapping(value = "/delete")
	public String delete(Config config ,ModelMap modelMap) {
		configService.deleteConfig(config);
		return "success";
	}
}
