package com.hxzy.controller;

import com.hxzy.entity.Admin;
import com.hxzy.service.AdminService;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/*
* 用户相关api
* */
@Controller
@RequestMapping("api/admin/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /*登录*/
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public R login(Admin admin, HttpSession session){
        R login = adminService.login(admin,session);
        return login;
    }

}
