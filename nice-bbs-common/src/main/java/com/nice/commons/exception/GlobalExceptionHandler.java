package com.nice.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 全局异常处理
 * @author ningh
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ErrorResponseEntiry customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        CustomException exception = (CustomException) e;
        return new  ErrorResponseEntiry(exception.getCode(),exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseEntiry runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception = (RuntimeException) e;
        return new ErrorResponseEntiry(400,exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<> (new ErrorResponseEntiry(status.value(),exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()),status);
        }

        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            LOGGER.error("参数转换失败,方法:" + exception.getParameter().getMethod().getName() + ",参数:" + exception.getName() + ",信息: " + exception.getLocalizedMessage());
            return new ResponseEntity<> (new ErrorResponseEntiry(status.value(),"参数转换失败"),status);
        }

        if (ex instanceof NullPointerException) {
            NullPointerException exception = (NullPointerException) ex;
            LOGGER.error("参数出现空指针,信息:" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponseEntiry(status.value(),"参数空指针"),status);
        }

        if (ex instanceof HttpMessageNotWritableException) {
            HttpMessageNotWritableException exception = (HttpMessageNotWritableException) ex;
            LOGGER.error("参数转换为json失败,方法:" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponseEntiry(status.value(),"参数有误"),status);
        }


        return new ResponseEntity<>(new ErrorResponseEntiry(status.value(),"参数转换失败"),status);
    }
}
