package com.develop.meal.dao.po;

import com.sinafenqi.commons.BaseBeanUtils;
import com.sinafenqi.commons.annotation.PrimaryKey;
import com.sinafenqi.commons.annotation.UpdateIgnore;
import com.develop.meal.common.dto.UserDto;
import lombok.Data;

import java.util.Date;

@Data
public class UserPo {
    /**
     * 用户唯一标识
     */
    @PrimaryKey
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别. M-男,F-女,U-未知
     */
    private String gender;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 手机号.加密
     */
    private String mobile;
    /**
     * 实名标识.Y-实名;N-未实名;U-未知
     */
    private String realNameStatus;
    /**
     * 邮箱
     */
    private String email;
    @UpdateIgnore
    private Date createdAt;
    private Date updatedAt;

    public static UserPo fromDto(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return BaseBeanUtils.convert(userDto, UserPo.class);
    }

    public static UserDto toDto(UserPo userPo) {
        if (userPo == null) {
            return null;
        }
        return BaseBeanUtils.convert(userPo, UserDto.class);
    }
}