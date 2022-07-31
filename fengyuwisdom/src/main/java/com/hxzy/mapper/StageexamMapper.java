package com.hxzy.mapper;

import com.hxzy.entity.Stageexam;
import com.hxzy.entity.StageexamExample;
import java.util.List;

import com.hxzy.entity.Weekexam;
import org.apache.ibatis.annotations.Param;

public interface StageexamMapper {
    int countByExample(StageexamExample example);

    int deleteByExample(StageexamExample example);

    int deleteByPrimaryKey(@Param("sids") List<Integer> sids);

    int insert(Stageexam record);

    int insertSelective(Stageexam record);

    List<Stageexam> selectByExample(StageexamExample example);

    Stageexam selectByPrimaryKey(Stageexam stageexam);

    int updateByExampleSelective(@Param("record") Stageexam record, @Param("example") StageexamExample example);

    int updateByExample(@Param("record") Stageexam record, @Param("example") StageexamExample example);

    int updateByPrimaryKeySelective(Stageexam record);

    int updateByPrimaryKey(Stageexam record);

    List<Stageexam> queryByStu();

    List<Stageexam> queryByParam(@Param("sid") Integer sid,@Param("stage") Integer stage);

    int deleteById(Integer sid);

    int insertBatch(List<Stageexam> list);
}