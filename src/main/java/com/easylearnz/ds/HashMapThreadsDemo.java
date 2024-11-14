package com.easylearnz.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashMapThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> hashMap = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                hashMap.put(i + Thread.currentThread().getName(), i);
            }
        };
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.shutdownNow();

        if (!executorService.isTerminated()) {
            Thread.sleep(1000);
        }

        System.out.println("Size of the hashMap: " + hashMap.size());
    }
}
