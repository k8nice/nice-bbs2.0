package com.nice.commons.exception;

import lombok.Data;

/**
 * 自定义异常
 * @author ningh
 */
@Data
public class CustomException extends RuntimeException{

    /**
     * 错误代码
     */
    private int code;

    /**
     * 无参构造
     */
    public CustomException() {
        super();
    }

    /**
     * 有参构造
     * @param code 错误代码
     * @param message 错误信息
     */
    public CustomException(int code,String message) {
        super(message);
        this.setCode(code);
    }

}
