package com.nice.commons.exception;

import lombok.Data;

/**
 * 自定义异常
 * @author ningh
 */
@Data
public class CustomException extends RuntimeException{

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(int code,String message) {
        super(message);
        this.setCode(code);
    }

}
