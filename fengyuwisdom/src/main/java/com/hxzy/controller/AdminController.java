package com.hxzy.controller;

import com.hxzy.entity.Admin;
import com.hxzy.service.AdminService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    /*分页查询*/
    @RequestMapping(value = "/all.do")
    @ResponseBody
    public PageBean queryAll(){
        return adminService.querylist();
    }

    //新增
    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    @ResponseBody
    public R save(Admin admin){
        return adminService.sava(admin);
    }
//    //查询
//    @RequestMapping()

    //删除
    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public R delete(Integer id) {return adminService.delete(id);}

    //批量删除
    @RequestMapping(value = "/deleteall.do",method = RequestMethod.POST)
    @ResponseBody
    public R delete(@RequestBody List<Admin> admins){
        ArrayList<Integer> list = new ArrayList<>();
        for (Admin admin : admins) {
            list.add(admin.getId());
        }
        int delete = adminService.deleteall(list);
        if(delete!=0){
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }

    //修改
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public R update(@RequestBody Admin admin) {
        Admin admin1 = adminService.queryBySid(admin);
        //如果没有不能修改，如有一样也不能修改
        if (admin1 == null) {
            int update = adminService.update(admin);
            if (update != 0) {
                return RUtil.ok();
            } else {
                return RUtil.fail();
            }
        } else if (admin1 != null && admin1.equals(admin)) {
            return RUtil.fail();
        }
        return RUtil.fail();
    }



    //搜索
    @RequestMapping(value = "/queryall.do",method = RequestMethod.GET)
    @ResponseBody
    public PageBean queryall(@RequestParam(value = "name",required = false)String name,
                             @RequestParam(value = "no",required = false)String no){
        return adminService.queryByParam(name,no);
    }

}

