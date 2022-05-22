package com.example.demo.karten;

public class Testing {
    public static void main(String[] args) {
        Karte k1 = new Karte("Blau", 1);
        Karte k2 = new Karte("Gruen", 1);
        Karte k3 = new Karte("Blau", 4);

        System.out.print(k1.kompatibilitaetPruefen(k2));
        System.out.print(k1.kompatibilitaetPruefen(k3));
        System.out.println(k2.kompatibilitaetPruefen(k3));
    }
}
