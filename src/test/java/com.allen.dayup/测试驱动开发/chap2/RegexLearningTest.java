package com.allen.dayup.测试驱动开发.chap2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * @Auther: allen
 * @Date: 2020-09-02 22:06
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RegexLearningTest {

    @Test
    public void testHowGroupCountWork(){
        String haystack = "The needle shop sells needles.";

        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertEquals(1, matcher.groupCount());

    }

    @Test
    public void testStartAndEnd(){
        String haystack = "The needle shop sells needles.";

        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertTrue(matcher.find());
        assertEquals("Wrong start index of 1st match.", 4, matcher.start());
        assertEquals("Wrong end index of 1st match.", 10, matcher.end());

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 1st match.", 22, matcher.start());
        assertEquals("Wrong end index of 1st match.", 28, matcher.end());

        assertFalse("Should not have any more matches.", matcher.find());
    }
}
