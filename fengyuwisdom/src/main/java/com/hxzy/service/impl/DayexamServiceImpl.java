package com.hxzy.service.impl;


import com.hxzy.entity.DayexamDto;
import com.hxzy.mapper.DayexamDtoMapper;
import com.hxzy.service.DayexamService;
import com.hxzy.util.ExportExcel;
import com.hxzy.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DayexamServiceImpl implements DayexamService {
    @Autowired
    DayexamDtoMapper dayexamDtoMapper;
    @Override
    public PageBean query() {
        List<DayexamDto> dayexamDtos = dayexamDtoMapper.queryByStu();
        if(dayexamDtos!=null){
            return new PageBean(0,"",dayexamDtos.size(),dayexamDtos);
        }
        return null;
    }

    @Override
    public int delete(List<Integer> sids) {
        return dayexamDtoMapper.deleteByPrimaryKey(sids);
    }

    @Override
    public int deleteSingle(Integer sid) {
        return dayexamDtoMapper.deleteById(sid);
    }

    @Override
    public void insert(DayexamDto dayexamDto) {
        dayexamDtoMapper.insert(dayexamDto);
    }

    @Override
    public DayexamDto queryBySid(DayexamDto dayexamDto) {
        return dayexamDtoMapper.selectByPrimaryKey(dayexamDto);
    }
    //导出excel
    @Override
    public void exportExcel(HttpServletResponse response) {
        List<DayexamDto> dayexamDtos= dayexamDtoMapper.queryByStu();
        List<List<Object>> lists = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        for (int i = 0; i < dayexamDtos.size(); i++) {
            String format = simpleDateFormat.format(dayexamDtos.get(i).getCdate());
            String ctime = simpleDateFormat.format(dayexamDtos.get(i).getCtime());
            List<Object> objectList=new ArrayList<>();
            objectList.add(dayexamDtos.get(i).getId());
            objectList.add(dayexamDtos.get(i).getSid());
            objectList.add(dayexamDtos.get(i).getScore());
            objectList.add(dayexamDtos.get(i).getInfo());
            objectList.add(format);
            objectList.add(ctime);
            objectList.add(dayexamDtos.get(i).getName());
            lists.add(objectList);
        }
        ExportExcel.exportFile("dayTextInfo",response,DayexamDto.class,lists);
    }

    @Override
    public PageBean queryByParam(String name, String cdate) {
        List<DayexamDto> dayexamDtos = dayexamDtoMapper.queryByParam(name, cdate);
        return new PageBean(0,"",dayexamDtos.size(),dayexamDtos);
    }

    @Override
    public int update(DayexamDto dayexamDto) {
        return dayexamDtoMapper.updateByPrimaryKey(dayexamDto);
    }

    @Override
    public void addBatch(List<DayexamDto> list) {
        for (DayexamDto dayexamDto : list) {
            System.out.println(dayexamDto);
        }

        dayexamDtoMapper.insertBatch(list);
    }
}
