package com.easylearnz.sockets;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8080)) {
      System.out.println("Waiting for connections...");

      try (Socket socket = serverSocket.accept()) {
        System.out.println("Connection established");

        InputStream input = socket.getInputStream();
        byte[] inputBytes = new byte[input.available()];
        while (input.read() != -1) {
          // in
        }
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        // String userInput = bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        // bufferedWriter.write("Hello, " + userInput + "\n"); // Include newline
        // System.out.println("Sent: Hello, " + userInput);

        bufferedWriter.flush();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
