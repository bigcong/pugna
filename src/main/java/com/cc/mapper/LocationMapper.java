package com.cc.mapper;

import java.util.List;

import com.cc.entity.Location;

/**
 * location
 */
public interface LocationMapper {

    List<Location> listPageLocation(Location location);

    Integer getLocationCount();

    void insert(Location location);

    void insertSelective(Location location);

    void updateByPrimaryKeySelective(Location location);

    Location getLocationById(Integer id);

    List<Location> listLocation(Location location);

    void updateLocation(Location location);

    void deleteLocation(Location location);

    void deleteLocationByIds(String[] id);

}