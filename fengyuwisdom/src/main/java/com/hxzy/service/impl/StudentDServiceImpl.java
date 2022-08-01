package com.hxzy.service.impl;

import com.hxzy.entity.StudentEducationDto;
import com.hxzy.entity.StudentHomeTownDto;
import com.hxzy.entity.StudentSexDatas;
import com.hxzy.entity.StudentSexDto;
import com.hxzy.mapper.InfoDtoMapper;
import com.hxzy.service.StudentDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentDServiceImpl implements StudentDDService {

    @Autowired
    InfoDtoMapper studentDtoMapper;
    //性别统计
    @Override
    public StudentSexDatas getStudentSex() {
        List<String> sexNames = new ArrayList<>();
        List<Map<String,Object>> sexNamesObject = new ArrayList<>();

        List<StudentSexDto> studentSexDtos = studentDtoMapper.sexDates();
        if(studentSexDtos!=null&&studentSexDtos.size()>0){
            for (StudentSexDto studentSexDto : studentSexDtos) {
                //将数据包装
                sexNames.add(this.getSexByInt(studentSexDto.getSex()));
                Map<String, Object> map=new HashMap<>();
                map.put("name",this.getSexByInt(studentSexDto.getSex()));
                map.put("value",studentSexDto.getCount());
                sexNamesObject.add(map);
            }
            StudentSexDatas studentSexDatas = new StudentSexDatas();
            studentSexDatas.setSexNames(sexNames);
            studentSexDatas.setSexNamesObject(sexNamesObject);
            return studentSexDatas;
        }
        return null;
    }
    //住址统计
    @Override
    public StudentSexDatas getStudentHometown() {
        List<StudentHomeTownDto> studentHomeTownDtos = studentDtoMapper.hometownDatas();
        List<String> hometowns = new ArrayList<>();
        List<Map<String, Object>> hometownsObject = new ArrayList<>();
        if(studentHomeTownDtos!=null){
            for (StudentHomeTownDto studentHomeTownDto : studentHomeTownDtos) {
                hometowns.add(studentHomeTownDto.getHometown());
                Map<String,Object> map = new HashMap<>();
                map.put("name",studentHomeTownDto.getHometown());
                map.put("value",studentHomeTownDto.getCount());
                hometownsObject.add(map);
            }
            StudentSexDatas studentSexDatas = new StudentSexDatas();
            studentSexDatas.setHometownNames(hometowns);
            studentSexDatas.setHometownNamesObject(hometownsObject);
            return studentSexDatas;
        }
        return null;
    }

    @Override
    public StudentSexDatas getStudentEducation() {
        List<StudentEducationDto> seds = studentDtoMapper.educationDatas();
        List<String> educationNames=new ArrayList<>();
        List<Map<String, Object>> educationNamesObject=new ArrayList<>();

        if(seds!=null){
            for (StudentEducationDto sed : seds) {
                educationNames.add(sed.getEducation());
                Map<String, Object> map = new HashMap<>();
                map.put("name",sed.getEducation());
                map.put("value",sed.getCount());
                educationNamesObject.add(map);
            }
            StudentSexDatas studentSexDatas = new StudentSexDatas();
            studentSexDatas.setEducationNames(educationNames);
            studentSexDatas.setEducationNamesObject(educationNamesObject);
            return studentSexDatas;
        }
        return null;
    }
    //学生个数
    @Override
    public Integer getCount() {
        return studentDtoMapper.getCount();
    }

    @Override
    public Integer getGradeConut() {
        return studentDtoMapper.getGradeConut();
    }

    @Override
    public Integer getComplaintConut() {
        return studentDtoMapper.getComplaintConut();
    }

    @Override
    public Integer getProjectConut() {
        return studentDtoMapper.getProjectConut();
    }

    public String getSexByInt(Integer sexId) {
        String sexName = "未知";
        switch (sexId)
        {
            case 0:
                sexName="女";
                break;
            case 1:
                sexName="男";
            break;
        }
        return sexName;
    }
}
