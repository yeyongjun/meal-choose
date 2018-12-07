package com.develop.meal.dao;


import com.sinafenqi.commons.BaseDaoUtils;
import com.sinafenqi.commons.model.DbInfo;

import java.util.Arrays;

/**
 * 仅用来生成dao及entity相关代码
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DbInfo dbInfo = new DbInfo("jdbc:mysql://192.168.1.53:3306/xb_sample", "xbapp", "rootxb_138");
        BaseDaoUtils.generateCode(dbInfo, Arrays.asList("user".split(",")), "com.develop.meal.dao.test");
    }
}
