package com.hxzy.service;


import com.hxzy.entity.MajorDto;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;

import java.util.List;

public interface MajorService {
    //分页
    PageBean selectAll();
    //添加
    R insertAll(MajorDto record);
    //删除
    R deleteALL(List<Integer> ids);
    //修改
    R updateAll(MajorDto majorDto);
    //删除
    R deleteAll(Integer uuid);
    //搜索
    PageBean selectAlla(String sname ,String major);


}
