package com.cc.service;

import java.util.List;

import com.cc.entity.Location;

/**
 * location
 */
public interface LocationService {

    List<Location> listPageLocation(Location location);

    Integer getLocationCount();

    void insert(Location location);

    Location getLocationById(Integer id);

    List<Location> listLocation(Location location);

    void updateLocation(Location location);

    void deleteLocation(Location location);

    void deleteLocationByIds(String[] ids);

    /**
     * 有条件的更新
     */

    void insertSelective(Location location);

    /**
     * 根据主键有条件的更新
     */

    void updateByPrimaryKeySelective(Location location);

}