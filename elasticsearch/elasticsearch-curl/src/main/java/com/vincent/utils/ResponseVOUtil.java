package com.vincent.utils;

import com.vincent.vo.ResponseResult;
import org.springframework.http.HttpStatus;

public class ResponseVOUtil {

    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(HttpStatus.OK.value());
        responseResult.setMessage("success");
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult failed(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseResult.setMessage("failed");
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult exception(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(501);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult error(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(501);
        responseResult.setMessage(message);
        return responseResult;
    }

}
