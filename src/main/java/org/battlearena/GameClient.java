package org.battlearena;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class GameClient {

    private Socket socket;
    private PrintWriter socketWriter;
    private BufferedReader socketReader;

    public GameClient(){
        this.socket = null;
        this.socketWriter = null;
        this.socketReader = null;

    }
    //Anslut till servern, returnera true om anslutningen lyckades eller om vi redan var anslutna
    private boolean connect(){
        if(!isConnected()){
            try{
                socket = new Socket("localhost", 5000); //Man öppnar en socket, en port
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Läser in information i bytes via socket.
                socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                socketWriter = new PrintWriter(socket.getOutputStream(), true);
                return true; // Om detta returnerar true, då är man connected.
            }catch(Exception e){
                e.printStackTrace(); // skriv ut felmeddelande
                this.socket = null;
                this.socketWriter = null;
                this.socketReader = null;
                return false; // har inte lyckats ansluta till servern
            }
        }else{
            return true; // vi är redan anslutna till servern.
        }
    }
    //returnera true om vi är anslutna.
    private boolean isConnected(){
        return socketWriter != null; //Om socketWriter finns, då är vi connected.
    }
    //skicka gamehistory till servern, returnera true om det lyckas.
    public boolean sendGameHistory(List<String> gameHistory){
        if(connect()){
            for(String s: gameHistory){
                socketWriter.println(s);
            }
            return true;
        }else{
            return false;
        }
    }
    // Skicka en request till servern där vi begär spelhistoriken
    // Den här metoden förutsätter att vi är connected, den får inte anropas om vi inte är connected
    private void sendGameHistoryRequest(){
        socketWriter.println("REQUEST_GAME_HISTORY");
    }

    //Hämta gameHistory från servern.
    //Vi gör detta genom att skicka kommandot REQUEST_GAME_HISTORY sedan läser allt som servern skickar tillbaka
    //När servern skickar tillbaka END så är det klart
    public List<String> getGameHistory()throws Exception{
        if(connect()){
            //det är garanterat att vi är connected
            sendGameHistoryRequest(); //begär gamehistory från servern
            ArrayList <String> gameHistory = new ArrayList<>();
            String response = "";
            while(!response.equalsIgnoreCase("END")){
                response = socketReader.readLine(); //läs varje rad som servern skickar tillbaka
                if(response != null){
                    response = response.trim(); // ta bort överflödiga mellanslag och radbrytningar
                }
                if(response == null || response.equalsIgnoreCase("END")){
                    break; //Om servern skickar tillbaka END eller om response är null så är vi klara.
                }
                gameHistory.add(response); //lägg till serverns svar i historiken
            }
            return gameHistory; //returnera all game history som vi har fått från servern
        }else{
            return null;
        }
    }

}

