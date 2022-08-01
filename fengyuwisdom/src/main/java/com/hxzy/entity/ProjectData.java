package com.hxzy.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TProject)实体类
 *
 * @author makejava
 * @since 2022-07-31 21:39:20
 */
@Data
public class ProjectData implements Serializable {
    private static final long serialVersionUID = 413983853984015264L;
    
    private Integer id;
    
    private String name;
    
    private Date sdate;
    
    private Date edate;
    
    private String srcurl;
    
    private String info;
    
    private Date ctime;


}

