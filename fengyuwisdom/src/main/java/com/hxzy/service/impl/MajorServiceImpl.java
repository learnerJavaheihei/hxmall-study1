package com.hxzy.service.impl;


import com.hxzy.entity.MajorDto;
import com.hxzy.entity.MajorDtoExample;
import com.hxzy.mapper.MajorDtoMapper;
import com.hxzy.service.MajorService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorDtoMapper majorDtoMapper;


    //分页
    @Override
    public PageBean selectAll() {
        List<MajorDto> list = majorDtoMapper.selectByExample(new MajorDtoExample());
       return  new PageBean(0,"", list.size(), list);
    }
    //添加
    @Override
    public R insertAll(MajorDto record) {
        int insert = majorDtoMapper.insert(record);
        return RUtil.ok();
    }
    //批量删除
    @Override
    public R deleteALL(List<Integer> ids) {
        int i = majorDtoMapper.deleteByExample(ids);
        return RUtil.ok();
    }
    //修改
    @Override
    public R updateAll(MajorDto majorDto) {
        int i = majorDtoMapper.updateByPrimaryKey(majorDto);
        return RUtil.ok();
    }

    @Override
    public R deleteAll(Integer uuid) {
        int i = majorDtoMapper.deleteByPrimaryKey(uuid);
        return  RUtil.ok();
    }
    //搜索

    @Override
    public PageBean selectAlla(String sname, String major) {
        String trim = sname.trim();
        String trim1 = major.trim();
        List<MajorDto> majorDtos = majorDtoMapper.selectData(trim,trim1);

        return   new PageBean(0,"",majorDtos.size(),majorDtos);
    }


}

