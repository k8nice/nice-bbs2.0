package com.nice.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应Error类型异常的实体类
 * @author ningh
 */
@Data
@AllArgsConstructor
public class ErrorResponseEntity {

    /**
     * 错误代码
     */
    private int code;
    /**
     * 错误信息
     */
    private String message;

}
