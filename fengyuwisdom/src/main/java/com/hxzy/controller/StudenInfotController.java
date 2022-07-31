package com.hxzy.controller;

import com.hxzy.entity.ScoreDatas;
import com.hxzy.entity.StudentSexDatas;
import com.hxzy.service.ScoreService;
import com.hxzy.service.StudentService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/statistics")
@Api(value = "图表统计接口",description = "统计api")
public class StudenInfotController {
    @Autowired
    StudentService studentService;
    @Autowired
    ScoreService scoreService;
    @RequestMapping("/studentSexInfo")
    @ResponseBody
    @ApiOperation(value = "男女个数统计",notes = "学生性别统计",httpMethod = "GET")
    public R studentInfoAction(){
        StudentSexDatas studentSex = studentService.getStudentSex();
        if(studentSex!=null){
            return RUtil.ok(studentSex);
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping("/studentHomeTownInfo")
    @ResponseBody
    @ApiOperation(value = "住址统计",notes = "学生住址统计",httpMethod = "GET")
    public R studentHtInfoAction(){
        StudentSexDatas studentHometown = studentService.getStudentHometown();
        if(studentHometown!=null){
            return RUtil.ok(studentHometown);
        }else {
            return RUtil.fail();
        }
    }
    @RequestMapping("/studentEducation")
    @ResponseBody
    @ApiOperation(value = "教育程度统计",notes = "学生教育程度统计",httpMethod = "GET")
    public R studentEduInfoAction(){
        StudentSexDatas studentEducation = studentService.getStudentEducation();
        if(studentEducation!=null){
            return RUtil.ok(studentEducation);
        }else {
            return RUtil.fail();
        }
    }

    @RequestMapping(value = "/score/day.do",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "日考成绩统计",notes = "成绩统计",httpMethod = "GET")
    public R scoreDayAction(){
        ScoreDatas studentDayDatas = scoreService.getStudentDayDatas();
        return RUtil.ok(studentDayDatas);
    }

    @RequestMapping(value = "/score/week.do",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "周考成绩统计",notes = "成绩统计",httpMethod = "GET")
    public R scoreWeekAction(){
        ScoreDatas studentWeekDatas = scoreService.getStudentWeekDatas();
        return RUtil.ok(studentWeekDatas);
    }
    @RequestMapping(value = "/score/stage.do",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "阶段考试成绩统计",notes = "成绩统计",httpMethod = "GET")
    public R scoreStageAction(){
        ScoreDatas studentStageDatas = scoreService.getStudentStageDatas();
        return RUtil.ok(studentStageDatas);
    }
}
