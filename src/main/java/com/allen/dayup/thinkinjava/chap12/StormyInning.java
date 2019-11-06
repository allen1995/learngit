package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/5 16:16
 * @Description:
 */
public class StormyInning extends Inning implements Storm{

    public StormyInning() throws RainedOut,BaseballException{}

    public StormyInning(String s) throws FoulException,BaseballException{}

    public void raidHard() throws RainedOut{}

    @Override
     protected void walk(){
        super.walk();
    }

    @Override
    public void event() {
    }

    public void atBat() throws FoulException{}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();

        } catch(FoulException e){
            e.printStackTrace();
        }catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }


    }
}

class BaseballException extends Exception{}

class FoulException extends BaseballException{}

class StrikeExcepion extends BaseballException{}

abstract class Inning {

    public Inning() throws BaseballException{

    };

    public void event() throws BaseballException{}

    public abstract void atBat() throws FoulException,StrikeExcepion;

    protected void walk(){};
}

class StormException extends Exception{}

class RainedOut extends StormException{}

class PopPout extends StormException{}

interface Storm{
    public void event() throws RainedOut;

     void raidHard() throws RainedOut;
}

