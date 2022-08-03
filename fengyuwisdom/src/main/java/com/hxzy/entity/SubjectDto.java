package com.hxzy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ContentRowHeight(100)
@ColumnWidth(100 / 8)
public class SubjectDto {
    @ExcelProperty("学科")
    private Integer id;
    @ExcelProperty("学科")
    private String ename;
    @ExcelProperty("学科")
    private Integer weeks;
    @ExcelProperty("学科")
    private String syllabus;
    @ExcelProperty("学科")
    private Integer flag;
    @ExcelProperty("学科")
    private Date ctime;


}