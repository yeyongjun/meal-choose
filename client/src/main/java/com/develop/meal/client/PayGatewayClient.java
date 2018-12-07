package com.develop.meal.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(serviceId = "meal-choose")
public interface PayGatewayClient {
    @GetMapping("/test")
    String test(@RequestParam(value = "name") String name);
}
