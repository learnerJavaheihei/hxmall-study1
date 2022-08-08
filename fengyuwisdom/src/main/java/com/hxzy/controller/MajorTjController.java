package com.hxzy.controller;

import com.hxzy.service.MajorTJService;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/majo/")
public class MajorTjController {
    @Autowired
    private MajorTJService majorTJService;
    @RequestMapping("stuTJ.do")
    @ResponseBody
    public R stuTj(){
        return  majorTJService.getMajorTJ();

    }
}
