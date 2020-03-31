package com.allen.dayup.manhuasuanfa.chap2;

import javax.sound.midi.SoundbankResource;

/**
 * @Auther: allen
 * @Date: 2020-03-26 14:54
 * @Description:
 */
public class MyQueue {
    //头指针
    private int front = 0;

    //尾指针
    private int rear = 0;

    private int[] array;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element
     * @throws Exception
     */
    public void enQueue(int element) throws Exception{
        if( (rear+1)%array.length == front ){
            throw new ArrayIndexOutOfBoundsException("队列已满！");
        }

        array[rear] = element;
        rear = (rear+1)%array.length;
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception{
        if( front == rear ){
            throw new Exception("队列为空！");
        }
        int element = array[front];
        front = (front+1)%array.length;
        return element;
    }

    /**
     * 遍历队列
     */
    public void output(){
        for (int i = front; i != rear ; i=(i+1)%array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue(10);
        queue.enQueue(5);
        queue.enQueue(4);
        queue.enQueue(3);
        queue.enQueue(2);
        queue.enQueue(1);
        queue.output();

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.output();
    }
}
