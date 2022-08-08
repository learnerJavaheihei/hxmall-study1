package com.hxzy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hxzy.entity.Student;
import com.hxzy.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelStuListener extends AnalysisEventListener<Student> {

    //定义集合存储元素
    List<Student> list = new ArrayList<>();
    //定义最大值
    public static final int BATCH_COUNT = 3;
    //导入service
    StudentService studentService;

    public EasyExcelStuListener(){

    }

    public EasyExcelStuListener(StudentService studentService){
        this.studentService = studentService;
    }
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        list.add(student);
        if (list.size()>=BATCH_COUNT){
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData(){
        studentService.saveBatch(list);
    }
}
