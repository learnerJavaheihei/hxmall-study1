package com.hxzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class ComplaintDto {
    private Integer id;

    private Integer sid;

    private String info;

    private Integer flag;

    private Integer aid;

    private String handler;
    private  Admin admin;
    @JsonFormat(pattern ="yyyy-MM-dd",timezone ="GMT+8")
    /*此处是spring的入参注解*/
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date ctime;


}