package com.project.module.demo.transport.response;

import com.project.module.demo.transport.dto.MySqlTableTableDTO;
import com.project.module.runner.transport.ResponseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * MySql表信息返回结果
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MySqlTableResponse extends ResponseDTO {

    private static final long serialVersionUID = -5252082313846017024L;

    @ApiModelProperty(value = "MySql表信息内容")
    private List<MySqlTableTableDTO> result;

}
