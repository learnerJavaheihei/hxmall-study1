package com.hxzy.mapper;


import com.hxzy.entity.GradeDto;
import com.hxzy.entity.GradeDtoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeDtoMapper {
    int countByExample(GradeDtoExample example);

    int deleteByExample(@Param("ids") List<Integer> ids);

    int deleteByPrimaryKey(Integer id);

    int insert(GradeDto record);

    int insertSelective(GradeDto record);

    List<GradeDto> selectByExample(GradeDtoExample example);

    GradeDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GradeDto record, @Param("example") GradeDtoExample example);

    int updateByExample(@Param("record") GradeDto record, @Param("example") GradeDtoExample example);

    int updateByPrimaryKeySelective(GradeDto record);

    int updateByPrimaryKey(GradeDto record);
    List<GradeDto> selectAll(@Param("name")String name,@Param("address")String address);


}