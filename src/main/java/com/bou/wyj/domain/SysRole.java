package com.bou.wyj.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色
 *
 * @Author xiaoquan
 * @Date 2023/8/1 11:43
 */

@Data
@Schema(description = "角色详情")
public class SysRole implements Serializable {
    @Schema(description = "角色id")
    private Long id;
    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String name;


    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

}
