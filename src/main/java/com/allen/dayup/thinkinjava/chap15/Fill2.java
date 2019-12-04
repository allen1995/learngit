package com.allen.dayup.thinkinjava.chap15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2019/11/22 10:14
 * @Description:
 */
public class Fill2 {

    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(coffees),
                Coffee.class, 3);

        for ( Coffee c : coffees ){
            System.out.println(c);
        }
    }

    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }

}



class Adapter {

    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {

    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T item) {
        c.add(item);
    }
}

interface Addable<T> {
    void add(T t);
}


class Coffee{
    private String name;

    public Coffee() {
    }

    public Coffee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                '}';
    }
}