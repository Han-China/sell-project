package com.sell.order.utils;

import java.util.Random;

/**
 * Created by Administratoron 2019/3/2
 **/
public class KeyUtil {

    /**
     * 生成唯一的主键，线程安全
     * 格式：时间戳 + 6位随机数
     * @return
     */
    public static synchronized String genUniqueKey() {

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
