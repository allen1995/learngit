package com.allen.dayup.java8.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: allen
 * @Date: 2020-04-04 23:01
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {

    int min() default 0;
    int max() default 255;
}
