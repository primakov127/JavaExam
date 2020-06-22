package org.example;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    Socket socket;
    int id;

    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message;

            while (true) {
                message = in.readUTF();
                if (!"".equals(message)) {
                    out.writeUTF("You're " + id + " client. It's response to your request.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
