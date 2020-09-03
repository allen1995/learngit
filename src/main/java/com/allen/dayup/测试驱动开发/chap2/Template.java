package com.allen.dayup.测试驱动开发.chap2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        List<String> segments = parse.parse(templateText);

        return concanate(segments);
    }

    private String concanate(List<String> segments) throws MissingValueException {
        StringBuilder result = new StringBuilder();

        for (String segment : segments) {
            append(segment, result);
        }

        return result.toString();
    }

    private void append(String segment, StringBuilder result) throws MissingValueException {
        if( isVariable(segment) ) {
            evaluateValue(segment, result);
        } else {
            result.append(segment);
        }
    }

    private boolean isVariable(String segment) {
        return segment.startsWith("${") && segment.endsWith("}");
    }

    private void evaluateValue(String segment,StringBuilder result) throws MissingValueException {
        String var = segment.substring(2, segment.length()-1);
        if( !variableValues.containsKey(var) ){
            throw new  MissingValueException("No value for " + segment);
        }
        result.append(variableValues.get(var));
    }

    private String replaceVariables(){
        String result = templateText;
        for (  Map.Entry<String,String> entry : variableValues.entrySet() ) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";

            result =  result.replaceAll( regex, entry.getValue());
        }
        return result;
    }

    private void checkMissingValue(String param) throws MissingValueException{
        Matcher m = Pattern.compile(".*\\$\\{.+\\}.*").matcher(param);

        if( m.find() ){
            throw new MissingValueException("No value for " + m.group());
        }
    }


}
