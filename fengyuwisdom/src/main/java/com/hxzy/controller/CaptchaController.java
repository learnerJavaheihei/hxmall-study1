package com.hxzy.controller;

import com.hxzy.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class CaptchaController {

    @Autowired
    private CaptchaService service;
    //生成验证码
    @GetMapping("/api/captch/create.do")
    public void create(HttpSession session, HttpServletResponse response) throws IOException {
        service.createImg(session, response);
    }
    //主页跳转
    @GetMapping("/")
    public String index(){
        return "/login.html";
    }
}
