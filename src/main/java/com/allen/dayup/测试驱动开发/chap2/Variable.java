package com.allen.dayup.测试驱动开发.chap2;

import java.util.Map;
import java.util.Objects;

/**
 * @Auther: allen
 * @Date: 2020-09-06 08:14
 * @Description:
 */
public class Variable implements Segment {

    private String name;

    public Variable() {
    }

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;
        Variable variable = (Variable) o;
        return Objects.equals(name, variable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String evaluate(Map<String, String> variables) throws MissingValueException {

        if( !variables.containsKey(name)){
            throw new  MissingValueException("No value for ${" + name + "}");
        }

        return variables.get(name);
    }
}
