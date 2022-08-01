package com.hxzy.service.impl;

import com.hxzy.mapper.InfoDtoMapper;
import com.hxzy.service.FirstPageDatasService;
import com.hxzy.service.FirstPageUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FirstPageDatasServiceImpl implements FirstPageDatasService {
    @Autowired
    InfoDtoMapper infoDtoMapper;
    @Autowired
    FirstPageUtilService firstPageUtilService;

    //包装流量数据
    @Override
    public List<Map<String, Object>> getAttributes() {
        List<Map<String, Object>> retu = new ArrayList<>();

        List<String> titles = firstPageUtilService.getTiles();
        int i=0;
        while (i< titles.size()){
            Map<String, Object> map=new HashMap<>();
            switch (i){
                case 0:
                    map.put("name",titles.get(0));
                    map.put("type","line");
                    //拿到需要统计的时间对应的数量
                    List<Integer> stuNumByDate = firstPageUtilService.getStuNumByDate();
                    map.put("data",stuNumByDate);
                    retu.add(map);
                    i++;
                    break;
                case 1:
                    map.put("name",titles.get(1));
                    map.put("type","line");
                    //拿到需要统计的时间对应的数量
                    List<Integer> gradeNumByDate = firstPageUtilService.getGradeNumByDate();
                    map.put("data",gradeNumByDate);
                    retu.add(map);
                    i++;
                    break;
                case 2:
                    map.put("name",titles.get(2));
                    map.put("type","line");
                    //拿到需要统计的时间对应的数量
                    List<Integer> complaintNumByDate = firstPageUtilService.getComplaintNumByDate();
                    map.put("data",complaintNumByDate);
                    retu.add(map);
                    i++;
                    break;
                case 3:
                    map.put("name",titles.get(3));
                    map.put("type","line");
                    //拿到需要统计的时间对应的数量
                    List<Integer> projectNumByDate = firstPageUtilService.getProjectNumByDate();
                    map.put("data",projectNumByDate);
                    retu.add(map);
                    i++;
                    break;
            }
        }
        return retu;
    }
}
