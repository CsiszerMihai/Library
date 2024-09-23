package com.itschool.library.utils.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class MultithreadingProblem implements Runnable {

    private final int[] array;
    private final int start;
    private final int end;
    private final AtomicLong result;

    public MultithreadingProblem(int[] array, int start, int end, AtomicLong result) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int index = start; index < end; index++) {
            sum += (long) array[index] * array[index];
        }
        result.addAndGet(sum);
    }
}

class MainExecutionClass {

    public static void main(String[] args) throws InterruptedException {
        int number = 100_000_000;
        int[] arr = new int[number];

        for (int i = 0; i < number; i++) {
            arr[i] = i;
        }

        //single-threaded
        long startTime = System.currentTimeMillis();
        AtomicLong singleThreadResult = new AtomicLong();
        new MultithreadingProblem(arr, 0, number, singleThreadResult).run();
        long endTime = System.currentTimeMillis();

        System.out.println("Single-thread result: " + singleThreadResult);
        System.out.println("Single-thread run: " + (endTime - startTime) + "ms");

        //multithreaded
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread count for local machine: " + threadCount);
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int partSize = number / threadCount;
        long startTimeMultiThread = System.currentTimeMillis();
        AtomicLong multiThreadResult = new AtomicLong();
        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? number : start + partSize;
            executor.execute(new MultithreadingProblem(arr, start, end, multiThreadResult));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        long endTimeMultiThread = System.currentTimeMillis();
        System.out.println("Multi-Thread result: " + multiThreadResult);
        System.out.println("Multi=Thread run: " + (endTimeMultiThread - startTimeMultiThread) + "ms");
    }
}