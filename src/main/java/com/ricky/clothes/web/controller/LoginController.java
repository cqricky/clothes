package com.ricky.clothes.web.controller;

import com.ricky.clothes.constant.GlobalConstant;
import com.ricky.clothes.model.User;
import com.ricky.clothes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by caiqing on 16/2/26.
 */
@Controller
@RequestMapping("/admin")
public class LoginController extends BaseAppController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, HttpServletResponse res, User user) {

        user = loginService.findByNameAndPwd(user.getName(), user.getPassword());
        req.getSession().setAttribute(GlobalConstant.LOGIN_USER, user);

        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse res, User user) {
        req.getSession().invalidate();
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest req, HttpServletResponse res, User user) {
        return "login";
    }
}
