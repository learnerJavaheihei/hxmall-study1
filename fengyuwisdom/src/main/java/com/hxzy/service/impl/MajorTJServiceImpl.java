package com.hxzy.service.impl;


import com.hxzy.entity.MajorSexDto;

import com.hxzy.entity.MajorTJDto;
import com.hxzy.mapper.MajorDtoMapper;
import com.hxzy.service.MajorTJService;

import com.hxzy.util.RUtil;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MajorTJServiceImpl implements MajorTJService {
    @Autowired
    MajorDtoMapper majorDtoMapper;


    @Override
    public R getMajorTJ() {
        List<MajorSexDto> majorSexDtos = majorDtoMapper.stuSexTj();
//        将数据包装成echarts需要的格式
        if(majorSexDtos !=null && majorSexDtos.size()>0){
            List<String> sexs=new ArrayList<>();
            ArrayList<Map<String,Object>> sexvalue = new ArrayList<>();
            //遍历studentDtoMapper,封装数据
            for (MajorSexDto majorSexDto : majorSexDtos) {
                //添加名字到sexs的集合为第一个data
                String sex = majorSexDto.getSname();
                sexs.add(sex);
                //添加名字到的集合为第一个data
                HashMap<String, Object> value = new HashMap<>();
                value.put("name",sex);
                value.put("value",majorSexDto.getCt());
                System.out.println(value);
                sexvalue.add(value);

            }
            MajorTJDto majorTJDto = new MajorTJDto();
            majorTJDto.setSexs(sexs);
            majorTJDto.setValues(sexvalue);
            return RUtil.ok(majorTJDto);

        }

        return RUtil.fail();
    }
}
