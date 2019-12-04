package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/18 16:06
 * @Description:
 */
public class Test34 {
}

abstract class AbstractCovariant<T extends AbstractCovariant<T>>{

    abstract AbstractCovariant set(T args);
}
