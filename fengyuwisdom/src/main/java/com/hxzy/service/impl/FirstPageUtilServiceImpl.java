package com.hxzy.service.impl;


import com.hxzy.entity.ComplaintData;
import com.hxzy.entity.GradeData;
import com.hxzy.entity.ProjectData;
import com.hxzy.entity.StudentDDto;
import com.hxzy.mapper.InfoDtoMapper;
import com.hxzy.service.FirstPageUtilService;
import com.hxzy.service.GetDatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FirstPageUtilServiceImpl implements FirstPageUtilService {

    @Autowired
    InfoDtoMapper infoDtoMapper;
    @Autowired
    GetDatesService getDatesService;
    //通过具体某一天去查学员的数量
    @Override
    public List<Integer> getStuNumByDate() {
        List<Integer> stuNum=new ArrayList<>();
        //获取所有需要的查询的时间
        List<String> dates = getDatesService.getDates();

        List<StudentDDto> studentD = infoDtoMapper.getStudentD();
        for (int i = 0; i < dates.size(); i++) {
            //遍历如果某一天时间相同则
            int temp=0;
            for (int j = 0; j < studentD.size(); j++) {
                if(studentD.get(j).getCtime()!=null) {
                    String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(studentD.get(j).getCtime());
                    if(dates.get(i).equals(dodateFormat)){
                        temp++;
                    }
                }
            }
            stuNum.add(temp);
            temp=0;
        }
        return stuNum;
    }
    //通过具体某一天去查班级的数量
    @Override
    public List<Integer> getGradeNumByDate() {
        List<Integer> stuNum=new ArrayList<>();
        //获取所有需要的查询的时间
        List<String> dates = getDatesService.getDates();

        List<GradeData> grade = infoDtoMapper.getGrade();
        for (int i = 0; i < dates.size(); i++) {
            //遍历如果某一天时间相同则
            int temp=0;
            for (int j = 0; j < grade.size(); j++) {
                if(grade.get(j).getSdate()!=null) {
                    String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(grade.get(j).getSdate());
                    if(dates.get(i).equals(dodateFormat)){
                        temp++;
                    }
                }
            }
            stuNum.add(temp);
            temp=0;
        }
        return stuNum;
    }
    //通过具体某一天去查投诉的数量
    @Override
    public List<Integer> getComplaintNumByDate() {
        List<Integer> stuNum=new ArrayList<>();
        //获取所有需要的查询的时间
        List<String> dates = getDatesService.getDates();

        List<ComplaintData> complaint = infoDtoMapper.getComplaint();
        for (int i = 0; i < dates.size(); i++) {
            //遍历如果某一天时间相同则
            int temp=0;
            for (int j = 0; j < complaint.size(); j++) {
                if(complaint.get(j).getCtime()!=null) {
                    String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(complaint.get(j).getCtime());
                    if(dates.get(i).equals(dodateFormat)){
                        temp++;
                    }
                }
            }
            stuNum.add(temp);
            temp=0;
        }
        return stuNum;
    }
    //通过具体某一天去查项目的数量
    @Override
    public List<Integer> getProjectNumByDate() {
        List<Integer> stuNum=new ArrayList<>();
        //获取所有需要的查询的时间
        List<String> dates = getDatesService.getDates();

        List<ProjectData> project = infoDtoMapper.getProject();
        for (int i = 0; i < dates.size(); i++) {
            //遍历如果某一天时间相同则
            int temp=0;
            for (int j = 0; j < project.size(); j++) {
                if(project.get(j).getCtime()!=null) {
                    String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(project.get(j).getCtime());
                    if(dates.get(i).equals(dodateFormat)){
                        temp++;
                    }
                }
            }
            stuNum.add(temp);
            temp=0;
        }
        return stuNum;
    }

    @Override
    public List<String> getTiles() {
        List<String> tiles=new ArrayList<>();
        tiles.add("学员数量");
        tiles.add("班级开班数");
        tiles.add("投诉信息量");
        tiles.add("项目数量");
        return tiles;
    }

    //包装时间

    //处理日期
    public static String dodateFormat(Date sdate){
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        String format = dateFormat.format(sdate);
        String[] split = format.split(" ");
        return split[0];
    }
}
