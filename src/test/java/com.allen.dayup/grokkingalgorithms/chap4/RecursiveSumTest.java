package com.allen.dayup.grokkingalgorithms.chap4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: 20190598
 * @Date: 2019/12/31 14:36
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RecursiveSumTest {

    RecursiveSum recursiveSum;

    @Before
    public void setUp(){
        recursiveSum = new RecursiveSum();
    }

    @After
    public void tearDown(){
        recursiveSum = null;
    }

    @Test
    public void sumTest(){

        int[] arrs = {1,2,3,4};
        int result = recursiveSum.sum(arrs);
        Assert.assertEquals(10, result);
    }

    @Test
    public void maxTest(){
        int[] arrs = {1,10,2,444,23,44,12,2};
        int result = recursiveSum.max(arrs);
        Assert.assertEquals(444, result);
    }
}
