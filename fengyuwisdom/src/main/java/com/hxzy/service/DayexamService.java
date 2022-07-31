package com.hxzy.service;

import com.hxzy.entity.DayexamDto;
import com.hxzy.vo.PageBean;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DayexamService {
    PageBean query();
    //批量删除
    int delete(List<Integer> sids);
    //单个删除均可
    int deleteSingle(Integer sids);

    void insert(DayexamDto dayexamDto);

    DayexamDto queryBySid(DayexamDto dayexamDto);

    void exportExcel(HttpServletResponse response);

    PageBean queryByParam(String name,String cdate);

    int update(DayexamDto dayexamDto);

    void addBatch(List<DayexamDto> list);
}
