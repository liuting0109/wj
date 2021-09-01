package com.evan.wj.result;

/**
 * @Auther: liuting
 * @Date: 2021/9/1 10:30
 * @Description:
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code){
        this.code = code;
    }
}
