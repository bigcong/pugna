package com.cc.service.impl;

import java.util.*;

import com.cc.mapper.MenuMapper;
import com.cc.entity.Menu;
import com.cc.service.MenuService;
import com.cc.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * menu
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listPageMenu(Menu menu) {
        return menuMapper.listPageMenu(menu);
    }

    @Override
    public Integer getMenuCount() {
        return menuMapper.getMenuCount();
    }

    @Override
    public void insert(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public Menu getMenuById(Integer id) {
        return menuMapper.getMenuById(id);
    }

    @Override
    public List<Menu> listMenu(Menu menu) {
        return menuMapper.listMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
    }

    @Override
    public void deleteMenu(Menu menu) {
        menuMapper.deleteMenu(menu);
    }

    @Override
    public void deleteMenuByIds(String[] ids) {
        menuMapper.deleteMenuByIds(ids);
    }

    @Override
    public void insertSelective(Menu menu) {
        menu.setUpdateTime(DateUtil.nowDate());
        menu.setPId(0);
        menuMapper.insertSelective(menu);
    }

    @Override
    public void updateByPrimaryKeySelective(Menu menu) {
        menuMapper.updateByPrimaryKeySelective(menu);
    }

}