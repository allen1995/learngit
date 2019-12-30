package com.allen.dayup.thinkinjava.chap17.section6;

/**
 * @Auther: 20190598
 * @Date: 2019/12/30 10:58
 * @Description:
 */
public class HashType extends SetType {

    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }
}
