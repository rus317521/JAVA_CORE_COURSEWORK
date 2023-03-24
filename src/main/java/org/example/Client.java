package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8989);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {//System.out.println(reader.readLine());
            writer.println("{\"title\": \"чипсы\", \"date\": \"2022.02.08\", \"sum\": 600}");

            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}