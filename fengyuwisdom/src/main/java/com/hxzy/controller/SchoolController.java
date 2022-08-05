package com.hxzy.controller;

import com.hxzy.entity.School;
import com.hxzy.service.SchoolService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/school/")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;


    @RequestMapping("/all.do")
    @ResponseBody
    public PageBean querAll(){
        return schoolService.querylist();
    }
    @RequestMapping(value = ("/insert.do"),method = RequestMethod.POST)
    @ResponseBody
    public R insert(School record){
        record.setCtime(new Date(new java.util.Date().getTime()));
        return schoolService.insert(record);
    }
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public R delete(Integer id){
        return schoolService.delete(id);
    }
    @RequestMapping(value = "/select.do")
    @ResponseBody
    public PageBean selectAll(@RequestParam("name") String name,
                              @RequestParam("no")String no,
                              @RequestParam("address")String address){
        return schoolService.selectAll(name,no,address);
    }
    @RequestMapping(value = "/deleteAll.do/{ids}",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@PathVariable("ids") String ids){
        String[] split = ids.split("-");
        List<Integer> id = new ArrayList<>();
        for (int i = 0;i<split.length;i++){
            id.add(Integer.parseInt(split[i]));
        }
        return schoolService.deleteAll(id);
    }
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public R updateAlla(School school) {
        System.out.println(school);

        if (school != null) {
            schoolService.updateData(school);
            return RUtil.ok();
        } else {
            return RUtil.fail();
        }
    }
}
