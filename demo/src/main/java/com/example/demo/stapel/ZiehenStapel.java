package com.example.demo.stapel;

import com.example.demo.karten.Karte;
import com.example.demo.customExceptions.StapelLeerException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Stack;
// Florian
public class ZiehenStapel {
    //Stack als Datenstruktur, weil LIFO hier passend
    public Stack<Karte> kartenStack = new Stack<>();

    //gibt die oberste Karte zurueck
    public Karte nehmen() throws StapelLeerException {

        if (kartenStack.size() == 0) {
            throw new StapelLeerException("Stapel leer");
        } else
            return kartenStack.pop();
        }


    public void generieren(){
        ArrayList<Karte> alleKarten = new ArrayList<>(){};

        for (String farbe : new String[]{"Gruen", "Rot", "Gelb", "Blau"}) {
            for (int i = 0; i<=9;i++) {
                alleKarten.add(new Karte(farbe, i));
                alleKarten.add(new Karte(farbe, i));
            }
        }

        int kartenAnzahl = alleKarten.size();
        Stack<Karte> gemischterStapel = new Stack<>();

        for (int i = 0; i < kartenAnzahl; i ++){

            int index = ThreadLocalRandom.current().nextInt(0, alleKarten.size()) ;
            gemischterStapel.push(alleKarten.get(index));
            alleKarten.remove(index);
        }
        kartenStack =  gemischterStapel;
    }
    public boolean stapelLeer(){
        if (kartenStack.isEmpty()){
            return true;
        }
        return false;
    }
}


