package com.hxzy.service.impl;


import com.hxzy.entity.Studentjob;
import com.hxzy.entity.StudentjobExample;
import com.hxzy.mapper.StudentjobMapper;
import com.hxzy.service.StudentjobService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StudentjobServiceImpl implements StudentjobService {
    @Autowired
    private StudentjobMapper studentjobMapper;

    //分页查询
    @Override
    public PageBean querylist() {
        List<Studentjob> list = studentjobMapper.selectByExample(new StudentjobExample());
        return new PageBean(0,"", list.size(), list);
    }

    //新增
    @Override
    public R save(Studentjob studentjob) {
        studentjob.setCtime(new Date(new java.util.Date().getTime()));
        int insert = studentjobMapper.insert(studentjob);
        return RUtil.ok();
    }

    //搜索
    @Override
    public PageBean queryByParam(Integer sid, String company) {
        List<Studentjob> list = studentjobMapper.queryByParam(sid,company);
        return new PageBean(0,"",list.size(),list);
    }

    //修改
    @Override
    public int update(Studentjob studentjob) {
        return studentjobMapper.updateByPrimaryKey(studentjob);
    }

    //导入
    @Override
    public void addBatch(List<Studentjob> list) {
        studentjobMapper.insertBatch(list);
    }

    //修改中的查询
    @Override
    public Studentjob queryBySid(Studentjob studentjob) {
        return studentjobMapper.selectByPrimaryKey(studentjob);}

}
