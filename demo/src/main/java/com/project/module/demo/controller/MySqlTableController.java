package com.project.module.demo.controller;

import com.project.module.demo.application.MySqlTableService;
import com.project.module.demo.converter.MySqlTableConverter;
import com.project.module.demo.domain.MySqlTable;
import com.project.module.demo.transport.response.MySqlTableResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mysql/table")
@Api(tags = "MySqlTableController", description = "MySql表信息")
public class MySqlTableController {

    @Autowired
    private MySqlTableService mySqlTableService;

    @ResponseBody
    @ApiOperation(value = "查询表信息")
    @RequestMapping(value="/query",method={RequestMethod.POST})
    public MySqlTableResponse queryTable(){
        List<MySqlTable> mySqlTables = mySqlTableService.queryTable();
        return MySqlTableConverter.convertToMySqlTableResponse(mySqlTables);
    }

}
