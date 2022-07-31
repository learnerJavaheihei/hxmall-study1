package com.hxzy.mapper;

import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.Weekexam;
import com.hxzy.entity.WeekexamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeekexamMapper {
    int countByExample(WeekexamExample example);

    int deleteByExample(WeekexamExample example);

    int deleteByPrimaryKey(@Param("sids") List<Integer> sids);

    int insert(Weekexam record);

    int insertSelective(Weekexam record);

    List<Weekexam> selectByExample(WeekexamExample example);

    Weekexam selectByPrimaryKey(Weekexam week);

    int updateByExampleSelective(@Param("record") Weekexam record, @Param("example") WeekexamExample example);

    int updateByExample(@Param("record") Weekexam record, @Param("example") WeekexamExample example);

    int updateByPrimaryKeySelective(Weekexam record);

    int updateByPrimaryKey(Weekexam record);

    List<Weekexam> queryByStu();

    List<Weekexam> queryByParam(@Param("sid") Integer sid,@Param("week") Integer week);

    int deleteById(Integer sid);

    int insertBatch(List<Weekexam> list);
}