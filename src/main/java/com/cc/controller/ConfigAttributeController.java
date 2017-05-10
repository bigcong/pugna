package com.cc.controller;

import com.cc.entity.ConfigAttribute;
import com.cc.service.ConfigAttributeService;
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
@RequestMapping(value = "/configAttribute")
public class ConfigAttributeController {

    @Autowired
    private ConfigAttributeService configAttributeService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param configAttribute
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(ConfigAttribute configAttribute) {

        List<ConfigAttribute> configAttributeList = configAttributeService.listPageConfigAttribute(configAttribute);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", configAttributeList);
        map.put("page", configAttribute);
        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param configAttribute
     * @return
     */
    @RequestMapping(value = "/load")
    public ConfigAttribute load(ConfigAttribute configAttribute) {
        configAttribute = configAttributeService.getConfigAttributeById(configAttribute.getAttributeId().intValue());
        return configAttribute;
    }

    /**
     * 保存
     *
     * @param configAttribute
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ConfigAttribute save(ConfigAttribute configAttribute) {
        try {
            if (configAttribute.getAttributeId() == null || configAttribute.getAttributeId().intValue() == 0) {
                configAttributeService.insertSelective(configAttribute);
            } else {
                configAttributeService.updateByPrimaryKeySelective(configAttribute);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configAttribute;
    }


    /**
     * 查看详情
     *
     * @param configAttribute
     */
    @RequestMapping(value = "/delete")
    public String delete(ConfigAttribute configAttribute, ModelMap modelMap) {
        configAttributeService.deleteConfigAttribute(configAttribute);
        return "success";
    }
}
