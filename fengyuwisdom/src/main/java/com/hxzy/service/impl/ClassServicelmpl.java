package com.hxzy.service.impl;


import com.hxzy.entity.GradeDto;
import com.hxzy.entity.GradeDtoExample;
import com.hxzy.mapper.GradeDtoMapper;
import com.hxzy.service.AdminService;
import com.hxzy.service.ClassService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServicelmpl implements ClassService {

    @Autowired
    private GradeDtoMapper gradeDtoMapper;
    @Autowired
    private AdminService adminService;

    //分页
    @Override
    public PageBean queryList() {
        List<GradeDto> list = gradeDtoMapper.selectByExample(new GradeDtoExample());

        return new PageBean(0, "", list.size(), list);
    }

    //搜索
    @Override
    public PageBean selectAll(String name, String address) {
        String trim = name.trim();
        String trim1 = address.trim();
        List<GradeDto> gradeDtos = gradeDtoMapper.selectAll(trim, trim1);
        return new PageBean(0, "", gradeDtos.size(), gradeDtos);
    }


    //添加
    @Override
    public R insertData(GradeDto record) {
        int i = gradeDtoMapper.insertSelective(record);
        return RUtil.ok();

    }

    //修改
    @Override
    public R updateData(GradeDto gradeDto) {
        int i = gradeDtoMapper.updateByPrimaryKey(gradeDto);
        return RUtil.ok();
    }

    //删除所有
    @Override
    public R deleteALL(List<Integer> ids) {
//        GradeDtoExample gradeDtoExample = new GradeDtoExample();
//        gradeDtoExample.createCriteria().andIdIn(ids);
        int i = gradeDtoMapper.deleteByExample(ids);
        return RUtil.ok();
    }



    //删除
    @Override
    public R deleteDate(@Param("id") Integer id) {
        int i = gradeDtoMapper.deleteByPrimaryKey(id);
        return RUtil.ok();


    }
    //
    @Override
    public List<GradeDto> exportAdminInfo() {

        return gradeDtoMapper.selectByExample(new GradeDtoExample());
    }


}
