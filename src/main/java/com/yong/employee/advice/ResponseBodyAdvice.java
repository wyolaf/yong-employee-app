package com.yong.employee.advice;

import com.yong.employee.base.BaseErrorCode;
import com.yong.employee.base.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@ControllerAdvice
public class ResponseBodyAdvice implements org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice {
    private static final List<String> IGNORE_URL = Arrays.asList("swagger-resources", "api-docs", "actuator",
            "health", "metrics", "prometheus", "swagger-json");
    private static final String HTTP_STATUS_CODE = "status";

    public ResponseBodyAdvice() {
    }

    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletRequest httpRequest = ((ServletServerHttpRequest)request).getServletRequest();
        String url = httpRequest.getRequestURL().toString();
        boolean ignore = IGNORE_URL.stream().anyMatch((item) -> {
            return url.contains(item);
        });
        if (ignore) {
            return body;
        } else {
            ResponseResult success;
            if (body == null) {
                success = ResponseResult.success();
                return success;
            } else if (body instanceof ResponseResult) {
                success = (ResponseResult)body;
                return body;
            } else {
                if (body instanceof LinkedHashMap) {
                    LinkedHashMap map = (LinkedHashMap)body;
                    Integer sucessStatus = new Integer(HttpStatus.OK.value());
                    if (map.containsKey("status") && !sucessStatus.equals(map.get("status"))) {
                        ResponseResult<LinkedHashMap> error = ResponseResult.error(map, BaseErrorCode.SYSTEM_ERROR, null);
                        return error;
                    }
                }
                success = ResponseResult.success(body);
                return success;
            }
        }
    }
}
