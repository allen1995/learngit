package com.allen.dayup.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.exception.ExpressionSyntaxErrorException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @Auther: allen
 * @Date: 2021-05-18 22:29
 * @Description:
 */
public class AviatorEvaluatorInstanceTest {

    @Test
    public void testCompileScript() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("examples/hello.av", true);
        exp.execute();
    }

    @Test
    public void testCompile() {
        Expression script = AviatorEvaluator.getInstance().compile("println('Hello, AviatorScript!');");
        script.execute();
    }

    @Test
    public void testCompileWithResult() {
        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        // Execute with injected variables.
        Boolean result =
                (Boolean) compiledExp.execute(compiledExp.newEnv("a", 100.3, "b", 45, "c", -199.100));
        Assert.assertFalse(result);
    }

    @Test(expected = ExpressionSyntaxErrorException.class)
    public void testValidator() {
        AviatorEvaluator.validate("1 +* 2");
    }

    @Test
    public void testInteger() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("examples/int.av", true);
        exp.execute();
    }

    @Test
    public void testBigint() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("examples/bigint.av", true);
        exp.execute();
    }

    @Test
    public void testSequarRoot() throws IOException{
        Expression exp = AviatorEvaluator.getInstance().compileScript("examples/sequar_root.av", true);
        exp.execute();
    }

}
