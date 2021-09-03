package com.evan.wj.result;

import lombok.Data;
/**
 * @Author: liuting
 * @Date: 2021/8/26 09:42
 * @Description:
 */
@Data
public class Result {
    //响应码
    private int code;

    private String message;

    private Object result;

    public Result(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.result = data;
    }

}
