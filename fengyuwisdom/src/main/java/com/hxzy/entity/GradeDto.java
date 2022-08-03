package com.hxzy.entity;



import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ContentRowHeight(100)
@ColumnWidth(100 / 8)
public class GradeDto {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("名字")
    private String name;

    @ExcelProperty("教室位置")
    private String address;

    @ExcelProperty("学科")
    private Integer sid;

    @ExcelProperty("教室容量")
    private Integer apacity;

    @ExcelProperty("入学日期")
    /*出参注解*/
    @JsonFormat(pattern ="yyyy-MM-dd",timezone ="GMT+8")
    /*此处是spring的入参注解*/
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date sdate;

    @ExcelProperty("毕业日期")
    @JsonFormat(pattern ="yyyy-MM-dd ",timezone ="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date edate;

    @ExcelProperty("你好" )
    private SubjectDto subjectDto;


}