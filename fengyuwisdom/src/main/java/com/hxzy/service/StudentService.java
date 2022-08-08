package com.hxzy.service;


import com.hxzy.entity.Student;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;

import java.util.List;

public interface StudentService {
    PageBean querylist();


    List<Student> exportStudentInfo();

    void saveBatch(List<Student> list);

    R delete(Integer id);

    R insert(Student record);

    PageBean selectAll(String name,String no,Integer sex,String hometown,String education,String gradeName);

    R updateData(Student student);

    R deleteAll(List<Integer> ids);
}
