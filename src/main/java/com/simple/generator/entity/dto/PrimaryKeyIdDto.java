package com.simple.generator.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 申涛涛
 * @date 2020/5/27 19:48
 */
@Data
public class PrimaryKeyIdDto implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = true)
    private Integer id;
}
