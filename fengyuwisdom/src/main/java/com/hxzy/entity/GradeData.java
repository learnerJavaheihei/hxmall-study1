package com.hxzy.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TGrade)实体类
 *
 * @author makejava
 * @since 2022-07-31 21:39:05
 */
@Data
public class GradeData implements Serializable {
    private static final long serialVersionUID = -82230656484955806L;
    
    private Integer id;
    
    private String name;
    
    private String address;
    
    private Integer sid;
    /**
     * 容量
     */
    private Integer apacity;
    
    private Date sdate;
    
    private Date edate;

}

