package com.example.demo.spieler;

import com.example.demo.karten.Karte;

public class Testing {
    public static void main(String[] args) {
        Spieler s1 = new Spieler("Florian");
        s1.ziehen(new Karte("Gruen", 1));
        System.out.println(s1.getHandkarten());
        System.out.println(s1.hatKarten());
        s1.ablegen(new Karte("Gruen", 1));
        System.out.println(s1.getHandkarten());
        s1.handKartenToArrayList();
        System.out.println(s1.getHandkartenArrayList());
        Spieler s2 = new Spieler("Malena");
        System.out.println(s2.hatKarten());



        s1.handKartenToArrayList();
        System.out.println(s1.handkarten);
        // Testing the Computer

        Computer c1 = new Computer(1);
        c1.ziehen(new Karte("Gruen", 1));
        System.out.println(c1.getHandkarten());
        try {
            System.out.println(c1.karteFinden(new Karte("Blau", 1)));
        }catch  (Exception e){
            e.printStackTrace();
        }
        System.out.println(c1.getHandkarten());
    }
}
