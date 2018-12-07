package com.develop.meal.server.controller;

import com.develop.meal.server.MealChooseConfig;
import com.sinafenqi.core.server.MicroService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MealChooseConfig.class, MicroService.class})
@PropertySource("classpath:application.properties")
public class UserControllerTest {
    @BeforeClass
    public static void init() throws Exception {
        System.getProperties().put("service.tag", "local");
        System.getProperties().put("server.port", 9011);
    }

    @Test
    public void createUser() {

    }

    @Test
    public void getUser() {

    }

    @Test
    public void updateUser() {

    }
}
