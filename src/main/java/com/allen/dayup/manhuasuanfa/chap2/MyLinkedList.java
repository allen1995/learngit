package com.allen.dayup.manhuasuanfa.chap2;

import com.allen.dayup.thinkinjava.chap17.section6.MySortedSet;

/**
 * @Auther: allen
 * @Date: 2020-03-26 13:34
 * @Description:
 */
public class MyLinkedList<T> {

    //头节点
    private Node<T> head;

    //尾节点
    private Node<T> tail;


    //链表长度
    private int size;

   private static class Node<T> {
       T data;
       Node next;

       public Node(T data) {
           this.data = data;
       }
   }

    public MyLinkedList() {

    }

    public static void main(String[] args) throws Exception{
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        try {
            myLinkedList.insert("4", 0);
            myLinkedList.insert("9", 1);
            myLinkedList.insert("7",2);
            myLinkedList.insert("2",3);
            myLinkedList.insert("7",1);
            myLinkedList.remove(0);
            myLinkedList.output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入方法
     * @param data
     * @param index
     * @throws Exception
     */
    public void insert(T data, int index) throws Exception {

        if( index < 0 || index > size ){
             throw new IndexOutOfBoundsException("超出链表范围！");
        }

        Node<T> insertNode = new Node<>(data);

        if( size == 0 ){
            head = insertNode;
            tail = insertNode;
        } else if ( index == 0 ){
            insertNode.next = head;
            head = insertNode;
        } else if ( index == size ){
            tail.next = insertNode;
            tail = insertNode;
        } else {
            Node<T> prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size ++;
    }

    /**
     * 删除指定下标的元素
     * @param index
     * @return
     */
    public Node<T> remove( int index ){
        if( index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("超出链表范围！");
        }

        Node<T> removeNode;

        if( index == 0 ){
            removeNode = head;
            head = head.next;
        } else if ( index == size - 1 ){
            //删除尾节点
            Node<T> preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = null;
            tail = preNode;
        } else {
            Node<T> prevNode = get(index - 1);
            Node  nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }

        size --;

        return removeNode;
    }

    /**
     * 遍历输出数组
     */
    public void output(){
        Node temp = head;

        while ( temp!= null ){
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public Node<T> get(int index) {
        if( index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("超出链表范围！");
        }

        Node<T> result = head;

        for (int i = 0; i < index; i++) {
            result = head.next;
        }

        return result;
    }
}
