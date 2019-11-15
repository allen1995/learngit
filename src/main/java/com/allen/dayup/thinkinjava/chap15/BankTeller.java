package com.allen.dayup.thinkinjava.chap15;

import org.apache.rocketmq.remoting.RPCHook;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: 20190598
 * @Date: 2019/11/13 11:29
 * @Description: 演示匿名内部类
 */
public class BankTeller {
    public static void server(Teller t, Customer c){
        System.out.println(t + " serves:" + c);
    }


    public static void main(String[] args) {

        List<Teller> tellers = new LinkedList<>();
        Generator<Teller> tellerGen = Teller.generator();
        for (int i = 0; i < 3; i++) {
            tellers.add(tellerGen.next());
        }

        List<Customer> customers = new ArrayList<>();
        Generator<Customer> customerGen = Customer.generator();
        for (int i = 0; i < 15; i++) {
            customers.add(customerGen.next());
        }

        Random rand = new Random(47);
        for ( Customer c: customers) {
            server(tellers.get(rand.nextInt(tellers.size())), c);
        }


    }
}


class Customer {
    private static long counter = 1;

    private final long  id = counter++;

    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer: " + id;
    }

    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {

    private static long counter = 1;

    private final long id = counter++;

    private Teller(){};

    @Override
    public String toString() {
        return "Teller: " + id;
    }

    public static Generator<Teller> generator(){
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}