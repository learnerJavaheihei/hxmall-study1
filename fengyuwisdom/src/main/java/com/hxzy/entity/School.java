package com.hxzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class School {
    private Integer id;

    private String name;

    private String no;

    private String address;

    @JsonFormat(pattern ="yyyy-MM-dd ",timezone ="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd ")
    private Date ctime;


}