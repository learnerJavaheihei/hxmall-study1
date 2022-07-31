package com.hxzy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.Weekexam;
import com.hxzy.service.DayexamService;
import com.hxzy.service.WeekexamService;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelWeekLinstener extends AnalysisEventListener<Weekexam> {
    public static final int BATCH_COUNT = 3;
    List<Weekexam> list=new ArrayList<>();
    WeekexamService weekexamService;

    public EasyExcelWeekLinstener() {
    }

    public EasyExcelWeekLinstener(WeekexamService weekexamService) {
        this.weekexamService = weekexamService;
    }

    @Override
    public void invoke(Weekexam weekexam, AnalysisContext analysisContext) {
        list.add(weekexam);
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
        weekexamService.addBatch(list);
    }
}
