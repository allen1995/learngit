package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/18 10:58
 * @Description:
 */
public class MultipleInterfaceVariants {
}

interface Payalbe<T>{}

class Employee implements Payalbe{}

class Hourly extends Employee implements Payalbe{}
