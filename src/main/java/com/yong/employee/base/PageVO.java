package com.yong.employee.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="分页参数", description="分页参数")
public class PageVO<T> {

    @ApiModelProperty("总条数")
    private Long total;

    @ApiModelProperty("分页数据")
    private List<T> items;
}
