package com.cc.controller;

import com.cc.entity.Menu;
import com.cc.entity.User;
import com.cc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     *
     * @param reques
     * @param user
     * @return
     */
    @RequestMapping("login")
    public User listLogin(HttpServletRequest reques,@RequestBody User user) {
        User u = this.loginService.getUser(user.getUserName(), user.getPassword());
        // 将用户名存到session当中

        reques.getSession().setAttribute("user", u);
        return u;
    }



}