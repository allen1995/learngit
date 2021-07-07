package com.allen.dayup.面经手册;

import org.junit.Test;

/**
 * @Auther: 20190598
 * @Date: 2021/7/1 15:34
 * @Description:
 */
public class ThreadLocalTest {

    private static final int HASH_INCREMENT = 0x61c88647;

    @Test
    public void testHash() {
        int hashcode = 0;

        for (int i = 0; i < 16; i++) {
            hashcode = i * HASH_INCREMENT + HASH_INCREMENT;
            int idx = hashcode & 15;

            System.out.println("斐波那锲散列:" + idx + " ,普通散列：" + (String.valueOf(i).hashCode() % 15));
        }

    }
}
