package com.allen.dayup.测试驱动开发.chap2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Auther: allen
 * @Date: 2020-09-06 08:42
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class VariableSegmentTest {

    @Test
    public void variableEvaluateToItValue() throws Exception {
        Map<String,String> variables = new HashMap<>();
        String name = "mykey";
        String value = "myvalue";
        variables.put(name, value);
        assertEquals(value, new Variable(name).evaluate(variables));
    }
}
