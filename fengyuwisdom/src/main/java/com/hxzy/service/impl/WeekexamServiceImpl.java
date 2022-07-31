package com.hxzy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.Weekexam;
import com.hxzy.mapper.WeekexamMapper;
import com.hxzy.service.WeekexamService;
import com.hxzy.util.ExportExcel;
import com.hxzy.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class WeekexamServiceImpl implements WeekexamService {
    @Autowired
    WeekexamMapper weekexamMapper;

    @Override
    public PageBean query() {
        List<Weekexam> weekexams = weekexamMapper.queryByStu();
        if(weekexams!=null){
            return new PageBean(0,"",weekexams.size(),weekexams);
        }
        return null;
    }

    @Override
    public int delete(List<Integer> sids) {
        return weekexamMapper.deleteByPrimaryKey(sids);
    }

    @Override
    public int deleteSingle(Integer sid) {
        return weekexamMapper.deleteById(sid);
    }

    @Override
    public void insert(Weekexam weekexam) {
        weekexamMapper.insert(weekexam);
    }

    @Override
    public Weekexam queryBySid(Weekexam week) {
        return weekexamMapper.selectByPrimaryKey(week);
    }
    //导出excel
    @Override
    public void exportExcel(HttpServletResponse response) {
        List<Weekexam> weekexams = weekexamMapper.queryByStu();
        List<List<Object>> lists = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        for (int i = 0; i < weekexams.size(); i++) {
            String format = simpleDateFormat.format(weekexams.get(i).getCtime());
            List<Object> objectList=new ArrayList<>();
            objectList.add(weekexams.get(i).getId());
            objectList.add(weekexams.get(i).getSid());
            objectList.add(weekexams.get(i).getScore());
            objectList.add(weekexams.get(i).getInfo());
            objectList.add(weekexams.get(i).getWeek());
            objectList.add(format);
            objectList.add(weekexams.get(i).getName());
            lists.add(objectList);
        }
        ExportExcel.exportFile("weekexaminfo",response,Weekexam.class,lists);
    }

    @Override
    public PageBean queryByParam(Integer sid, Integer wid) {
        List<Weekexam> weekexams = weekexamMapper.queryByParam(sid, wid);
        return new PageBean(0, "", weekexams.size(), weekexams);
    }

    @Override
    public int update(Weekexam weekexam) {
        return weekexamMapper.updateByPrimaryKey(weekexam);
    }

    @Override
    public void addBatch(List<Weekexam> list) {
        weekexamMapper.insertBatch(list);
    }
}
