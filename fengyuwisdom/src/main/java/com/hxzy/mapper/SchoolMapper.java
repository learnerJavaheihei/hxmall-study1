package com.hxzy.mapper;

import com.hxzy.entity.School;
import com.hxzy.entity.SchoolExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolMapper {
    int countByExample(SchoolExample example);

    int deleteByExample(@Param("ids") List<Integer> ids);

    int deleteByPrimaryKey(Integer id);

    int insert(School record);

    int insertSelective(School record);

    List<School> selectByExample(SchoolExample example);

    School selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

    void saveBatch(List<School> list);

    List<School> selectAll(@Param("name")String name,@Param("no")String no,@Param("address")String address);
}