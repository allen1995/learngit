package com.allen.dayup.面经手册;

import com.allen.dayup.面经手册.chap2.threadlocal.User;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: 20190598
 * @Date: 2021/7/6 11:18
 * @Description:
 */
public class ReentrantLockTest {

    @Test
    public void test_stateOffset() throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = getUnsafeInstance();

        long state = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("state"));
        System.out.println(state);
    }

    private Unsafe getUnsafeInstance() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        return unsafe;
    }

    @Test
    public void test_getInt() throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = getUnsafeInstance();

        // objectFieldOffset获取字段在对象中的偏移量
        long value = unsafe.objectFieldOffset(User.class.getDeclaredField("name"));
        User user = new User();

        // 获取指定偏移量位置的值
        System.out.println(user);
        System.out.println(unsafe.getObject(user, value));

        //比较并设置，获取user对象 value偏移量的值，取出值与 o1进行比较，相等的话，就将值改成o2
        unsafe.compareAndSwapObject(user, value, "allen3", "allen2");

        System.out.println(user.getName());
    }
}
