package com.allen.dayup.测试驱动开发.chap2;

import java.util.Map;

/**
 * @Auther: allen
 * @Date: 2020-09-06 08:12
 * @Description:
 */
public interface Segment {
    String evaluate(Map<String,String> variables) throws MissingValueException;
}
