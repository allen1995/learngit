package com.allen.dayup.测试驱动开发.chap2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @Auther: allen
 * @Date: 2020-09-02 22:44
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TemplateParseTest {

    private List<String> parse(String template){
        TemplateParse parse = new TemplateParse();
        List<String> segments = parse.parse(template);
        return segments;
    }

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        List<String> segments = parse("");

        assertSegments(segments, "");
    }

    @Test
    public void testTemplateWithOnePlainText() throws Exception {
        List<String> segments = parse("Plain of text");

        assertSegments( segments, "Plain of text");
    }

    @Test
    public void parsingMutipleVariables() throws Exception{
        List<String> segments = parse("${a}:${b}:${c}");

        assertSegments(segments, "${a}",":","${b}",":","${c}");
    }

    private void assertSegments(List<? extends Object> actual, Object... expect){
        assertEquals("Number of size:", expect.length, actual.size());
        assertEquals(Arrays.asList(expect), actual);
    }
}
