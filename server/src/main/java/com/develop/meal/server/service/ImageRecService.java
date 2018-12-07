package com.develop.meal.server.service;

import com.develop.meal.server.service.third.baidu.BaiduApi;
import com.develop.meal.server.service.third.baidu.BaiduAuthRsp;
import com.develop.meal.server.service.third.baidu.BaiduOcrReq;
import com.develop.meal.server.service.third.baidu.BaiduOcrRsp;
import com.develop.meal.server.util.Base64Util;
import com.develop.meal.server.util.FileUtil;
import com.develop.meal.server.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

/**
 * Created by yeyongjun on 2018/4/27.
 */
@Service
@Slf4j
public class ImageRecService {

    @Value("${api.key}")
    private String clientId;

    @Value("${secret.key}")
    private String clientSecret;

    @Autowired
    private BaiduApi baiduApi;

    public BaiduOcrRsp ocrRecognize(String url){
        BaiduAuthRsp authRsp = baiduApi.authorizeBySecretId(clientId, clientSecret,"client_credentials");
        BaiduOcrReq baiduOcrReq = new BaiduOcrReq();
        baiduOcrReq.setUrl(url);
        BaiduOcrRsp ocrRsp = baiduApi.ocrRecognize(authRsp.getAccess_token(), baiduOcrReq.encode());
        return ocrRsp;
    }

    public BaiduOcrRsp ocrRecognize(byte[] imgData){
        BaiduAuthRsp authRsp = baiduApi.authorizeBySecretId(clientId, clientSecret,"client_credentials");
        BaiduOcrReq baiduOcrReq = new BaiduOcrReq();
        try {
            String imgStr = Base64Util.encode(imgData);
            baiduOcrReq.setImage(imgStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaiduOcrRsp ocrRsp = baiduApi.ocrRecognize(authRsp.getAccess_token(), baiduOcrReq.encode());
        return ocrRsp;
    }

    public String ocrRecognizeTest(){
        BaiduAuthRsp authRsp = baiduApi.authorizeBySecretId(clientId, clientSecret,"client_credentials");
        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        // 本地图片路径
        String filePath = "D:\\apic21530.jpg";
        String result = null;
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            result = HttpUtil.post(otherHost, authRsp.getAccess_token(), params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

    }


}
