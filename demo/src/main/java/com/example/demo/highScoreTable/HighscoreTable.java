package com.example.demo.highScoreTable;

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
                    alleSpieler.put(spielerName, alleSpieler.get(spielerName));
                }
            }


        } catch (Exception e) {

        }

    }
}