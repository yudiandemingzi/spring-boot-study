package com.jincou.validation.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.StringJoiner;

/**
 * @author xub
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringJoiner joiner = new StringJoiner(",");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            joiner.add(fieldError.getField()).add(":").add(fieldError.getDefaultMessage());
        }
        String msg = joiner.toString();
       return Result.fail(BusinessCode.MISSING_PARAMETERS, msg);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        return Result.fail(BusinessCode.MISSING_PARAMETERS, ex.getMessage());
    }

    @ExceptionHandler({NotReadablePropertyException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleNotReadablePropertyException(NotReadablePropertyException ex) {
        return Result.fail(BusinessCode.MISSING_PARAMETERS, ex.getMessage());
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleException(Exception ex) {
        log.error("未知系统错误", ex);
        return Result.fail(BusinessCode.MISSING_PARAMETERS, ex.getMessage());
    }
}
