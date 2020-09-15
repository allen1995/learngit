package com.allen.dayup.测试驱动开发.chap2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: allen
 * @Date: 2020-08-30 09:24
 * @Description:
 */
public class Template {

    private String templateText;

    private Map<String,String> variableValues;

    public Template() {
    }


    public Template(String templateText) {
        this.templateText = templateText;
        this.variableValues = new HashMap<>();
    }

    public void set(String variable, String value){
        this.variableValues.put(variable, value);
    }

    public String evaluate() throws MissingValueException{

        TemplateParse parse = new TemplateParse();
        List<Segment> segments = parse.parseSegments(templateText);

        return concanate(segments);
    }

    private String concanate(List<Segment> segments) throws MissingValueException {
        StringBuilder result = new StringBuilder();

        for (Segment segment : segments) {
            result.append(segment.evaluate(variableValues));
        }

        return result.toString();
    }


    public static boolean isVariable(String segment) {
        return segment.startsWith("${") && segment.endsWith("}");
    }

}
