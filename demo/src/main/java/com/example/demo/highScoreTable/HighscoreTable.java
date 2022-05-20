package com.example.demo.highScoreTable;

import com.example.demo.spieler.Spieler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HighscoreTable {
    private HashMap<String, ArrayList<Integer>> alleSpieler = new HashMap<String, ArrayList<Integer>>();

    public  void einlesen() {
        String zeile = null;
        String spielerName;
        int position;
        Path meineDatei = Paths.get("./GameData.csv");
        try {
            // check if file with highscoredata exists, if not create it and write first line
            if (!Files.exists(meineDatei)){
                Files.createFile(meineDatei);
                BufferedWriter initialerWriter = Files.newBufferedWriter(meineDatei);
                initialerWriter.write("Name, Position");
                initialerWriter.close();
            }
            BufferedReader meinReader = Files.newBufferedReader(meineDatei);
            meinReader.readLine();
            zeile = meinReader.readLine();

            while (zeile != null){
                StringTokenizer zeilenToken = new StringTokenizer(zeile, ",");
                spielerName = zeilenToken.nextToken();
                position = Integer.parseInt(zeilenToken.nextToken());

                // check if name already exists in alleSpieler
                if (alleSpieler.containsKey(spielerName)){
                    alleSpieler.get(spielerName).add(position);
                }

                // else add name as key and position as value
                else {
                    alleSpieler.put(spielerName, new ArrayList<>(position));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO: do something with this information
    }

    public void spielAbspeichern(ArrayList<Spieler> spielende){
        
    }
}