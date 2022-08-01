package com.hxzy.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TComplaint)实体类
 *
 * @author makejava
 * @since 2022-07-31 21:40:00
 */
@Data
public class ComplaintData implements Serializable {
    private static final long serialVersionUID = -29472891807234023L;
    
    private Integer id;
    
    private Integer sid;
    
    private String info;
    /**
     * 标记位 1.未处理 2.已处理
     */
    private Integer flag;
    /**
     * 处理人
     */
    private Integer aid;
    /**
     * 处理结果
     */
    private String handle;
    
    private Date ctime;

}

