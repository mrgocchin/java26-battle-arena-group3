package org.battlearena.Server;

import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)){
            System.out.println("Server starts on port 5000");
            while (true){
                Socket socket = server.accept();
                //FileHandler
            }
        }
    }
}
