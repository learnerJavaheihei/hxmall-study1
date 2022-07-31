package com.hxzy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.hxzy.entity.DayexamDto;
import com.hxzy.listener.EasyExcelLinstener;
import com.hxzy.service.DayexamService;
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
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dayexam")
@Api(value = "日考信息接口",description = "日考信息相关的api")
public class DayexamController {
    @Autowired
    DayexamService dayexamService;

    @RequestMapping("/query.do")
    @ResponseBody
    @ApiOperation(value = "分页查询",notes = "分页查询日考信息",httpMethod = "GET")
    public PageBean query(){
        return dayexamService.query();
    }


    @RequestMapping(value = "/queryBy.do",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "搜索查询",notes = "搜索查询日考信息",httpMethod = "GET")
    public PageBean queryBy(@RequestParam(value = "name",required = false)String name,
                            @RequestParam(value = "cdate",required = false)String cdate){
        return dayexamService.queryByParam(name, cdate);
    }

    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除",notes = "删除日考信息",httpMethod = "POST")
    public R delete(@RequestBody List<DayexamDto> dayexamDtos){
        ArrayList<Integer> list = new ArrayList<>();
        for (DayexamDto dayexamDto : dayexamDtos) {
            list.add(dayexamDto.getSid());
        }
        int delete = dayexamService.delete(list);
        if(delete!=0){
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }

    //单个删除
    @RequestMapping(value = "/deleteBySid.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "id删除",notes = "删除日考信息",httpMethod = "POST")
    public R deleteSingle(@RequestBody DayexamDto dayexamDtos){
        int delete = dayexamService.deleteSingle(dayexamDtos.getSid());
        if(delete!=0){
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }

    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改",notes = "修改日考信息",httpMethod = "POST")
    public R update(@RequestBody DayexamDto dayexamDto){
        DayexamDto dbDayexamDto = dayexamService.queryBySid(dayexamDto);
        //如果没有不能修改，如有一样也不能修改
        if(dbDayexamDto==null){
            return RUtil.fail();
        }else if(dbDayexamDto!=null&&!dayexamDto.equals(dbDayexamDto)){
            dayexamDto.setCtime(new java.sql.Date(new Date().getTime()));
            int update = dayexamService.update(dayexamDto);
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
    @ApiOperation(value = "添加和验证",notes = "添加日考信息",httpMethod = "POST")
    public R insert(@RequestBody DayexamDto dayexamDto){

        //添加之前去查询学生是否存在
        DayexamDto dbDayexamDto = dayexamService.queryBySid(dayexamDto);
        //如果添加的学号没有则直接添加，如果有 且日期不同 添加 否则添加失败
        if(dbDayexamDto==null){
            dayexamDto.setCtime(new java.sql.Date(new Date().getTime()));
            dayexamService.insert(dayexamDto);
            return RUtil.ok();
        }else if(dbDayexamDto!=null&&!dayexamDto.getCdate().equals(dbDayexamDto.getCdate())){
            dayexamDto.setCtime(new java.sql.Date(new Date().getTime()));
            dayexamService.insert(dayexamDto);
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping(value = "/export.do",method = RequestMethod.GET)
    @ApiOperation(value = "导出Excel",notes = "批量导出所有日考信息",httpMethod = "GET")
    public void exportDay(HttpServletResponse response){
        dayexamService.exportExcel(response);
    }


    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "导入Excel",notes = "批量导入所有日考信息",httpMethod = "POST")
    public R uploadFile(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            InputStream is = file.getInputStream();
            EasyExcel.read(is,DayexamDto.class,new EasyExcelLinstener(dayexamService)).excelType(ExcelTypeEnum.XLSX).sheet().doRead();
            return RUtil.ok();
        }
        return RUtil.fail();
    }
}
