package com.allen.dayup.thinkinjava.chap16;

import java.io.PipedReader;
import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/11/28 17:26
 * @Description:
 */
public class BerylliumSphere {

    private static long count;

    private final long id = count++;

    public BerylliumSphere() {
    }

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }



    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];

        System.out.println("b: " + Arrays.toString(b));

        BerylliumSphere[] c = new BerylliumSphere[4];
        Arrays.stream(c).forEach( berylliumSphere -> {
            if( berylliumSphere == null ){
                berylliumSphere = new BerylliumSphere();
            }
        });

        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};
        System.out.println("a.length: " + a.length);
        System.out.println("b.length: " + b.length);
        System.out.println("c.length: " + c.length);
        System.out.println("d.length: " + d.length);

        a = d;
        System.out.println("a.length: " + a.length);

        System.out.println("--------------------------");
        int[] e;
        int[] f = new int[5];
        System.out.println("f: " + Arrays.toString(f));

        int[] g = new int[4];
        for ( int i = 0; i < g.length; i++ ){
            g[i] = i * i;
        }
        int[] h = {11,23,44};
        e = new int[]{12,213};
        System.out.println("e.length: " + e.length);
        System.out.println("f.length: " + f.length);
        System.out.println("g.length: " + g.length);
        System.out.println("h.length: " + h.length);

        System.out.println("----------------------");
        char[] o = new char[5];
        System.out.println(Arrays.toString(o));
    }

    public static void  getArray(BerylliumSphere[] b){

    }
}
