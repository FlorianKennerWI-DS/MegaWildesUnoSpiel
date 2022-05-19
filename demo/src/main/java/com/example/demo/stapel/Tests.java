package com.example.demo.stapel;

import com.example.demo.Karten.Karte;

public class Tests {
    public static void main(String[] args) {
        ZiehenStapel.generieren().forEach(System.out::println);
       // System.out.println(new Karte("Blau", 1));
    }
}
