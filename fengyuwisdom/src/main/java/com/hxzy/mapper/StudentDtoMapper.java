package com.hxzy.mapper;

import com.hxzy.entity.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentDtoMapper {
    int countByExample(StudentDtoExample example);

    int deleteByExample(StudentDtoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentDto record);

    int insertSelective(StudentDto record);

    List<StudentDto> selectByExample(StudentDtoExample example);

    StudentDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentDto record, @Param("example") StudentDtoExample example);

    int updateByExample(@Param("record") StudentDto record, @Param("example") StudentDtoExample example);

    int updateByPrimaryKeySelective(StudentDto record);

    int updateByPrimaryKey(StudentDto record);

    List<StudentSexDto> sexDates();

    List<StudentHomeTownDto> hometownDatas();

    List<StudentEducationDto> educationDatas();
}