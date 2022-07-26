package com.hxzy.type;

public enum RCodeType {
    成功(10000),失败(10001);
    private int code;

    public int getCode() {
        return code;
    }
    private RCodeType(int c){
        code=c;
    }
}
