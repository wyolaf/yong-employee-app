package com.yong.employee.base;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ResponseResult.class);
    @ApiModelProperty("标记是否成功")
    private boolean success;
    @ApiModelProperty("错误码")
    private String code;
    @ApiModelProperty("错误信息")
    private String message;
    @ApiModelProperty("返回")
    private T data;
    private static final String REPLACE_STR = "$";
    private static final String CODE_SPLIT = "@";

    private static <T> ResponseResult build(IErrorCode code, T data, String msg) {
        ResponseResult result = new ResponseResult();
        result.setSuccess(code.getCode().equals(BaseErrorCode.SUCCESS.getCode()) ? Boolean.TRUE : Boolean.FALSE);
        result.setCode(code.getCode());
        result.setMessage(StrUtil.isEmpty(msg) ? code.getMsg() : msg);
        result.setData(data);
        return result;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public ResponseResult rebuildMsg(String msg) {
        this.setMessage(msg);
        return this;
    }

    public static <T> ResponseResult<T> success() {
        return build(BaseErrorCode.SUCCESS,null, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return build(BaseErrorCode.SUCCESS, data, null);
    }

    public static <T> ResponseResult<T> error() {
        return build(BaseErrorCode.SYSTEM_ERROR, null, null);
    }

    public static <T> ResponseResult<T> error(IErrorCode code, String msg) {
        return build(code, null, msg);
    }

    public static <T> ResponseResult<T> error(T data, IErrorCode code, String msg) {
        return build(code, data, msg);
    }
}
