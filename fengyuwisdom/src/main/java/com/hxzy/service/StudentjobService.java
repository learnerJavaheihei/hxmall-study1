package com.hxzy.service;

import com.hxzy.entity.Studentjob;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;

import java.util.List;

public interface StudentjobService {
    PageBean querylist();

    R save(Studentjob studentjob);

    PageBean queryByParam(Integer sid, String company);

    Studentjob queryBySid(Studentjob studentjob);

    int update(Studentjob studentjob);

    void addBatch(List<Studentjob> list);
}
