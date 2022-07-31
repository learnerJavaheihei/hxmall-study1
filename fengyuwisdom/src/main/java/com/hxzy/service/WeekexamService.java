package com.hxzy.service;

import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.Weekexam;
import com.hxzy.vo.PageBean;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface WeekexamService {
    PageBean query();
    //批量删除或单个删除均可
    int delete(List<Integer> sids);

    int deleteSingle(Integer sids);

    void insert(Weekexam weekexam);

    Weekexam queryBySid(Weekexam week);

    void exportExcel(HttpServletResponse response);

    PageBean queryByParam(Integer sid,Integer wid);

    int update(Weekexam weekexam);

    void addBatch(List<Weekexam> list);
}
