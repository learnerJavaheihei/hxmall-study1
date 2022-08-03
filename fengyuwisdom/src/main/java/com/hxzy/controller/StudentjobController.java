package com.hxzy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.hxzy.entity.Studentjob;
import com.hxzy.listener.EasyExcelSutdentjobLinstener;
import com.hxzy.service.StudentjobService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("api/student_job/")
public class StudentjobController {
    @Autowired
    private StudentjobService studentjobService;

    //分页查询
    @RequestMapping(value = "/all1.do")
    @ResponseBody
    public PageBean queryAll(){
        return studentjobService.querylist();
    }

    //新增
    @RequestMapping(value = "/save.do",method = RequestMethod.POST)
    @ResponseBody
    public R save(@RequestBody Studentjob studentjob){
        return studentjobService.save(studentjob);}

    //搜索
    @RequestMapping(value = "/queryall.do",method = RequestMethod.GET)
    @ResponseBody
    public PageBean queryall(@RequestParam(value = "sid",required = false)Integer sid,
                             @RequestParam(value = "company",required = false)String company){
        return studentjobService.queryByParam(sid,company);
    }

    //修改
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public R update(@RequestBody Studentjob studentjob) {
        Studentjob studentjob1 = studentjobService.queryBySid(studentjob);
        //如果没有不能修改，如有一样也不能修改
        if (studentjob1 == null) {
            int update = studentjobService.update(studentjob);
            if (update != 0) {
                return RUtil.ok();
            } else {
                return RUtil.fail();
            }
        } else if (studentjob1 != null && studentjob1.equals(studentjob)) {
            return RUtil.fail();
        }
        return RUtil.fail();
    }

    //导入
    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    @ResponseBody
    public R uploadFile(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            InputStream is = file.getInputStream();
            EasyExcel.read(is,Studentjob.class,new EasyExcelSutdentjobLinstener(studentjobService)).excelType(ExcelTypeEnum.XLS).sheet().doRead();
            return RUtil.ok();
        }
        return RUtil.fail();
    }
}
