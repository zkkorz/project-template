package com.project.module.demo.application.impl;

import com.project.module.demo.application.MySqlTableService;
import com.project.module.demo.domain.MySqlTable;
import com.project.module.demo.mapper.MySqlTableMapper;
import com.project.module.dubbodemoapi.facade.DemoFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.module.runner.constant.TimeConstant;

import java.util.List;

/**
 * MySql表相关信息
 */
@Service
public class MySqlTableServiceImpl implements MySqlTableService {

    @Autowired
    private MySqlTableMapper mySqlTableMapper;

    @DubboReference(timeout = TimeConstant.TIME_3_MIN, check = false)
    private DemoFacade demoFacade;

    /**
     * 查询表信息
     */
    @Override
    public List<MySqlTable> queryTable() {
        System.out.println("=========================" + demoFacade.getDemo() + "===========================");
        return mySqlTableMapper.queryTable();
    }

}
