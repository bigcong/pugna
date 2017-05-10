package com.cc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cc.entity.Location;
import com.cc.service.LocationService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param location
     * @return
     */
    @RequestMapping("list")
    public List<Location> list(Location location) {
        List<Location> locationList = locationService.listPageLocation(location);

        Gson gson = new Gson();
        System.out.println(gson.toJson(location));

        return locationList;
    }

    /**
     * 请求编辑页面
     *
     * @param locationId
     * @return
     */
    @RequestMapping(value = "/load")
    public Location load(Location location) {
        location = locationService.getLocationById(location.getId());

        return location;
    }

    /**
     * 保存店铺信息
     *
     * @param Equipment
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Location save(Location location) {
        try {
            if (location.getId() == null || location.getId().intValue() == 0) {
                if (location.getLat() != 0 && location.getLng() != 0) {
                    locationService.insert(location);
                }
            } else {
                locationService.updateLocation(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    /**
     * 查看详情
     *
     * @param locationId
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Location location) {
        locationService.deleteLocation(location);
        return "success";
    }
}
