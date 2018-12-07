package com.develop.meal.server.controller;

import com.develop.meal.common.AppConst;
import com.develop.meal.server.service.ImageRecService;
import com.develop.meal.server.service.third.baidu.BaiduOcrRsp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yeyongjun on 2018/4/28.
 */
@RestController
@RequestMapping(value = AppConst.BASE_PATH)
@Api("图片识别ApI.")
@CrossOrigin
@Slf4j
public class ImageRecController {

    @Autowired
    private ImageRecService imageRecService;

    @ApiOperation("图片识别")
    @RequestMapping(value = "/recognize/remote", method = RequestMethod.POST)
    public BaiduOcrRsp ocrRecognize(String url){
        return imageRecService.ocrRecognize(url);
    }

    @ApiOperation("图片识别")
    @RequestMapping(value = "/recognize/local", method = RequestMethod.POST)
    public BaiduOcrRsp ocrRecognize(byte[] bytes){
        return imageRecService.ocrRecognize(bytes);
    }
}
