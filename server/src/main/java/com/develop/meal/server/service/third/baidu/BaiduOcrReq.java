package com.develop.meal.server.service.third.baidu;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;

/**
 * Created by yeyongjun on 2018/4/27.
 */
@Data
@Slf4j
public class BaiduOcrReq {

    private String image;

    private String url;

    private String language_type;

    private Boolean detect_direction;

    private String detect_language;

    private String probability;

    public String encode(){
        String result ="";
        try{
            if (image != null){
                result += URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(image, "UTF-8");
            }if (url != null){
                result += URLEncoder.encode("url", "UTF-8") + "=" + URLEncoder.encode(url, "UTF-8");
            }if (language_type != null){
                result += URLEncoder.encode("language_type", "UTF-8") + "=" + URLEncoder.encode(language_type, "UTF-8");
            }if (detect_direction != null){
                result += URLEncoder.encode("detect_direction", "UTF-8") + "=" + detect_direction;
            }if (detect_language != null){
                result += URLEncoder.encode("detect_language", "UTF-8") + "=" + URLEncoder.encode(detect_language, "UTF-8");
            }if (probability != null){
                result += URLEncoder.encode("probability", "UTF-8") + "=" + URLEncoder.encode(probability, "UTF-8");
            }
        }catch (Exception e){
            log.error("encode request param error");
        }
        return result;
    }
}
