package com.allen.dayup.测试驱动开发.chap2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Auther: allen
 * @Date: 2020-09-06 08:35
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PlainTextSegmentTest {

    @Test
    public void plainTextEvaluatesAsIs() throws Exception {
        Map<String,String> variables = new HashMap<>();
        String text = "abc def";

        assertEquals(text, new PlainText(text).evaluate(variables));

    }
}
