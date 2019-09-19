package com.nice.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ningh
 */
@Data
@AllArgsConstructor
public class ErrorResponseEntiry {

    private int code;
    private String message;

}
