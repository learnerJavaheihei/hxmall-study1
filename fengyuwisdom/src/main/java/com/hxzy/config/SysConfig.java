package com.hxzy.config;

public class SysConfig {
    public static  final  String CURRENTUSER =" curruser";

    //记录管理员操作日志的类型
    public static final int ALOG_TYPE_ADD=1;//新增
    public static final int ALOG_TYPE_LS=2;//登陆成功
    public static final int ALOG_TYPE_LE=3;//登陆失败
    public static final int ALOG_TYPE_UP=4;//修改密码
    public static final int ALOG_TYPE_OUT=5;//退出登陆
}
