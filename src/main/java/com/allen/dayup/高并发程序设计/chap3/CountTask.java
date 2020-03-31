package com.allen.dayup.高并发程序设计.chap3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Auther: allen
 * @Date: 2020-03-25 10:48
 * @Description:
 */
public class CountTask extends RecursiveTask<Long> {
    private final int THRESHOLD = 10000;

    private  long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0,200000L);
        ForkJoinTask<Long> future = forkJoinPool.submit(countTask);
        try {
            long sum = future.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //long sum = 0;
        //for (long i = 0; i < 200000L; i++) {
        //    sum += i;
        //}
        //System.out.println(sum);
    }

    @Override
    protected Long compute() {

        long sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;

        if( canCompute ){
            for (long i = start; i <= end  ; i++) {
                sum += i;
            }
        } else {
            //分成一百个子任务
            long step = (start + end)/100;
            List<CountTask> subTasks = new ArrayList<>();
            long pos = start;

            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if( lastOne > end ){
                    lastOne = end;
                }

                CountTask subTask = new CountTask(pos, lastOne);
                pos += step + 1;

                subTasks.add(subTask);
                subTask.fork();
            }

            for (CountTask subTask : subTasks) {
                sum += subTask.join();
            }

        }

        return sum;
    }
}
