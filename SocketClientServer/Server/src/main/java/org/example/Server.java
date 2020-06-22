package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket;
        int id = 0;
        System.out.println("wait...");
        while (true) {
            ++id;

            socket = serverSocket.accept();
            System.out.println("New Client connected | ID: " + id);

            Thread clientHandler = new ClientHandler(socket, id);
            clientHandler.start();
        }
    }
}
