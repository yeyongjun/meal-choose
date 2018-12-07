package com.develop.meal.server.controller;

import com.develop.meal.server.service.ImageRecService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yeyongjun on 2018/4/28.
 */
public class PrepareTest extends UserControllerTest{

    @Autowired
    private ImageRecService imageRecService;
    @Test
    public void localTest(){
        imageRecService.ocrRecognize("");
    }
}
