package com.yong.employee.advice;

import com.yong.employee.base.BaseErrorCode;
import com.yong.employee.base.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

    public ExceptionAdvice() {
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BindException.class})
    public ResponseResult validateErrorHandler(BindException e) {
        List<ObjectError> error = e.getAllErrors();
        ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, error.stream().map(err -> err.getDefaultMessage()).collect(Collectors.joining(",")));
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseResult validateErrorHandler(MethodArgumentNotValidException e) {
        StringBuilder msg = new StringBuilder();
        for (ObjectError error : e.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
        }
        ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, msg.toString());
        log.warn("参数校验错误(MethodArgumentNotValidException)：{}", msg.toString());
        return result;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult handleException(HttpServletRequest request, Exception e) {
        log.error("ExceptionAdvice拦截Exception,异常信息:{},异常堆栈：{}", e.getMessage(), e);
        ResponseResult result = ResponseResult.error(BaseErrorCode.SYSTEM_ERROR, e.getMessage());
        return result;
    }
}
