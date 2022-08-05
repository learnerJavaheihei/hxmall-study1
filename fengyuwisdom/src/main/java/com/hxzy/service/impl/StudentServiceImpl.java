package com.hxzy.service.impl;

import com.hxzy.entity.Student;
import com.hxzy.entity.StudentExample;
import com.hxzy.mapper.StudentMapper;
import com.hxzy.service.StudentService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageBean querylist() {
        List<Student> students = studentMapper.selectByExample(new StudentExample());
        return  new PageBean(0,"",students.size(),students);
    }


    @Override
    public R insert(Student record) {
        int i = studentMapper.insertSelective(record);
        return RUtil.ok();
    }

    @Override
    public PageBean selectAll(String name, String no, Integer sex, String hometown, String education, String gradeName) {
        String trim = name.trim();
        String trim1 = no.trim();
        String trim3 = hometown.trim();
        String trim4 = education.trim();
        String trim5 = gradeName.trim();
        List<Student> students = studentMapper.selectAll(trim,trim1,sex,trim3,trim4,trim5);
        return new PageBean(0,"",students.size(),students);
    }


    @Override
    public R updateData(Student student) {
        int i = studentMapper.updateByPrimaryKey(student);
        if(i!=1){
            return RUtil.ok();
        }
        return  RUtil.fail();
    }

    @Override
    public R deleteAll(List<Integer> ids) {
        int i = studentMapper.deleteByExample(ids);
        return RUtil.ok();
    }


    @Override
    public List<Student> exportStudentInfo() {
        return studentMapper.selectByExample(new StudentExample());
    }

    @Override
    public void saveBatch(List<Student> list) {
        studentMapper.saveBatch(list);
    }

    @Override
    public R delete(@Param("id") Integer id) {
        int i = studentMapper.deleteByPrimaryKey(id);
        return RUtil.ok();
    }


}
