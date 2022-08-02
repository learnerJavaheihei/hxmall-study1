package com.hxzy.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer id;

    private String name;

    private String no;

    private String password;

    private Integer flag;
    /*
        验证码
    * */
    private String captcha;

    private String account;

    private String email;
}