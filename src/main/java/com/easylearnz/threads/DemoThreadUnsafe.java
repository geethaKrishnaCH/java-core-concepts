package com.easylearnz.threads;

import java.util.Random;

public class DemoThreadUnsafe {

  private static Random random = new Random(System.currentTimeMillis());

  public static void main(String[] args) throws InterruptedException {
    ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          badCounter.increment();
          sleepRandomly();
        }
      }
    });

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          badCounter.decrement();
          sleepRandomly();
        }
      }
    });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    badCounter.printFinalCounterValue();
  }

  private static void sleepRandomly() {
    try {
      Thread.sleep(random.nextInt(10));
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}

class ThreadUnsafeCounter {
  private int count;

  public ThreadUnsafeCounter() {
    count = 0;
  }

  public void increment() {
    count++;
  }

  public void decrement() {
    count--;
  }

  void printFinalCounterValue() {
    System.out.println("counter: " + count);
  }
}