package com.hxzy.mapper;

import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.DayexamDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayexamDtoMapper {
    int countByExample(DayexamDtoExample example);

    int deleteByExample(DayexamDtoExample example);

    int deleteByPrimaryKey(@Param("sids") List<Integer> sids);

    int insert(DayexamDto record);

    int insertSelective(DayexamDto record);

    List<DayexamDto> selectByExample(DayexamDtoExample example);

    DayexamDto selectByPrimaryKey(DayexamDto dayexamDto);

    int updateByExampleSelective(@Param("record") DayexamDto record, @Param("example") DayexamDtoExample example);

    int updateByExample(@Param("record") DayexamDto record, @Param("example") DayexamDtoExample example);

    int updateByPrimaryKeySelective(DayexamDto record);

    int updateByPrimaryKey(DayexamDto record);

    List<DayexamDto> queryByStu();

    List<DayexamDto> queryByParam(@Param("name") String name,@Param("cdate") String cdate);

    int deleteById(Integer sid);

    int insertBatch(List<DayexamDto> list);
}