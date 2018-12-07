package com.develop.meal.server.service.third.baidu;

import lombok.Data;

import java.util.List;

/**
 * Created by yeyongjun on 2018/4/27.
 */
@Data
public class BaiduOcrRsp {

    private int direction;

    private String log_id;

    private List<BaiduOcrInnerRsp> words_result;

    private boolean detect_direction;

    private String words_result_num;

    private String probability;
}
