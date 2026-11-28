package org.battlearena.server_client;

import org.battlearena.matchhistory.FileHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GameServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server starts on port 5000");
            while (true) {
                handleClient(server);
            }
        } catch (IOException e) {
            System.out.println("Server error" + e.getMessage());
        }
    }

    private static void handleClient(ServerSocket server) {
        try (Socket client = server.accept()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8),true);

            System.out.println("Client connected");

            String lastMatchSummary = in.readLine();

            if (lastMatchSummary == null || lastMatchSummary.isBlank()) {
                System.out.println("The transmission was empty or the connection was closed");
                out.println("END");
                return;
            }

            saveMatchSendHistory(lastMatchSummary, out);


        } catch (IOException e) {
            System.out.println("Client error" + e.getMessage());


        }
    }

    private static void saveMatchSendHistory(String lastMatchSummary, PrintWriter out) {
        FileHandler fileHandler = new FileHandler();

        boolean fileSaved = (fileHandler.writeToFile(lastMatchSummary));

        if (fileSaved) {
            System.out.println("Written to file");

            List<String> completeMatchHistory = fileHandler.getFileContents();

            sendMatchHistory(out, completeMatchHistory);

        } else {
            System.out.println("Could not write to file");
            out.println("ERROR:The file could not be saved");
        }
        out.println("END");
        System.out.println("History sent to client");
    }

    private static void sendMatchHistory(PrintWriter out, List<String> completeMatchHistory) {
        for (String matchSummary : completeMatchHistory) {
            out.println(matchSummary);
        }
    }
}
