package com.hxzy.controller;

import com.hxzy.service.ComplaintService;
import com.hxzy.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/complaint/")
public class complaintController {
    @Autowired
    private ComplaintService complaintService;
    @RequestMapping("all.do")
    @ResponseBody
    public PageBean selectAll(){
      return complaintService.selectAll();
    }
}
