package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 6666);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        Scanner read = new Scanner(System.in);
        String line;


        Thread sendMsg = new Thread(() -> {
            while (true) {
                String msg = read.nextLine();
                if (msg.equals("logout")) {
                    return;
                }
                try {
                    out.writeUTF(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread readMsg = new Thread(() -> {
            while (true) {
                try {
                    String msg = in.readUTF();
                    System.out.println(msg);
                } catch (IOException e) {
                    return;
                }
            }
        });

        sendMsg.start();
        readMsg.start();

    }
}
