package com.ricky.clothes.web.controller;

import com.hujiang.rocky.common.exceptions.CommonException;
import com.hujiang.rocky.common.model.Result;
import com.hujiang.rocky.common.model.ResultBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hujiang.rocky.web.controller.BaseController;

public class BaseAppController extends BaseController {

    /**
     * 用于处理通用异常
     *
     * @return
     */
    @ExceptionHandler({ Exception.class })
//    @ResponseBody
    public String exception(Exception e) {
        logger.debug("got a Exception",e);

        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
//        String message = e.getMessage();

//        if (e instanceof CommonException){
//            status = ((CommonException) e).getCode();
//        }

//        return new ResultBuilder<String>().status(status).message(message).build();
        return "error";
    }
}


