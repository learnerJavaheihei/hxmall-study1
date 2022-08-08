package com.hxzy.mapper;

import com.hxzy.entity.ComplaintDto;
import com.hxzy.entity.ComplaintDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComplaintDtoMapper {
    int countByExample(ComplaintDtoExample example);

    int deleteByExample(ComplaintDtoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComplaintDto record);

    int insertSelective(ComplaintDto record);

    List<ComplaintDto> selectByExample(ComplaintDtoExample example);

    ComplaintDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ComplaintDto record, @Param("example") ComplaintDtoExample example);

    int updateByExample(@Param("record") ComplaintDto record, @Param("example") ComplaintDtoExample example);

    int updateByPrimaryKeySelective(ComplaintDto record);

    int updateByPrimaryKey(ComplaintDto record);
    List<ComplaintDto> selectExample();
}