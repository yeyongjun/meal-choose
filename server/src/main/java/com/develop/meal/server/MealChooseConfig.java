package com.develop.meal.server;

import com.sinafenqi.core.server.MicroService;
import com.sinafenqi.core.server.config.BaseConfig;
import com.sinafenqi.core.server.swagger.ServiceInfo;
import com.develop.meal.common.AppConst;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableFeignClients
public class MealChooseConfig extends BaseConfig {
    public static void main(String[] args) {
        MicroService service = new MicroService();
        service.start(MealChooseConfig.class, args);
    }

    @Override
    public ServiceInfo getServiceInfo() {
        return new ServiceInfo("用餐助手", "用餐助手服务", AppConst.SERVICE_NAME, "v1");
    }
}
