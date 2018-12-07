package com.develop.meal.server.controller;

import com.develop.meal.common.AppConst;
import com.develop.meal.common.dto.UserDto;
import com.develop.meal.server.service.UserService;
import com.sinafenqi.core.common.dto.SimpleResp;
import com.sinafenqi.core.common.dto.VoidResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = AppConst.BASE_PATH + "/v1/users")
@Api("用户相关ApI.")
@CrossOrigin
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public SimpleResp<String> addUser(@RequestBody @Valid UserDto userDto) {
        return new SimpleResp<>(userService.addUser(userDto));
    }

    @ApiOperation(value = "获取自己的信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public UserDto getUser() {
        return userService.getUser("");
    }

    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public VoidResponse updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return new VoidResponse();
    }
}
