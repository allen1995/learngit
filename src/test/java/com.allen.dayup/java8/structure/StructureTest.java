package com.allen.dayup.java8.structure;

import com.alibaba.fastjson.JSON;
import com.allen.dayup.java8.entity.TestDelayed;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Auther: 20190598
 * @Date: 2021/6/28 10:00
 * @Description:
 */
public class StructureTest {


    @Test
    public void testArrayDeque() {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");

        deque.addLast("e");
        deque.addLast("f");
        deque.addLast("g");
        deque.addLast("h");

        deque.push("i");
        deque.addLast("j");

        while ( !deque.isEmpty() ) {
            System.out.print(deque.pop() + " ");
        }
    }

    @Test
    public void testArraycopy() {
        int head=0, tail = 0;

        Object[] elements = new Object[8];

        elements[head = (head-1) & (elements.length-1)] = 'a';
        elements[head = (head-1) & (elements.length-1)] = 'b';
        elements[head = (head-1) & (elements.length-1)] = 'c';
        elements[head = (head-1) & (elements.length-1)] = 'd';

        elements[tail] = 'e';
        tail = (tail+1) & (elements.length-1);
        elements[tail] = 'f';
        tail = (tail+1) & (elements.length-1);
        elements[tail] = 'g';
        tail = (tail+1) & (elements.length-1);
        elements[tail] = 'h';
        tail = (tail+1) & (elements.length-1);

        System.out.println("容量满时数组:" + getJsonString(elements));

        Object[] doubleElements = new Object[elements.length<<1];
        int p = head;
        int n = elements.length;
        int r = n - p;

        System.out.println("head:" + head);
        System.out.println("tail:" + tail);

        System.arraycopy(elements, p, doubleElements, 0, r);
        System.out.println("第一次arraycopy完成后的扩容数组:" + getJsonString(doubleElements));

        System.arraycopy(elements, 0, doubleElements, r, p );
        System.out.println("第二次arraycopy完成后的扩容数组:" + getJsonString(doubleElements));

        elements = doubleElements;
        head = 0;
        tail = n;
        elements[head = (head-1) & (elements.length-1)] = "i";
        System.out.println(getJsonString(elements));

    }

    private String getJsonString(Object[] arr) {
        return JSON.toJSONString(arr);
    }

    @Test
    public void testDelayQueue() throws InterruptedException {
        DelayQueue<TestDelayed> delayQueue = new DelayQueue<>();

        delayQueue.offer(new TestDelayed("aaa", 5, TimeUnit.DAYS));
        delayQueue.offer(new TestDelayed("bbb", 1, TimeUnit.DAYS));
        delayQueue.offer(new TestDelayed("ccc", 3, TimeUnit.DAYS));

        System.out.println(delayQueue.take().getData());
        System.out.println(delayQueue.take().getData());
        System.out.println(delayQueue.take().getData());
    }
}
