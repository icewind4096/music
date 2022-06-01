package com.windvalley.music.common.base.handler;

import com.windvalley.music.common.base.exception.WindvalleyException;
import com.windvalley.music.common.base.result.R;
import com.windvalley.music.common.base.result.ResultCodeEnum;
import com.windvalley.music.common.base.util.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//控制器切面
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //需要精细捕获的异常，在此处添加

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(HttpMessageNotReadableException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseBody
    public R error(AccessDeniedException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error().message(ResultCodeEnum.FORBIDDEN_REASON.getMessage()).code(ResultCodeEnum.FORBIDDEN_REASON.getCode());
    }

    @ExceptionHandler(WindvalleyException.class)
    @ResponseBody
    public R error(WindvalleyException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
