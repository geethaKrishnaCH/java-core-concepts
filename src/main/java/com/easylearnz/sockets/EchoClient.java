package com.easylearnz.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8080)) {
      BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter your name: ");
      String username = userInput.readLine();

      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      out.write(username);
      out.flush();

      BufferedReader serverResponse = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      System.out.println("Server response: " + serverResponse.readLine());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
