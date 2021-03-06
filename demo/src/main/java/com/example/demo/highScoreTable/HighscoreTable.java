package com.example.demo.highScoreTable;

import com.example.demo.spieler.Computer;
import com.example.demo.spieler.Spieler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class HighscoreTable {
    private static HashMap<String, ArrayList<Integer>> alleSpieler = new HashMap<String, ArrayList<Integer>>();
    private static HashMap<String, Integer> alleDurschnittsPositionen = new HashMap<String, Integer>();

    public static void einlesen() {
        String zeile;
        Path meineDatei = Paths.get("./GameData.csv");
        try {
        // check if file with highscoredata exists, if not create it and write first line
        dateiPfadPruefen(meineDatei);
        BufferedReader meinReader = Files.newBufferedReader(meineDatei);
        meinReader.readLine();
        zeile = meinReader.readLine();

        while (zeile != null){
            StringTokenizer zeilenToken = new StringTokenizer(zeile, ",");
            String spielerName = zeilenToken.nextToken();
            int position = Integer.parseInt(zeilenToken.nextToken());

            // check if name already exists in alleSpieler
            if (alleSpieler.containsKey(spielerName)){
                alleSpieler.get(spielerName).add(position);
            }

            // else add name as key and position as value
            else {
                alleSpieler.put(spielerName, new ArrayList<>());
                alleSpieler.get(spielerName).add(position);
            }
            zeile = meinReader.readLine();
        }
        meinReader.close();}catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void berechneDurchschnittsPosition(){
        for (var entry : alleSpieler.entrySet()){
            int positionsSumme = 0;
            String name = entry.getKey();
            for (int aktuellerPlatz : entry.getValue()){
                positionsSumme = positionsSumme + aktuellerPlatz;
            }
            int einzelneDurchschnittsPosition = positionsSumme / entry.getValue().size();
            alleDurschnittsPositionen.put(name, einzelneDurchschnittsPosition);
        }
    }

    public static void spielAbspeichern(ArrayList<Spieler> spielende){
        Path meineDatei = Paths.get("./GameData.csv");
        int Position = 0;
        String name = "";
        // sorting the spielende ArrayList by the number of Cards on their hands
        spielende.sort(Comparator.comparingInt(s -> s.kartenZaehlen())); // implemented getHandkarten to Spieler Klasse
        System.out.println(spielende);
        dateiPfadPruefen(meineDatei);
        try {
            BufferedWriter writer = Files.newBufferedWriter(meineDatei, StandardOpenOption.APPEND);

            // searching the position of the human player
            for (int index = 0; index < spielende.size(); index++){
                if (!(spielende.get(index) instanceof Computer)){
                    Position = index + 1;
                    name = spielende.get(index).getName();
                }
            }

            // writing the player name and position in the GameData.csv file
            writer.write("\n" +name + "," + Position);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void dateiPfadPruefen(Path pfad){
        try {
            // check if file with highscoredata exists, if not create it and write first line
            if (!Files.exists(pfad)) {
                Files.createFile(pfad);
                BufferedWriter initialerWriter = Files.newBufferedWriter(pfad);
                initialerWriter.write("Name,Position");
                initialerWriter.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}