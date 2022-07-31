package com.hxzy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hxzy.entity.DayexamDto;
import com.hxzy.service.DayexamService;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelLinstener extends AnalysisEventListener<DayexamDto> {
    public static final int BATCH_COUNT = 3;
    List<DayexamDto> list=new ArrayList<>();
    DayexamService dayexamService;

    public EasyExcelLinstener() {
    }

    public EasyExcelLinstener(DayexamService dayexamService) {
        this.dayexamService = dayexamService;
    }

    @Override
    public void invoke(DayexamDto dayexamDto, AnalysisContext analysisContext) {
        list.add(dayexamDto);
        if(list.size()>=BATCH_COUNT){
            addBatch();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        addBatch();
    }

    private void addBatch(){
        dayexamService.addBatch(list);
    }
}
