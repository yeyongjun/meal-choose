package com.develop.meal.common.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDto {
    @ApiModelProperty("用户唯一标识")
    private String id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别. M-男,F-女,U-未知")
    private String gender;
    @ApiModelProperty("身份证")
    private String idCard;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("实名标识.Y-实名;N-未实名;U-未知")
    private String realNameStatus;
    @ApiModelProperty("邮箱")
    private String email;
}
