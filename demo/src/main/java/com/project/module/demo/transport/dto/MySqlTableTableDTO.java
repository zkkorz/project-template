package com.project.module.demo.transport.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * MySql表信息内容
 */
@Data
@NoArgsConstructor
public class MySqlTableTableDTO implements Serializable {

    private static final long serialVersionUID = 5377222395689568998L;

    @ApiModelProperty(value = "表名", dataType = "String", example = "product")
    private String tableName;

}
