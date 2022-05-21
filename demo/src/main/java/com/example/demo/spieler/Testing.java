package com.example.demo.spieler;

import com.example.demo.Karten.Karte;

public class Testing {
    public static void main(String[] args) {
        Spieler s1 = new Spieler("Florian");
        s1.ziehen(new Karte("Blau", 2));
        s1.ziehen(new Karte("Blau", 2));
        System.out.println(s1.getNochNeuereHandkarten());
        System.out.println(s1.hatKarten());

        Spieler s2 = new Spieler("Malena");
        System.out.println(s2.hatKarten());

        System.out.println(s1.ablegen(new Karte("Blau", 2)));
        System.out.println(s1.getNochNeuereHandkarten());
        System.out.println(s1.hatKarten());

        // Testing the Computer

        Computer c1 = new Computer(1);
        c1.ziehen(new Karte("Gruen", 1));
        System.out.println(c1.getNochNeuereHandkarten());
        try {
            System.out.println(c1.karteFinden(new Karte("Blau", 1)));
        }catch  (Exception e){
            e.printStackTrace();
        }
        System.out.println(c1.getNochNeuereHandkarten());
    }
}
