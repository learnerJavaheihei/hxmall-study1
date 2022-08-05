package com.hxzy.service.impl;

import com.hxzy.entity.School;
import com.hxzy.entity.SchoolExample;
import com.hxzy.mapper.SchoolMapper;
import com.hxzy.service.SchoolService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;
    @Override
    public PageBean querylist() {
        List<School> schools = schoolMapper.selectByExample(new SchoolExample());
        return new PageBean(0,"",schools.size(),schools);
    }

    @Override
    public List<School> exportSchoolInfo() {
        return schoolMapper.selectByExample(new SchoolExample());
    }

    @Override
    public void saveBatch(List<School> list) {
        schoolMapper.saveBatch(list);
    }

    @Override
    public R delete(Integer id) {
        int i = schoolMapper.deleteByPrimaryKey(id);
        return RUtil.ok();
    }

    @Override
    public R insert(School record) {
        int i = schoolMapper.insertSelective(record);
        return RUtil.ok();
    }

    @Override
    public PageBean selectAll(String name, String no,String address) {
        String trim = name.trim();
        String trim1 = no.trim();
        String trim2 = address.trim();
        List<School> schools = schoolMapper.selectAll(trim,trim1,trim2);
        return new PageBean(0,"",schools.size(),schools);
    }

    @Override
    public R updateData(School school) {
        int i = schoolMapper.updateByPrimaryKey(school);
        return RUtil.ok();
    }

    @Override
    public R deleteAll(List<Integer> ids) {
        int i = schoolMapper.deleteByExample(ids);
        return RUtil.ok();
    }
}
