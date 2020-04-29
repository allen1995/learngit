package com.allen.dayup.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: 20190598
 * @Date: 2019/11/15 11:02
 * @Description:
 */
public class SimpleStreamDemo {

    public static void main(String[] args) {
        List<String> ids = Arrays.asList(new String[]{"abc","bc","bc","efg","abcd","","jdl"});

        //生成新集合
        List<String> filtered = ids.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());

        //遍历集合 forEach
        ids.stream().filter(string -> !string.isEmpty()).distinct().forEach(x -> System.out.print(x + " "));

        //map 映射每个元素到对应的结果
        //输出每个数的平方数
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        //filter
        //filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串
        long count = ids.stream().filter(string -> !string.isEmpty()).count();
        System.out.println(count);

        //limit
        //limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据
        long len = numbers.stream().limit(5).count();
        System.out.println(len);

        //sorted
        //sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序
        numbers.stream().limit(5).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).forEach( x -> System.out.print( x + " "));

        System.out.println();

        //并行（parallel）程序
        //parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出空字符串的数量
        List<String> names = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long nameLen = names.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(nameLen);

        //Collectors
        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
        String mergeString = names.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println(mergeString);

        //统计
        //另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中的最大数：" + stats.getMax());
        System.out.println("列表中的最小数：" + stats.getMin());
        System.out.println("列表中的总和：" + stats.getSum());
        System.out.println("列表中的平均数:" + stats.getAverage());

        // of
        Stream.of("allen","王者").forEach(System.out::println);

        // reduce
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("php");
        list.add("python");
        list.add("perl");
        list.add("c");
        list.add("lisp");
        list.add("c#");
        Stream<String> wordStream = list.stream();
        //int s = wordStream.map(a -> a.length()).mapToInt(Integer::new).sum();
        //System.out.println(s);

        Stream<Integer> lengthStream = wordStream.map( a -> a.length());
        //        //Optional<Integer> sum = lengthStream.reduce((x,y) -> x+y);
        Optional<Integer> sum = lengthStream.reduce(Integer::sum);
        sum.ifPresent(System.out::println);


    }
}
