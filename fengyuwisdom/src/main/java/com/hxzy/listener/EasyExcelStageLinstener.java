package com.hxzy.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hxzy.entity.Stageexam;
import com.hxzy.service.StageexamService;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelStageLinstener extends AnalysisEventListener<Stageexam> {
    public static final int BATCH_COUNT = 3;
    List<Stageexam> list=new ArrayList<>();
    StageexamService stageexamService;

    public EasyExcelStageLinstener() {
    }

    public EasyExcelStageLinstener(StageexamService stageexamService) {
        this.stageexamService = stageexamService;
    }

    @Override
    public void invoke(Stageexam stageexam, AnalysisContext analysisContext) {
        list.add(stageexam);
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
        stageexamService.addBatch(list);
    }
}
