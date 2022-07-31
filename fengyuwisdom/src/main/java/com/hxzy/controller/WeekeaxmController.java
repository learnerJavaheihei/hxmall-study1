package com.hxzy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.Weekexam;
import com.hxzy.listener.EasyExcelWeekLinstener;
import com.hxzy.service.WeekexamService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/weekexam")
@Api(value = "周考信息接口",description = "周考信息相关的api")
public class WeekeaxmController {
    @Autowired
    WeekexamService weekexamService;

    @RequestMapping("/query.do")
    @ResponseBody
    @ApiOperation(value = "分页查询",notes = "分页查询周考信息",httpMethod = "GET")
    public PageBean query(){
        return weekexamService.query();
    }

    @RequestMapping(value = "/queryBy.do",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "搜索查询",notes = "搜索查询周考信息",httpMethod = "GET")
    public PageBean queryBy(@RequestParam(value = "sid",required = false)Integer sid,
                            @RequestParam(value = "wid",required = false)Integer wid){
        return weekexamService.queryByParam(sid, wid);
    }

    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除",notes = "删除周考信息",httpMethod = "POST")
    public R delete(@RequestBody List<Weekexam> weekexams){
        ArrayList<Integer> list = new ArrayList<>();
        for (Weekexam weekexam : weekexams) {
            list.add(weekexam.getSid());
        }
        int delete = weekexamService.delete(list);
        if(delete!=0){
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }
    //单个删除
    @RequestMapping(value = "/deleteBySid.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "id删除",notes = "删除周考信息",httpMethod = "POST")
    public R deleteSingle(@RequestBody Weekexam weekexam){
        int delete = weekexamService.deleteSingle(weekexam.getSid());
        if(delete!=0){
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改",notes = "修改周考信息",httpMethod = "POST")
    public R update(@RequestBody Weekexam weekexam){

        Weekexam dbWeekexam = weekexamService.queryBySid(weekexam);
        //如果没有不能修改，如有一样也不能修改
        if(dbWeekexam==null){
            return RUtil.fail();
        }else if(dbWeekexam!=null&&!weekexam.equals(dbWeekexam)){
            weekexam.setCtime(new java.sql.Date(new Date().getTime()));
            int update = weekexamService.update(weekexam);
            if(update!=0){
                return RUtil.ok();
            }else {
                return RUtil.fail();
            }
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping(value = "/insert.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加和验证",notes = "添加周考信息",httpMethod = "POST")
    public R insert(@RequestBody Weekexam weekexam){

        //添加之前去查询学生是否存在
        Weekexam weekexam1 = weekexamService.queryBySid(weekexam);
        //如果有该学生且数据相同则不添加 如果没有添加
        if(weekexam1==null){
            weekexam.setCtime(new java.sql.Date(new Date().getTime()));
            weekexamService.insert(weekexam);
            return RUtil.ok();
        }else if(weekexam1!=null&&!weekexam.getWeek().equals(weekexam1.getWeek())){
            weekexam.setCtime(new java.sql.Date(new Date().getTime()));
            weekexamService.insert(weekexam);
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping(value = "/export.do",method = RequestMethod.GET)
    @ApiOperation(value = "导出Excel",notes = "批量导出所有周考信息",httpMethod = "GET")
    public void exportDay(HttpServletResponse response){
        weekexamService.exportExcel(response);
    }

    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "导入Excel",notes = "批量导入所有周考信息",httpMethod = "POST")
    public R uploadFile(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            InputStream is = file.getInputStream();
            EasyExcel.read(is,Weekexam.class,new EasyExcelWeekLinstener(weekexamService)).excelType(ExcelTypeEnum.XLSX).sheet().doRead();
            return RUtil.ok();
        }
        return RUtil.fail();
    }
}
