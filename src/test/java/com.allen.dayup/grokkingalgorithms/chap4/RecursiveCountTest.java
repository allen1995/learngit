package com.allen.dayup.grokkingalgorithms.chap4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: 20190598
 * @Date: 2019/12/31 14:42
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RecursiveCountTest {

    @Test
    public void resursiveCountTest(){
        RecursiveCount count = new RecursiveCount();
        int[] arrs = {1,2,3,4};

        int arrsCount = count.resursiveCount(arrs);
        Assert.assertEquals(4, arrsCount);
    }
}
