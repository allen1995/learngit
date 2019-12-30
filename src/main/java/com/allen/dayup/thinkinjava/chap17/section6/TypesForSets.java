package com.allen.dayup.thinkinjava.chap17.section6;

import com.sun.xml.internal.ws.assembler.jaxws.TerminalTubeFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther: 20190598
 * @Date: 2019/12/30 11:04
 * @Description:
 */
public class TypesForSets {

    public static void main(String[] args) {
        test(new HashSet<HashType>(), HashType.class);
        test(new LinkedHashSet<HashType>(), HashType.class);
        test(new TreeSet<TreeType>(), TreeType.class);

        test(new HashSet<SetType>(), SetType.class);
        test(new HashSet<TreeType>(), TreeType.class);

        test(new LinkedHashSet<SetType>(), SetType.class);
        test(new LinkedHashSet<TreeType>(), TreeType.class);
    }

    static <T> Set<T> fill(Set<T> set, Class<T> type){
        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return set;
    }

    static <T> void test(Set<T> set, Class<T> type ){
        fill(set, type);

        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }
}
