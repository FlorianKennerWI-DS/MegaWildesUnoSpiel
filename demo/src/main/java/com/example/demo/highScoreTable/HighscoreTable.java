package com.example.demo.highScoreTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class HighscoreTable {
    private static HashMap<String, ArrayList<Integer>> alleSpieler = new HashMap<String, ArrayList<Integer>>();
    private static HashMap<String, Integer> alleDurschnittsPositionen = new HashMap<String, Integer>();

    public static void einlesen() {
        String zeile = null;
        Path meineDatei = Paths.get("./GameData.csv");
        try {
            // check if file with highscoredata exists, if not create it and write first line
            if (!Files.exists(meineDatei)){
                Files.createFile(meineDatei);
                BufferedWriter initialerWriter = Files.newBufferedWriter(meineDatei);
                initialerWriter.write("Name,Position");
                initialerWriter.close();
            }
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
            System.out.println(alleSpieler);
        } catch (Exception e) {
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
            int eintelneDurchschnittsPosition = positionsSumme / entry.getValue().size();
            alleDurschnittsPositionen.put(name, eintelneDurchschnittsPosition);
        }
    }
/*
    public void spielAbspeichern(ArrayList<Spieler> spielende){
        
    }*/
}