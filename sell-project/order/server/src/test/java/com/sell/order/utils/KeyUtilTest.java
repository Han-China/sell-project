package com.sell.order.utils;

import com.sell.order.OrderServerApplicationTests;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class KeyUtilTest extends OrderServerApplicationTests {

    @Test
    public void genUniqueKey() {

        System.out.println("============================================");
        for(int i=0; i<20; ++i) {
            System.out.println(KeyUtil.genUniqueKey());
        }
        System.out.println("============================================");
    }
}