package com.allen.dayup.arithmetic;

/**
 * @Auther: 20190598
 * @Date: 2020/5/7 10:47
 * @Description:
 */
public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        this.head = new Node();
        this.size = 0;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addHead(0);
        list.addHead(1);
        list.addHead(2);
        list.iterate();

        System.out.println(list.get(0));

        list.remove(1);
        System.out.println();
        list.iterate();

    }

    public Object get(int index){
        if( index > size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = head;

        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public void addHead(Object data){
        add(0,data);
    }

    public void addTail(Object data){
        add(size,data);
    }


    public void add(int index,Object data){
        if( index > size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        int i = 0;

        size++;
        Node pred = head;
        for (int j = 0; j < index; j++) {
            pred = pred.next;
        }

        Node newNode = new Node(data);
        newNode.next = pred.next;
        pred.next = newNode;

    }

    public boolean remove(int index){
        if( index > size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }

        Node pred = head;
        for (int j = 0; j < index; j++) {
            pred = pred.next;
        }

        Node currentNode = pred.next;
        pred.next = pred.next.next;
        currentNode = null;
        return true;

    }

    public void iterate(){

        Node pred = head;
        while ( pred.next != null){
            pred = pred.next;
            System.out.print(pred.data + ",");
        }
    }

    class Node {
        Node next;
        Object data;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        private boolean hasNext(){
            boolean result = false;
            if( next != null ){
                result = true;
            }
            return result;
        }
    }

}
