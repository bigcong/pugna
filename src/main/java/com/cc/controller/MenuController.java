package com.cc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.entity.Menu;
import com.cc.entity.User;
import com.cc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param menu
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(Menu menu) {
        List<Menu> menuList = menuService.listPageMenu(menu);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", menuList);
        map.put("page", menu);

        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param menu
     * @return
     */
    @RequestMapping(value = "/load")
    public Menu load(Menu menu) {
        menu = menuService.getMenuById(menu.getMenuId());


        return menu;
    }

    /**
     * 保存店铺信息
     *
     * @param menu
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Menu save(@RequestBody Menu menu, HttpServletRequest reques) {
        try {
            if (menu.getMenuId() == null || menu.getMenuId().intValue() == 0) {
                User user = (User) reques.getSession().getAttribute("user");
                menu.setUpdatePerson(user.getUserName());
                menu.setUpdatePersonId(user.getUserId());
                menuService.insertSelective(menu);
            } else {
                menuService.updateByPrimaryKeySelective(menu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }


    /**
     * 查看详情
     *
     * @param menu
     */
    @RequestMapping(value = "/delete")
    public Menu delete(Menu menu) {
        menuService.deleteMenu(menu);
        return menu;
    }
}
