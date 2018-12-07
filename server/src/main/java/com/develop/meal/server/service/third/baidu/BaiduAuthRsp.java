package com.develop.meal.server.service.third.baidu;

import lombok.Data;

/**
 * Created by yeyongjun on 2018/4/28.
 */
@Data
public class BaiduAuthRsp {

    private String access_token;

    private Long expires_in;

    private String scope;

    private String session_key;

    private String session_secret;

}
