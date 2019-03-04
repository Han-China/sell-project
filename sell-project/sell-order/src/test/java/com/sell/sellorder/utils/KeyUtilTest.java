package com.sell.sellorder.utils;

import com.sell.sellorder.SellOrderApplicationTests;
import org.junit.Test;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class KeyUtilTest extends SellOrderApplicationTests {

    @Test
    public void genUniqueKey() {

        System.out.println("============================================");
        for(int i=0; i<20; ++i) {
            System.out.println(KeyUtil.genUniqueKey());
        }
        System.out.println("============================================");
    }
}