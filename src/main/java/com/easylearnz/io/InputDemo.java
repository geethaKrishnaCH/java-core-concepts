package com.easylearnz.io;

import java.io.IOException;

public class InputDemo {
  public static void main(String[] args) {
    byte[] data = new byte[10];
    try {
      System.in.read(data);
      for (int i = 0; i < data.length; i++) {
        System.out.write(data[i]);
      }
      System.out.flush();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
