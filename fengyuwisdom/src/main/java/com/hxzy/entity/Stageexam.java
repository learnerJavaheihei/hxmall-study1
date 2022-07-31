package com.hxzy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxzy.converter.ExcelConverter;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;
@Data
@ContentRowHeight(40)
@ColumnWidth(100 / 8)
public class Stageexam {

    @ExcelProperty("编号")
    private Integer id;

    @ExcelProperty("学号")
    @Pattern(regexp = "^\\d{4}$",message = "学号必须是4位纯数字")
    private Integer sid;

    @ExcelProperty("分数")
    @Pattern(regexp = "^(?:0|[1-9][0-9]?|100)(\\.[0-9]{0,2})?$",message = "分数必须是0-100之间")
    private Integer score;

    @ExcelProperty("信息")
    @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]+$",message = "必须是中文或英文")
    private String info;

    @ExcelProperty("阶段")
    @Pattern(regexp ="[1-4]",message = "1-4之间的整数")
    private Integer stage;

    @ExcelProperty(value="创建时间",converter = ExcelConverter.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ColumnWidth(20)
    private Date ctime;

    //学生姓名
    @ExcelProperty("学生姓名")
    private String name;
}