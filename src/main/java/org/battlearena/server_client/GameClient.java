package org.battlearena.server_client;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class GameClient {

    private Socket socket;
    private PrintWriter socketWriter;
    private BufferedReader socketReader;

    public GameClient() {
        this.socket = null;
        this.socketWriter = null;
        this.socketReader = null;

    }


    // Establish a connection to the server if one is not already open.
    // Return true if a connection exists or was successfully established.
    private boolean connect() {
        if (!isConnected()) {
            try {
                socket = new Socket("localhost", 5000); //Man öppnar en socket, en port
                socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));// Läser in information i bytes via socket.
                socketWriter = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                return true; // Om detta returnerar true, då är man connected.
            } catch (IOException e) {
                System.out.println("Could not connect to server" + e.getMessage()); // skriv ut felmeddelande
                disconnect();// Close any partially established connection and reset the fields
                return false; // har inte lyckats ansluta till servern
            }
        } else {
            return true; // vi är redan anslutna till servern.
        }
    }

    //returnera true om vi är anslutna.
    private boolean isConnected() {
        return socketWriter != null && socket != null && !socket.isClosed(); //Om socketWriter finns, då är vi connected.
    }

    // Send the match summary to the server.
    // Return true if the connection exists and the message is sent through the writer
    public boolean relayMatchSummary(String matchSummary) {
        if (connect()) {
            socketWriter.println(matchSummary);// Send the match summary as a line of text
            return true;
        } else {
            return false;
        }
    }

    // Receive the complete match history from the server.
    // Read one line at a time until the server sends the END marker.
    public List<String> getGameHistory() throws IOException {
        if (connect()) {
            //det är garanterat att vi är connected
            ArrayList<String> gameHistory = new ArrayList<>();
            String response;
            while (true) {
                response = socketReader.readLine(); //läs varje rad som servern skickar tillbaka
                if (response == null) {
                    System.out.println("Server connection closed before end transmission");
                    return null;
                }
                response = response.trim();
                if (response.equalsIgnoreCase("END")) {
                    break;
                }
                if (response.startsWith("ERROR:")) {
                    System.out.println(response);
                    return null;
                }
                gameHistory.add(response); //lägg till serverns svar i historiken
            }
            return gameHistory; //returnera all game history som vi har fått från servern
        } else {
            return null;
        }
    }

    // Send the match summary to the server and retrieve the updated match history.
    // Disconnect from the server after the operation, regardless of its outcome
    public List<String> saveMatchAndGetHistory(String matchSummary) {
        if (connect()) {
            try {
                if (!relayMatchSummary(matchSummary)){
                    System.out.println("Could not send match summary to server");
                    return null;
                }

                return getGameHistory(); // Receive and return the updated match history

            } catch (IOException e) {
                System.out.println("Error receiving match history: " + e.getMessage());
                return null;
            } finally {
                disconnect();
            }
        } else {
            return null;
        }
    }
    // Close the socket and reset the connection-related fields.
    private void disconnect() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing connection " + e.getMessage());
        }
        socket = null;
        socketWriter = null;
        socketReader = null;
    }
}

