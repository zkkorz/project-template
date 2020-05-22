package com.project.module.dubbodemo.facade.impl;

import com.project.module.dubbodemoapi.facade.DemoFacade;
import com.project.module.runner.constant.TimeConstant;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(interfaceClass = DemoFacade.class,  timeout = TimeConstant.TIME_3_MIN)
public class DemoFacadeImpl implements DemoFacade {

    @Override
    public String getDemo() {
        return "Demo Facade 成功";
    }

}
