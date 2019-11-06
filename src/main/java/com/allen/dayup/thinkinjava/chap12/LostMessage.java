package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/5 16:00
 * @Description:
 */
public class LostMessage {

    void f() throws VeryImportantException{
        throw new VeryImportantException();
    }

    void g() throws HoHumException{
        throw new HoHumException();
    }

    public static void main(String[] args) {
        LostMessage lostMessage = new LostMessage();
        try {
            try{
                lostMessage.f();
            }catch (Exception e ){
                e.printStackTrace();
            }
            finally {
                lostMessage.g();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class VeryImportantException extends Exception {

    @Override
    public String toString() {
        return "a very important exception.";
    }
}

class HoHumException extends Exception{

    @Override
    public String toString() {
        return "a trivial exception.";
    }
}
