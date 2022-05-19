package com.example.demo.stapel;

import com.example.demo.Karten.Karte;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Stack;

public class ZiehenStapel {
    private Stack<Karte> kartenStack = new Stack<>();
    public int laenge;

    public Karte nehmen(){
        return kartenStack.pop();
    }

    public static Stack<Karte> generieren(){
        ArrayList<Karte> alleKarten = new ArrayList<>(){};

        alleKarten.add(new Karte("Blau", 0));
        alleKarten.add(new Karte("Blau", 1));
        alleKarten.add(new Karte("Blau", 1));
        alleKarten.add(new Karte("Blau", 2));
        alleKarten.add(new Karte("Blau", 2));
        alleKarten.add(new Karte("Blau", 3));
        alleKarten.add(new Karte("Blau", 3));
        alleKarten.add(new Karte("Blau", 4));
        alleKarten.add(new Karte("Blau", 4));
        alleKarten.add(new Karte("Blau", 5));
        alleKarten.add(new Karte("Blau", 5));
        alleKarten.add(new Karte("Blau", 6));
        alleKarten.add(new Karte("Blau", 6));
        alleKarten.add(new Karte("Blau", 7));
        alleKarten.add(new Karte("Blau", 7));
        alleKarten.add(new Karte("Blau", 8));
        alleKarten.add(new Karte("Blau", 8));
        alleKarten.add(new Karte("Blau", 9));
        alleKarten.add(new Karte("Blau", 9));

        alleKarten.add(new Karte("Gruen", 0));
        alleKarten.add(new Karte("Gruen", 1));
        alleKarten.add(new Karte("Gruen", 1));
        alleKarten.add(new Karte("Gruen", 2));
        alleKarten.add(new Karte("Gruen", 2));
        alleKarten.add(new Karte("Gruen", 3));
        alleKarten.add(new Karte("Gruen", 3));
        alleKarten.add(new Karte("Gruen", 4));
        alleKarten.add(new Karte("Gruen", 4));
        alleKarten.add(new Karte("Gruen", 5));
        alleKarten.add(new Karte("Gruen", 5));
        alleKarten.add(new Karte("Gruen", 6));
        alleKarten.add(new Karte("Gruen", 6));
        alleKarten.add(new Karte("Gruen", 7));
        alleKarten.add(new Karte("Gruen", 7));
        alleKarten.add(new Karte("Gruen", 8));
        alleKarten.add(new Karte("Gruen", 8));
        alleKarten.add(new Karte("Gruen", 9));
        alleKarten.add(new Karte("Gruen", 9));

        alleKarten.add(new Karte("Gelb", 0));
        alleKarten.add(new Karte("Gelb", 1));
        alleKarten.add(new Karte("Gelb", 1));
        alleKarten.add(new Karte("Gelb", 2));
        alleKarten.add(new Karte("Gelb", 2));
        alleKarten.add(new Karte("Gelb", 3));
        alleKarten.add(new Karte("Gelb", 3));
        alleKarten.add(new Karte("Gelb", 4));
        alleKarten.add(new Karte("Gelb", 4));
        alleKarten.add(new Karte("Gelb", 5));
        alleKarten.add(new Karte("Gelb", 5));
        alleKarten.add(new Karte("Gelb", 6));
        alleKarten.add(new Karte("Gelb", 6));
        alleKarten.add(new Karte("Gelb", 7));
        alleKarten.add(new Karte("Gelb", 7));
        alleKarten.add(new Karte("Gelb", 8));
        alleKarten.add(new Karte("Gelb", 8));
        alleKarten.add(new Karte("Gelb", 9));
        alleKarten.add(new Karte("Gelb", 9));

        alleKarten.add(new Karte("Rot", 0));
        alleKarten.add(new Karte("Rot", 1));
        alleKarten.add(new Karte("Rot", 1));
        alleKarten.add(new Karte("Rot", 2));
        alleKarten.add(new Karte("Rot", 2));
        alleKarten.add(new Karte("Rot", 3));
        alleKarten.add(new Karte("Rot", 3));
        alleKarten.add(new Karte("Rot", 4));
        alleKarten.add(new Karte("Rot", 4));
        alleKarten.add(new Karte("Rot", 5));
        alleKarten.add(new Karte("Rot", 5));
        alleKarten.add(new Karte("Rot", 6));
        alleKarten.add(new Karte("Rot", 6));
        alleKarten.add(new Karte("Rot", 7));
        alleKarten.add(new Karte("Rot", 7));
        alleKarten.add(new Karte("Rot", 8));
        alleKarten.add(new Karte("Rot", 8));
        alleKarten.add(new Karte("Rot", 9));
        alleKarten.add(new Karte("Rot", 9));


        int kartenAnzahl = alleKarten.size();
        Stack<Karte> gemischterStapel = new Stack<>();

        for (int i = 0; i < kartenAnzahl; i ++){
            int index = ThreadLocalRandom.current().nextInt(0, alleKarten.size()) ;
            gemischterStapel.push(alleKarten.get(index));
            alleKarten.remove(index);
        }
        return gemischterStapel;





    }
}


