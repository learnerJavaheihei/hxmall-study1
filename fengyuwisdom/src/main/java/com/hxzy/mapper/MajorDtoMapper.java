package com.hxzy.mapper;


import com.hxzy.entity.MajorDto;
import com.hxzy.entity.MajorDtoExample;
import com.hxzy.entity.MajorSexDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MajorDtoMapper {
    int countByExample(MajorDtoExample example);
    int deleteByExample(@Param("ids") List<Integer> ids);
//    int deleteByExample(MajorDtoExample example);

    int insert(MajorDto record);

    int insertSelective(MajorDto record);

    List<MajorDto> selectByExample(MajorDtoExample example);

    int updateByExampleSelective(@Param("record") MajorDto record, @Param("example") MajorDtoExample example);

    int updateByExample(@Param("record") MajorDto record, @Param("example") MajorDtoExample example);
    int updateByPrimaryKey(MajorDto majorDto);
    int deleteByPrimaryKey(Integer uuid);
    //
    List<MajorDto> selectData(@Param("sname") String sname ,@Param("major") String major);
    List<MajorSexDto> stuSexTj();
}