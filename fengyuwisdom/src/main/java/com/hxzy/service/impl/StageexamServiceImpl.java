package com.hxzy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.hxzy.entity.Stageexam;
import com.hxzy.mapper.StageexamMapper;
import com.hxzy.service.StageexamService;
import com.hxzy.util.ExportExcel;
import com.hxzy.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class StageexamServiceImpl implements StageexamService {
    @Autowired
    StageexamMapper stageexamMapper;
    @Override
    public PageBean query() {
        List<Stageexam> stageexams = stageexamMapper.queryByStu();
        if(stageexams!=null){
            return new PageBean(0,"",stageexams.size(),stageexams);
        }
        return null;
    }

    @Override
    public int delete(List<Integer> sids) {
        return stageexamMapper.deleteByPrimaryKey(sids);
    }

    @Override
    public int deleteSingle(Integer sid) {
        return stageexamMapper.deleteById(sid);
    }

    @Override
    public void insert(Stageexam stageexam) {
        stageexamMapper.insert(stageexam);
    }

    @Override
    public Stageexam queryBySid(Stageexam stageexam) {
        return stageexamMapper.selectByPrimaryKey(stageexam);
    }

    @Override
    public void exportExcel(HttpServletResponse response) {
        List<Stageexam> stageexams = stageexamMapper.queryByStu();
        List<List<Object>> lists = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        for (int i = 0; i < stageexams.size(); i++) {
            String format = simpleDateFormat.format(stageexams.get(i).getCtime());
            List<Object> objectList=new ArrayList<>();
            objectList.add(stageexams.get(i).getId());
            objectList.add(stageexams.get(i).getSid());
            objectList.add(stageexams.get(i).getScore());
            objectList.add(stageexams.get(i).getInfo());
            objectList.add(stageexams.get(i).getStage());
            objectList.add(format);
            objectList.add(stageexams.get(i).getName());
            lists.add(objectList);
        }
        ExportExcel.exportFile("stageexaminfo",response,Stageexam.class,lists);
    }
    //条件查询
    @Override
    public PageBean queryByParam(Integer sid, Integer stage) {
        List<Stageexam> stageexams = stageexamMapper.queryByParam(sid, stage);
        return new PageBean(0,"",stageexams.size(),stageexams);
    }

    @Override
    public int update(Stageexam stageexam) {
        return stageexamMapper.updateByPrimaryKey(stageexam);
    }

    @Override
    public void addBatch(List<Stageexam> list) {

    }
}
