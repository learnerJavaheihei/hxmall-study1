package com.hxzy.service.impl;

import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.ScoreDatas;
import com.hxzy.entity.Stageexam;
import com.hxzy.entity.Weekexam;
import com.hxzy.mapper.ScoreMapper;
import com.hxzy.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public ScoreDatas getStudentDayDatas() {
        //获取所有录入成绩的学生日考信息
        List<DayexamDto> dayexamDtos = scoreMapper.getStudent();
        for (int i = 0; i < dayexamDtos.size(); i++) {
            if(dayexamDtos.get(i).getScore()==null){
                dayexamDtos.remove(dayexamDtos.get(i));
                i--;
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取名字（去掉重复名）
        List<String> listNames=new ArrayList<>();
        for (DayexamDto dayexamDto : dayexamDtos) {
            if (!listNames.contains(dayexamDto.getName())) {
                listNames.add(dayexamDto.getName());
            }
        }
        //包装数据
        List<List<Object>> allDayAndName = new ArrayList<>();
        //首行数据
        List firstList=new ArrayList();
        firstList.add("product");
        //获取日期（去重）并加入进firstList中
        for (DayexamDto dayexamDto : dayexamDtos) {
            if(dayexamDto.getCdate()!=null){
                String format = simpleDateFormat.format(dayexamDto.getCdate());
                if(!firstList.contains(format)){
                    firstList.add(format);
                }
            }
        }
        //将首行数据加入到list中
        allDayAndName.add(firstList);
        //后面每行的数据数据
        for (int i = 0; i < listNames.size(); i++) {
            //{"名字“,分数，分数}依次加入到allDayAndName,即每行数据
            List<Object> nextList=new ArrayList();
            nextList.add(listNames.get(i));
            for (int j = 0; j < dayexamDtos.size(); j++) {
                if(listNames.get(i).equals(dayexamDtos.get(j).getName())){
                    nextList.add(dayexamDtos.get(j).getScore());
                }
            }
            //将每行数据加入到最后所需的list中
            allDayAndName.add(nextList);
        }
        ScoreDatas scoreDatas = new ScoreDatas();
        scoreDatas.setScoreDay(allDayAndName);
        return scoreDatas;
    }

    @Override
    public ScoreDatas getStudentWeekDatas() {
        //获取所有的学生日考信息
        List<Weekexam> weekexams = scoreMapper.getWeekexam();
        for (int i = 0; i < weekexams.size(); i++) {
            if(weekexams.get(i).getScore()==null){
                weekexams.remove(weekexams.get(i));
                i--;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取名字（去掉重复名）
        List<String> listNames=new ArrayList<>();
        for (Weekexam weekexam : weekexams) {
            if(!listNames.contains(weekexam.getName())){
                listNames.add(weekexam.getName());
            }
        }
        //包装数据
        List<List<Object>> allDayAndName = new ArrayList<>();
        //首行数据
        List firstList=new ArrayList();
        firstList.add("product");
        //获取日期（去重）并加入进firstList中
        for (Weekexam weekexam : weekexams) {
            if(weekexam.getWeek()!=null){
                if(!firstList.contains("第"+weekexam.getWeek()+"周")){
                    firstList.add("第"+weekexam.getWeek()+"周");
                }
            }
        }
        //将首行数据加入到list中
        allDayAndName.add(firstList);
        //后面每行的数据数据
        for (int i = 0; i < listNames.size(); i++) {
            //{"名字“,分数，分数}依次加入到allDayAndName,即每行数据
            List<Object> nextList=new ArrayList();
            nextList.add(listNames.get(i));
            for (int j = 0; j < weekexams.size(); j++) {
                if(listNames.get(i).equals(weekexams.get(j).getName())){
                    nextList.add(weekexams.get(j).getScore());
                }
            }
            //将每行数据加入到最后所需的list中
            allDayAndName.add(nextList);
        }
        ScoreDatas scoreDatas = new ScoreDatas();
        scoreDatas.setScoreWeek(allDayAndName);
        return scoreDatas;
    }

    @Override
    public ScoreDatas getStudentStageDatas() {
        //获取所有的学生日考信息
        List<Stageexam> stageexams = scoreMapper.getStageexam();
        for (int i = 0; i < stageexams.size(); i++) {
            if(stageexams.get(i).getScore()==null){
                stageexams.remove(stageexams.get(i));
                i--;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取名字（去掉重复名）
        List<String> listNames=new ArrayList<>();
        for (Stageexam stageexam : stageexams) {
            if(!listNames.contains(stageexam.getName())){
                listNames.add(stageexam.getName());
            }
        }
        //包装数据
        List<List<Object>> allDayAndName = new ArrayList<>();
        //首行数据
        List firstList=new ArrayList();
        firstList.add("product");
        //获取日期（去重）并加入进firstList中
        for (Stageexam stageexam : stageexams) {
            if(stageexam.getStage()!=null){
                if(!firstList.contains(stageexam.getStage()+"阶段")){
                    firstList.add(stageexam.getStage()+"阶段");
                }
            }
        }
        //将首行数据加入到list中
        allDayAndName.add(firstList);
        //后面每行的数据数据
        for (int i = 0; i < listNames.size(); i++) {
            //{"名字“,分数，分数}依次加入到allDayAndName,即每行数据
            List<Object> nextList=new ArrayList();
            nextList.add(listNames.get(i));
            for (int j = 0; j < stageexams.size(); j++) {
                if(listNames.get(i).equals(stageexams.get(j).getName())){
                    nextList.add(stageexams.get(j).getScore());
                }
            }
            //将每行数据加入到最后所需的list中
            allDayAndName.add(nextList);
        }
        ScoreDatas scoreDatas = new ScoreDatas();
        scoreDatas.setScoreStage(allDayAndName);
        return scoreDatas;
    }
}
