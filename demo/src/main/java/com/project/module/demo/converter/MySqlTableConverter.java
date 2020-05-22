package com.project.module.demo.converter;

import cn.hutool.core.collection.CollectionUtil;
import com.project.module.demo.domain.MySqlTable;
import com.project.module.demo.transport.dto.MySqlTableTableDTO;
import com.project.module.demo.transport.response.MySqlTableResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MySql表信息转换
 */
public class MySqlTableConverter {

    /**
     * 将获取到的表信息转换为返回参数
     */
    public static MySqlTableResponse convertToMySqlTableResponse(List<MySqlTable> mySqlTables) {
        MySqlTableResponse response = new MySqlTableResponse();
        List<MySqlTableTableDTO> result = new ArrayList<>();
        response.setResult(result);
        if(CollectionUtil.isNotEmpty(mySqlTables)){
            result.addAll(mySqlTables.stream().map(mySqlTable -> {
                MySqlTableTableDTO dto = new MySqlTableTableDTO();
                dto.setTableName(mySqlTable.getTableName());
                return dto;
            }).collect(Collectors.toList()));
        }
        return response;
    }

}
