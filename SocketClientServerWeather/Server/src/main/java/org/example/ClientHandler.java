package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Date;

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

                if (message.equals("/d")) {
                    Date date = new Date();
                    out.writeUTF("Date: " + date.toString());
                    continue;
                }

                if (message.equals("/weather")) {
                    out.writeUTF("In Minsk, 24 degrees of heat.");
                    continue;
                }
                if (message.equals("/help")) {
                    out.writeUTF("/d - returns current date.");
                    out.writeUTF("/weather - returns current weather.");
                    continue;
                }

                if (!"".equals(message)) {
                    out.writeUTF("You're " + id + " client. It's response to your request.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
