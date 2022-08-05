package com.hxzy.mapper;

import com.hxzy.entity.Student;
import com.hxzy.entity.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(@Param("ids") List<Integer> ids);

    int deleteByPrimaryKey(Integer id);


    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    void saveBatch(List<Student> list);

    List<Student> selectAll(@Param("name")String name,@Param("no")String no,@Param("sex")Integer sex,@Param("hometown") String hometown,@Param("education")String education,@Param("gradeName")String gradeName);

}