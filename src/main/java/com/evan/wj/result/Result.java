package com.evan.wj.result;

/**
 * @Auther: liuting
 * @Date: 2021/8/26 09:42
 * @Description:
 */
public class Result {
    //响应码
    private int code;

    public Result(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
