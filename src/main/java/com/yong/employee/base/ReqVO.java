package com.yong.employee.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqVO {

    @ApiModelProperty("当前页数")
    private Integer page = 1;
    @ApiModelProperty("每页数量")
    private Integer limit = 20;
}
