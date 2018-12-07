package com.develop.meal.server.service.third.baidu;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "baidu", url = "${baidu.ocr.url}")
public interface BaiduApi {

    @RequestMapping(value = "/oauth/2.0/token", method = RequestMethod.GET)
    BaiduAuthRsp authorizeBySecretId(
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("grant_type") String grantType
    );

    @RequestMapping(value = "/rest/2.0/ocr/v1/general_basic", method = RequestMethod.POST)
    @ApiImplicitParam(paramType = "header", name = "Content-Type", value = "application/x-www-form-urlencoded",
            dataType = "string")
    BaiduOcrRsp ocrRecognize(
            @RequestParam("access_token") String accessToken,
            @RequestBody String encodeRequest);


}
