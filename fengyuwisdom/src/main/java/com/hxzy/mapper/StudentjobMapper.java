package com.hxzy.mapper;

import com.hxzy.entity.Studentjob;
import com.hxzy.entity.StudentjobExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentjobMapper {
    int countByExample(StudentjobExample example);

    int deleteByExample(StudentjobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Studentjob record);

    int insertSelective(Studentjob record);

     List<Studentjob> selectByExample(StudentjobExample example);

    Studentjob selectByPrimaryKey(Studentjob studentjob);

    int updateByExampleSelective(@Param("record") Studentjob record, @Param("example") StudentjobExample example);

    int updateByExample(@Param("record") Studentjob record, @Param("example") StudentjobExample example);

    int updateByPrimaryKeySelective(Studentjob record);

    int updateByPrimaryKey(Studentjob record);

    List<Studentjob> queryByParam(@Param("sid")Integer sid, @Param("company")String company);

    void insertBatch(List<Studentjob> list);
}