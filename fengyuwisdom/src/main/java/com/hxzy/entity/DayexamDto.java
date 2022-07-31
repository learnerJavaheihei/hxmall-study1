package com.hxzy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxzy.converter.ExcelConverter;
import lombok.Data;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Data
@ContentRowHeight(40)
@ColumnWidth(100 / 8)
public class DayexamDto {
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

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ExcelProperty(value = "考试时间",converter = ExcelConverter.class)
    @ColumnWidth(20)
    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$",message = "格式：2000-01-01")
    private Date cdate;

    @ExcelProperty(value="创建时间",converter = ExcelConverter.class)
    @ColumnWidth(20)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ctime;

    //学生名
    @ExcelProperty("学生姓名")
    private String name;

}