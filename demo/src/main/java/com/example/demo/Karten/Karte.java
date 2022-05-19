package com.example.demo.Karten;

import java.util.Random;

public class Karte {


    String farbe;
    int zahl;


    public Karte (String farbe, int zahl) {
        this.farbe = farbe;
        this.zahl =  zahl;
    }


    public String toString() {
        return (farbe + " " + Integer.toString(zahl));
    }


    }

