package org.battlearena.Server;

import org.battlearena.matchhistory.FileHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class GameServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server starts on port 5000");
            while (true) {
                try (Socket client = server.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    System.out.println("Client connected");

                    String lastMatchSummary = in.readLine();
                    if (lastMatchSummary == null || lastMatchSummary.isBlank()) {
                        System.out.println("The transmission was empty or the connection was closed");
                        continue;
                    }
                    FileHandler fileHandler = new FileHandler();

                    boolean fileHandled = (fileHandler.writeToFile(lastMatchSummary));
                    if (fileHandled) {
                        System.out.println("Written to file");
                        List<String> completemMatchHistory = fileHandler.getFileContents();
                        // if (completemMatchHistory == null|| completemMatchHistory.isEmpty()){

                        //}
                        out.println(completemMatchHistory);
                    } else {
                        System.out.println("Could not write to file");
                        out.println("The file could not be saved");
                    }

                } catch (IOException e) {
                    System.out.println("Client error" + e.getMessage());


                }
            }
        } catch (IOException e) {
            System.out.println("Server error" + e.getMessage());
        }
    }
}
