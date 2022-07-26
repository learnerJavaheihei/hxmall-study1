package com.hxzy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: FengYuWisdom
 * @description:
 * @author: guohongliang
 * @create: 2022-07-18 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private int code;//成功0
    private String msg;
    private long count;
    private Object data;
}
