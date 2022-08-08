package com.hxzy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentDemoData {
    @ExcelProperty("字符串")
    private String string;
    @ExcelProperty("时间")
    private Data data;
    @ExcelProperty("数据")
    private Double doubleData;
}
