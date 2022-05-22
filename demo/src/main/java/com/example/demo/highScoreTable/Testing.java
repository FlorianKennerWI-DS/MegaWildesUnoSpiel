package com.example.demo.highScoreTable;

import com.example.demo.Karten.Karte;
import com.example.demo.spieler.Computer;
import com.example.demo.spieler.Spieler;

import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) {
        Spieler s1 = new Spieler("Florian");
        s1.ziehen(new Karte("Blau", 2));


        Computer c1 = new Computer(1);
        Computer c2 = new Computer(2);
        c2.ziehen(new Karte("Gelb", 5));
        c2.ziehen(new Karte("Gelb", 5));

        Computer c3 = new Computer(3);
        c1.ziehen(new Karte("Blau", 2));
        c1.ziehen(new Karte("Blau", 2));
        c1.ziehen(new Karte("Gruen", 2));
        c1.ziehen(new Karte("Gruen", 2));



        ArrayList<Spieler> spielende = new ArrayList<>();
        spielende.add(s1);
        spielende.add(c2);
        spielende.add(c1);
        spielende.add(c3);
        HighscoreTable.spielAbspeichern(spielende);

    }
}
