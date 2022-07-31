package com.hxzy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.Stageexam;
import com.hxzy.entity.Weekexam;
import com.hxzy.listener.EasyExcelStageLinstener;
import com.hxzy.listener.EasyExcelWeekLinstener;
import com.hxzy.service.StageexamService;
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
@RequestMapping("/stageexam")
@Api(value = "阶段考试信息接口",description = "阶段考试信息相关的api")
public class StageexamController {
    @Autowired
    StageexamService stageexamService;

    @RequestMapping("/query.do")
    @ResponseBody
    @ApiOperation(value = "分页查询",notes = "分页查询阶段考试信息",httpMethod = "GET")
    public PageBean query(){
        return stageexamService.query();
    }

    @RequestMapping(value = "/queryBy.do",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "搜索查询",notes = "搜索查询阶段考试信息",httpMethod = "GET")
    public PageBean queryBy(@RequestParam(value = "sid",required = false)Integer sid,
                            @RequestParam(value = "stage",required = false)Integer stage){
        return stageexamService.queryByParam(sid, stage);
    }
    //单个删除
    @RequestMapping(value = "/deleteBySid.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "id删除",notes = "删除阶段考试信息",httpMethod = "POST")
    public R deleteSingle(@RequestBody Stageexam stageexam){
        int delete = stageexamService.deleteSingle(stageexam.getSid());
        if(delete!=0){
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量删除",notes = "删除阶段考试信息",httpMethod = "POST")
    public R delete(@RequestBody List<Stageexam> stageexams){
        ArrayList<Integer> list = new ArrayList<>();
        for (Stageexam stageexam : stageexams) {
            list.add(stageexam.getSid());
        }
        int delete = stageexamService.delete(list);
        if(delete!=0){
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改",notes = "修改周考信息",httpMethod = "POST")
    public R update(@RequestBody Stageexam stageexam){
        Stageexam stageexam1 = stageexamService.queryBySid(stageexam);
        //如果没有不能修改，如有一样也不能修改
        if(stageexam1==null){
            return RUtil.fail();
        }else if(stageexam1!=null&&!stageexam.equals(stageexam1)){
            stageexam.setCtime(new java.sql.Date(new Date().getTime()));
            int update = stageexamService.update(stageexam);
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
    public R insert(@RequestBody Stageexam stageexam){
        //添加之前去查询学生是否存在
        Stageexam stageexam1 = stageexamService.queryBySid(stageexam);
        //如果有该学生且数据相同则不添加 如果没有添加
        if(stageexam1==null){
            stageexam.setCtime(new java.sql.Date(new Date().getTime()));
            stageexamService.insert(stageexam);
            return RUtil.ok();
        }else if(stageexam1!=null&&!stageexam.getStage().equals(stageexam1.getStage())){
            stageexam.setCtime(new java.sql.Date(new Date().getTime()));
            stageexamService.insert(stageexam);
            return RUtil.ok();
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping(value = "/export.do",method = RequestMethod.GET)
    @ApiOperation(value = "导出Excel",notes = "批量导出所有周考信息",httpMethod = "GET")
    public void exportDay(HttpServletResponse response){
        stageexamService.exportExcel(response);
    }

    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "导入Excel",notes = "批量导入所有周考信息",httpMethod = "POST")
    public R uploadFile(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            InputStream is = file.getInputStream();
            EasyExcel.read(is, Stageexam.class,new EasyExcelStageLinstener(stageexamService)).excelType(ExcelTypeEnum.XLSX).sheet().doRead();
            return RUtil.ok();
        }
        return RUtil.fail();
    }

}
