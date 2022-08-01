package com.hxzy.mapper;

import com.hxzy.entity.*;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface InfoDtoMapper {
    int countByExample(StudentDtoExample example);

    int deleteByExample(StudentDtoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentDDto record);

    int insertSelective(StudentDDto record);

    List<StudentDDto> selectByExample(StudentDtoExample example);

    StudentDDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentDDto record, @Param("example") StudentDtoExample example);

    int updateByExample(@Param("record") StudentDDto record, @Param("example") StudentDtoExample example);

    int updateByPrimaryKeySelective(StudentDDto record);

    int updateByPrimaryKey(StudentDDto record);

    List<StudentSexDto> sexDates();

    List<StudentHomeTownDto> hometownDatas();

    List<StudentEducationDto> educationDatas();

    Integer getCount();

    Integer getGradeConut();

    Integer getComplaintConut();

    Integer getProjectConut();
//首页统计所需数据
    List<StudentDDto> getStudentD();

    List<ProjectData> getProject();

    List<ComplaintData> getComplaint();

    List<GradeData> getGrade();
}