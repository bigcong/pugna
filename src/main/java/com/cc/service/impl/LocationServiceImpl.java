package com.cc.service.impl;

import java.util.*;

import com.cc.mapper.LocationMapper;
import com.cc.entity.Location;
import com.cc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * location
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Location> listPageLocation(Location location) {
        return locationMapper.listPageLocation(location);
    }

    @Override
    public Integer getLocationCount() {
        return locationMapper.getLocationCount();
    }

    @Override
    public void insert(Location location) {
        locationMapper.insert(location);
    }

    @Override
    public Location getLocationById(Integer id) {
        return locationMapper.getLocationById(id);
    }

    @Override
    public List<Location> listLocation(Location location) {
        return locationMapper.listLocation(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationMapper.updateLocation(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationMapper.deleteLocation(location);
    }

    @Override
    public void deleteLocationByIds(String[] ids) {
        locationMapper.deleteLocationByIds(ids);
    }

    @Override
    public void insertSelective(Location location) {
        locationMapper.insertSelective(location);
    }

    @Override
    public void updateByPrimaryKeySelective(Location location) {
        locationMapper.updateByPrimaryKeySelective(location);
    }

}