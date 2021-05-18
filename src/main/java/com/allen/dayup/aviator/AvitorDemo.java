package com.allen.dayup.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;

/**
 * @Auther: allen
 * @Date: 2021-05-16 16:00
 * @Description:
 */
public class AvitorDemo {

    public static void main(String[] args) throws IOException {
        compileScript();

        System.out.println(System.getProperty("user.dir"));

        compileLocalScript();

        // 执行带参数的脚本
        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        // Execute with injected variables.
        Boolean result =
                (Boolean) compiledExp.execute(compiledExp.newEnv("a", 100.3, "b", 45, "c", -199.100));
        System.out.println(result);

        // 校验语法
        //AviatorEvaluator.validate("1 +* 2");

        // 复杂脚本
        String expressionStr = "let a = 2;\n" +
                "let err = 1e-15;\n" +
                "let root = a;\n" +
                "\n" +
                "while math.abs(a - root * root) > err {\n" +
                "  root = (a/root + root) / 2.0;\n" +
                "}\n" +
                "\n" +
                "println(\"square root of 2 is: \" + root);";

        Expression expression1 = AviatorEvaluator.getInstance().compile(expressionStr);
        expression1.execute();
    }

    private static void compileLocalScript() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript("examples/hello.av", true);
        exp.execute();
    }

    private static void compileScript(){
        Expression script = AviatorEvaluator.getInstance().compile("println('Hello, AviatorScript!');");
        script.execute();
    }
}
