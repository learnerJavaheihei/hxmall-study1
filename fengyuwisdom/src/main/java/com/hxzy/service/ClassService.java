package com.hxzy.service;

import com.hxzy.entity.GradeDto;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;

import java.util.List;


public interface ClassService {
    PageBean queryList();

    //搜索
    PageBean selectAll(String name, String address);

    //删除
    R deleteDate(Integer id);

    //添加
    R insertData(GradeDto record);

    //修改
    R updateData(GradeDto gradeDto);


    //    List<GradeDto> selectData(String name);
    //删除所有
    R deleteALL(List<Integer> ids);
    //excel导出文件
 List<GradeDto> exportAdminInfo();


}
