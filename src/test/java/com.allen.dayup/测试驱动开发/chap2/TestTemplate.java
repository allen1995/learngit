package com.allen.dayup.测试驱动开发.chap2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;


/**
 * @Auther: allen
 * @Date: 2020-08-30 09:17
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTemplate {

    private Template template;

    @Before
    public void setUp() throws Exception{
        template = new Template("${one} ${two} ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multipleVariables() throws Exception {
        assertTemplateEvaluatesTo("1 2 3");
    }

    @Test
    public void unknowVariablesAreIgnored() throws Exception{
        template.set("doesnotexist", "whatever");

        assertTemplateEvaluatesTo("1 2 3");
    }

    //@Test(expected = MissingValueException.class)
    //public void testMissingValueRaiseException() throws Exception {
    //    new Template("${foo}").evaluate();
    //}

    @Test
    public void testMissingValueRaiseException() throws Exception{

        try {
            new Template("${foo}").evaluate();
            fail("evluate() should throw a exception " +
                    "if a variable was left without a value");
        } catch (MissingValueException e){
            assertEquals("No value for ${foo}", e.getMessage());
        }
    }

    @Test
    public void variableGetProcessJustOne() throws Exception {
        template.set("one", "${one}");
        template.set("two", "${two}");
        template.set("three", "${three}");

        assertTemplateEvaluatesTo("${one} ${two} ${three}");

    }


    private void assertTemplateEvaluatesTo(String expected) throws Exception{
        assertEquals(expected, template.evaluate());
    }

}
