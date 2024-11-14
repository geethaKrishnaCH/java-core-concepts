package com.easylearnz.threads;

import java.util.Random;

public class DemoRaceCondition {

  public static void main(String[] args) {
    RaceCondition raceCondition = new RaceCondition();
    try {
      raceCondition.runTest();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class RaceCondition {

  private int randInt;
  private Random random = new Random(System.currentTimeMillis());

  private void printer() {
    for (int i = 0; i < 100; i++) {
      synchronized (this) {
        if (randInt % 5 == 0) {
          System.out.println(Thread.currentThread().getName() + ": " + i + ": " + randInt);
        } else {
          System.out.println(Thread.currentThread().getName() + ": " + i + ": " + randInt);
        }
      }
    }
  }

  private void modifier() {
    synchronized (this) {
      for (int i = 0; i < 100; i++) {
        randInt = random.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + ": " + randInt);
      }
    }
  }

  public void runTest() throws InterruptedException {

    Thread thread1 = new Thread(() -> {
      printer();
    });

    Thread thread2 = new Thread(() -> {
      modifier();
    });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
  }
}