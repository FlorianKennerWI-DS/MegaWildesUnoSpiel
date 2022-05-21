package com.example.demo.Karten;

import java.util.HashMap;
import java.util.Random;

public class Karte {

    String farbe;
    public static HashMap<String, Integer> farbID;
    static {
        farbID = new HashMap<String, Integer>();
        farbID.put("Rot", 0);
        farbID.put("Blau", 1);
        farbID.put("Gelb", 2);
        farbID.put("Gruen", 3);
        farbID.put("Schwarz", 4);
    }
    int zahl;

    public String getFarbe() {
        return farbe;
    }

    public int getZahl() {
        return zahl;
    }

    public Karte (String farbe, int zahl) {
        this.farbe = farbe;
        this.zahl =  zahl;
    }

    public String toString() {
        return (farbe + " " + Integer.toString(zahl));
    }

    }

