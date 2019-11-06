package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/4 09:52
 * @Description:
 */
public class Test4 {

    public static void main(String[] args) {

        try {
            int i = 0;
            throw new SimpleException("this is a SimpleException.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SimpleException extends Exception{
    private String msg;

    public SimpleException(String message) {
        super(message);
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }
}
