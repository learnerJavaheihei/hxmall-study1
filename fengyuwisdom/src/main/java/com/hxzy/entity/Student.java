package com.hxzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
@Data
public class Student {
    private Integer id;

    private String no;

    private String name;

    private Integer sex;

    private String hometown;

    private String education;

    private Integer gid;

    @JsonFormat(pattern ="yyyy-MM-dd ",timezone ="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd ")
    private Date ctime;

    private String gradeName;

}