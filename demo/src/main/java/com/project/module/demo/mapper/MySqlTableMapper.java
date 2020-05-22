package com.project.module.demo.mapper;

import com.project.module.demo.domain.MySqlTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * MySql表相关信息
 */
@Mapper
public interface MySqlTableMapper {

    /**
     * 查询表信息
     */
    List<MySqlTable> queryTable();

}
