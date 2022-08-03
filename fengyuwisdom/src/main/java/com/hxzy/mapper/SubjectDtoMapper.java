package com.hxzy.mapper;


import com.hxzy.entity.SubjectDto;
import com.hxzy.entity.SubjectDtoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectDtoMapper {
    int countByExample(SubjectDtoExample example);

    int deleteByExample(SubjectDtoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubjectDto record);

    int insertSelective(SubjectDto record);

    List<SubjectDto> selectByExample(SubjectDtoExample example);

    SubjectDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubjectDto record, @Param("example") SubjectDtoExample example);

    int updateByExample(@Param("record") SubjectDto record, @Param("example") SubjectDtoExample example);

    int updateByPrimaryKeySelective(SubjectDto record);

    int updateByPrimaryKey(SubjectDto record);

}