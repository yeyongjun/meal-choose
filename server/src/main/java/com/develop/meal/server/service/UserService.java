package com.develop.meal.server.service;

import com.develop.meal.common.dto.UserDto;
import com.develop.meal.dao.dao.UserDao;
import com.develop.meal.dao.po.UserPo;
import com.develop.meal.server.constants.ErrorKeys;
import lombok.extern.slf4j.Slf4j;
import com.sinafenqi.core.common.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String addUser(UserDto userDto) {
        UserPo userPo = UserPo.fromDto(userDto);
        if (!userDao.insert(userPo)) {
            throw ServerException.fromKey(ErrorKeys.USER_CREATE_FAIL);
        }
        return userPo.getId();
    }

    public UserDto getUser(String userId) {
        UserPo userPo = userDao.get(userId);
        if (userPo == null) {
            throw ServerException.fromKey(ErrorKeys.USER_NON_EXIST);
        }
        return UserPo.toDto(userPo);
    }

    public void updateUser(UserDto userDto) {
        UserPo userPo = userDao.get(userDto.getId());
        if (userPo == null) {
            throw ServerException.fromKey(ErrorKeys.USER_NON_EXIST);
        }
        userDao.update(userPo);
    }
}
