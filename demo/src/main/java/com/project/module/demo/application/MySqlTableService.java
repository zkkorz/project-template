package com.project.module.demo.application;

import com.project.module.demo.domain.MySqlTable;

import java.util.List;

/**
 * MySql表相关信息
 */
public interface MySqlTableService {

    /**
     * 查询表信息
     */
    List<MySqlTable> queryTable();

}
