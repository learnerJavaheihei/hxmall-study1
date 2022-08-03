package com.hxzy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hxzy.entity.Studentjob;
import com.hxzy.service.StudentjobService;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelSutdentjobLinstener extends AnalysisEventListener<Studentjob> {
    public static final int BATCH_COUNT = 3;
    List<Studentjob> list = new ArrayList<>();
    StudentjobService studentjobService;

    @Override
    public void invoke(Studentjob studentjob, AnalysisContext analysisContext) {
        list.add(studentjob);
        if (list.size() >= BATCH_COUNT) {
            addBatch();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        addBatch();
    }


    public EasyExcelSutdentjobLinstener(StudentjobService studentjobService) {
        this.studentjobService = studentjobService;
    }

    private void addBatch() {
        studentjobService.addBatch(list);
    }
}