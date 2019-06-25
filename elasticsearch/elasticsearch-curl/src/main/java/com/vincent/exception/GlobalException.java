package com.vincent.exception;

import com.vincent.utils.ResponseVOUtil;
import com.vincent.vo.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseResult exceptionHandler(Exception e) {
        e.printStackTrace();
        return ResponseVOUtil.exception(e.getMessage());
    }

    @ExceptionHandler(value = {MyException.class})
    @ResponseBody
    public ResponseResult myExceptionHandler(Exception e) {
        return ResponseVOUtil.exception(e.getMessage());
    }

}
