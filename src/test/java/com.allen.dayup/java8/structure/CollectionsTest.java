package com.allen.dayup.java8.structure;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @Auther: 20190598
 * @Date: 2021/6/28 15:07
 * @Description:
 */
public class CollectionsTest {

    private List<String> list = new ArrayList<>();

    @Before
    public void beforeEach() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");

    }

    @Test
    public void test_shuffle() {
        Collections.shuffle(list);
        list.forEach(System.out::print);
    }

    @Test
    public void test_myshuffle() {
        Random random = new Random();

        for ( int i = list.size(); i > 0; i--) {
            int ri = random.nextInt(i);

            int ji = i - 1;

            System.out.println("ri:" + ri + ",ji:" +ji );

            list.set(ji, list.set(ri, list.get(ji))); //元素交换
        }


        list.forEach(System.out::print);
    }

    @Test
    public void test_rorate() {
        System.out.println(JSON.toJSONString(list));

        Collections.rotate(list, 2);

        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void testMin() {
        System.out.println(Collections.min(list));;
    }

    @Test
    public void testMax() {
        System.out.println(Collections.max(list));;
    }

    @Test
    public void testReplaceAll() {

        System.out.println("替换前:" + JSON.toJSONString(list));
        System.out.println(Collections.replaceAll(list,"3","4"));
        System.out.println("替换后:" + JSON.toJSONString(list));
    }

    @Test
    public void testIndexSublist() {

        System.out.println(Collections.indexOfSubList(list,Arrays.asList("8","8")));
    }

    @After
    public void afterEach() {
        list.clear();
    }
}
