//package com.allen.dayup.高并发程序设计.chap4;
//
//import java.util.concurrent.atomic.AtomicIntegerArray;
//import java.util.concurrent.atomic.AtomicReferenceArray;
//
///**
// * @Auther: allen
// * @Date: 2020-03-30 23:08
// * @Description:
// */
//public class LockFreeVector<E> {
//
//    //private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
//
//    private static int N_BUCKET = 30;
//
//    private static int FIRST_BUCKET_SIZE = 8;
//
//    private Descriptor<E> descriptor;
//
//    public LockFreeVector() {
//        buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>(N_BUCKET);
//        buckets.set(0,new AtomicReferenceArray<E>(FIRST_BUCKET_SIZE));
//        descriptor = new
//    }
//
//    static class Descriptor<E> {
//        public int size;
//        volatile WriteDescriptor<E> wreteop;
//
//        public Descriptor(int size, WriteDescriptor<E> wreteop) {
//            this.size = size;
//            this.wreteop = wreteop;
//        }
//
//        public void completeWrete() {
//            WriteDescriptor<E> tmpOp = wreteop;
//            if( tmpOp != null ){
//                tmpOp.doIt();
//                wreteop = null;
//            }
//        }
//    }
//
//    static class WriteDescriptor<E> {
//        public E oldV;
//        public E newV;
//        public AtomicReferenceArray<E> addr;
//        public int addr_ind;
//
//        public WriteDescriptor(E oldV, E newV, AtomicReferenceArray<E> addr, int addr_ind) {
//            this.oldV = oldV;
//            this.newV = newV;
//            this.addr = addr;
//            this.addr_ind = addr_ind;
//        }
//
//        public void doIt(){
//            addr.compareAndSet(addr_ind, oldV, newV );
//        }
//    }
//}
