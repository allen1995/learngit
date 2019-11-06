package com.allen.dayup.thinkinjava.chap9;

/**
 * @Auther: 20190598
 * @Date: 2019/10/23 11:42
 * @Description:
 */
public class Music5 {

    public static void main(String[] args) {
        Instrument instrument = new Wind();
        instrument.adjust();
    }
}

enum Note{
    Little,Middle,High
}

interface Instrument{

    int VALUE = 5;

    void adjust();
}

interface Playable{

 void play();
}

abstract class AbstractInstrument implements Instrument, Playable{

    @Override
    abstract public  void play();

    @Override
    abstract public void adjust();
}

class Wind extends AbstractInstrument{

    @Override
    public void play() {
        System.out.println(this + ".play() " + Note.Middle);
    }

    @Override
    public String toString() {
        return "Wind{}";
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()"  );
    }
}
