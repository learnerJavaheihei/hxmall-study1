package com.hxzy.service;

import com.hxzy.entity.School;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;

import java.util.List;

public interface SchoolService {
    PageBean querylist();

    List<School> exportSchoolInfo();

    void saveBatch(List<School> list);

    R delete(Integer id);

    R insert(School record);

    PageBean selectAll(String name,String no,String address);

    R updateData(School school);

    R deleteAll(List<Integer> ids);
}
