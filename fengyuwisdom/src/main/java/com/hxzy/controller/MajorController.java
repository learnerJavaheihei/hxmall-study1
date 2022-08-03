package com.hxzy.controller;


import com.hxzy.entity.MajorDto;
import com.hxzy.service.MajorService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/major/")
@Controller
public class MajorController {

    @Autowired
    MajorService majorService;

    //分页
    @RequestMapping("/select.do")
    @ResponseBody
    public PageBean selectAll() {
        PageBean pageBean = majorService.selectAll();
        return pageBean;
    }
    //搜索
    @RequestMapping("/selectAll.do")
    @ResponseBody
    public   PageBean electAll(@RequestParam("sname") String sname, @RequestParam("major") String major) {
        return majorService.selectAlla(sname,major);
    }


    //添加
    @RequestMapping(value = "/insert.do", method = RequestMethod.POST)
    @ResponseBody
    public R insertALL(MajorDto record) {
        return majorService.insertAll(record);
    }

    //批量删除
    @RequestMapping(value = "/delete.do{ids}", method = RequestMethod.POST)
    @ResponseBody
    public R deleteALL(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            System.out.println(split.length);
            list.add(Integer.parseInt(split[i]));
        }
        System.out.println(list);
        return majorService.deleteALL(list);

    }
    //修改
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public  R updateAll(MajorDto majorDto){
        R r = majorService.updateAll(majorDto);
        return  RUtil.ok();
    }
    //删除
    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    @ResponseBody
    public  R deleteALL(Integer uuid){
        return   majorService.deleteAll(uuid);
    }



}
