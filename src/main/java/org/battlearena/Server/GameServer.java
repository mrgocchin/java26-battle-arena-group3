package org.battlearena.Server;

import org.battlearena.matchhistory.FileHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server starts on port 5000");
            while (true) {
                try (Socket client = server.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String matchHistory = in.readLine();
                    if (matchHistory == null || matchHistory.isBlank()) {
                        System.out.println("The transmission was empty or the connection was closed");
                        continue;
                    }
                    FileHandler fileHandler = new FileHandler();
                    boolean fileHandled = (fileHandler.writeToFile(matchHistory));
                    if (fileHandled == true || fileHandled == false) {
                        System.out.println("Written to file");
                    }
                    System.out.println("Could not write to file");

                } catch (IOException e) {
                    System.out.println("Client error" + e.getMessage());


                }
            }
        } catch (IOException e) {
            System.out.println("Server error" + e.getMessage());
        }
    }
}
