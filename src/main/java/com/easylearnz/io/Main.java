package com.easylearnz.io;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    String name = "\nGeetha Krishna";
    byte[] byteArr = name.getBytes();
    System.out.println(byteArr.length);
    for (int i = 0; i < byteArr.length; i++) {
      System.out.println(byteArr[i]);
    }
    try {
      System.out.write(byteArr);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.close();
    }
    System.out.flush();
  }
}
