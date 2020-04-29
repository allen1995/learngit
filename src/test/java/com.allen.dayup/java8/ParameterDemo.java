package com.allen.dayup.java8;

import com.allen.dayup.java8.io.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @Auther: allen
 * @Date: 2020-04-06 17:59
 * @Description:
 */
public class ParameterDemo {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void testAbs(int x){
        assertEquals(x, Math.abs(x));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -5, -100 })
    void testAbsNegative(int x) {
        assertEquals(-x, Math.abs(x));
    }

    @ParameterizedTest
    @MethodSource
    void testCapitalize(String input,String result){
        assertEquals(result, StringUtils.capitalize(input));
    }

    static List<Arguments> testCapitalize(){
        List<Arguments> arguments = new ArrayList<>();
        Arguments arguments1 = Arguments.of("abc","Abc");
        arguments.add(arguments1);

        Arguments arguments2 = Arguments.of("abc","ccc");
        arguments.add(arguments2);

        return arguments;
    };
}
