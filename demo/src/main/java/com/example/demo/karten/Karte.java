package com.example.demo.karten;

public class Karte {
    public String farbe;
    public int zahl;

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

