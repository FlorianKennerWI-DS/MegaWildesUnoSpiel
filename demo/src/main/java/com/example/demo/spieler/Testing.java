package com.example.demo.spieler;

import com.example.demo.Karten.Karte;

public class Testing {
    public static void main(String[] args) {
        Spieler s1 = new Spieler("Florian");
        s1.ziehen(new Karte("Blau", 2));
        System.out.println(s1.getNochNeuereHandkarten());
        System.out.println(s1.hatKarten());

        Spieler s2 = new Spieler("Malena");
        System.out.println(s2.hatKarten());

        System.out.println(s1.ablegen(new Karte("Blau", 2)));
        System.out.println(s1.hatKarten());
    }
}
