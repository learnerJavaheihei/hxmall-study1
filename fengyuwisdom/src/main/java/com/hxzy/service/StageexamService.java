package com.hxzy.service;

import com.hxzy.entity.Stageexam;
import com.hxzy.entity.Weekexam;
import com.hxzy.vo.PageBean;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface StageexamService {

    PageBean query();
    //批量删除或单个删除均可
    int delete(List<Integer> sids);

    int deleteSingle(Integer sid);

    void insert(Stageexam stageexam);

    Stageexam queryBySid(Stageexam stageexam);

    void exportExcel(HttpServletResponse response);

    PageBean queryByParam(Integer sid,Integer stage);

    int update(Stageexam stageexam);

    void addBatch(List<Stageexam> list);

}
