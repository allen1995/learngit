package com.allen.dayup.thinkinpattern.chap4.manualstate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 15:31
 * @Description:
 */
public class Washer {
    private State currentState;
    static Map states = new HashMap<>();

    public Washer() {
        this.currentState = currentState;
        states.put("Wash", new Wash());
        states.put("Spin", new Spin());
        states.put("Rinse", new Rinse());
        currentState = (State) states.get("Wash");
    }

    private void nextState(Map stateTable, String input){
        currentState = (State)states.get(stateTable.get(input));
    }

    class TState implements State{

        protected HashMap stateTable = new HashMap();

        @Override
        public void run(String input) {
            String name = getClass().toString();
            System.out.println(name.substring(name.lastIndexOf('$')+1));
            nextState(stateTable,input);
        }
    }

    class Wash extends TState {
        {
            MapLoader.load(stateTable, new String[][]{
                    {"Wash","Spin"},
                    {"Spin","Spin"},
                    {"Rinse","Rinse"}
            });
        }
    }

    class Spin extends TState{
        {
            MapLoader.load(stateTable,new String[][]{
                    {"Wash","Wash"},
                    {"Spin","Rinse"},
                    {"Rinse","Rinse"}
            });
        }
    }

    class Rinse extends TState{
        {
            MapLoader.load(stateTable,new String[][]{
                    {"Wash","Wash"},
                    {"Spin","Spin"},
                    {"Rinse","Spin"}
            });
        }
    }

    public void run() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        try (BufferedReader reader = new BufferedReader(new FileReader("Statefile.txt"))) {
            while ( reader.ready()){
                String input = reader.readLine().trim();
                if( input != null ){
                    currentState.run(input);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Washer washer = new Washer();
        washer.run();
    }
}
