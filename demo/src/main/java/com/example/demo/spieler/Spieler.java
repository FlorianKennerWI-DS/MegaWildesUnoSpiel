package com.example.demo.spieler;

import com.example.demo.Karten.Karte;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.demo.spieler.HandkartenSortierung;

public class Spieler {
    String name;
    //Handkarten aus Klasse Karten
    ArrayList<ArrayList<Karte>> handkarten = new ArrayList<ArrayList<Karte>>();

    HashMap<String, ArrayList<Karte>> neueHandKarten = new HashMap<>();
    HashMap<String, HashMap<Integer, ArrayList<Karte>>> nochNeuereHandkarten = new HashMap<String, HashMap<Integer, ArrayList<Karte>>>();

    public String getName() {
        return name;
    }

    public Spieler (String name) {
        this.name = name;
        for (int i = 0; i<5;i++) {
            handkarten.add(new ArrayList<Karte>());
        }

        nochNeuereHandkarten.put("Blau", new HashMap<Integer, ArrayList<Karte>>());
        nochNeuereHandkarten.put("Gruen", new HashMap<Integer, ArrayList<Karte>>());
        nochNeuereHandkarten.put("Rot", new HashMap<Integer, ArrayList<Karte>>());
        nochNeuereHandkarten.put("Gelb", new HashMap<Integer, ArrayList<Karte>>());
        nochNeuereHandkarten.put("Schwarz", new HashMap<Integer, ArrayList<Karte>>());


    }

    public void ziehen(Karte karte) {
        if (!nochNeuereHandkarten.get(karte.getFarbe()).containsKey(karte.getZahl())) {
            nochNeuereHandkarten.get(karte.getFarbe()).put(karte.getZahl(), new ArrayList<Karte>());
        }
            nochNeuereHandkarten.get(karte.getFarbe()).get(karte.getZahl()).add(karte);

    }

    public Karte ablegen(Karte karte) {
        Karte abgelegteKarte = nochNeuereHandkarten.get(karte.getFarbe()).get(karte.getZahl()).get(0);
        nochNeuereHandkarten.get(karte.getFarbe()).get(karte.getZahl()).remove(0);
        return abgelegteKarte;
    }
        /*if (karte.getFarbe().equals("Rot")) {
            handkarten.get(0).remove(karte);
        }
        if (karte.getFarbe().equals("Blau")) {
            handkarten.get(1).remove(karte);
        }
        if (karte.getFarbe().equals("Gelb")) {
            handkarten.get(2).remove(karte);
        }
        if (karte.getFarbe().equals("Gruen")) {
            handkarten.get(3).remove(karte);
        }
        if (karte.getFarbe().equals("Schwarz")) {
            handkarten.get(4).remove(karte);
        }*/

    public HashMap<String, HashMap<Integer, ArrayList<Karte>>> getNochNeuereHandkarten() {
        return nochNeuereHandkarten;
    }

    public boolean hatKarten(){
        for (var entry : nochNeuereHandkarten.entrySet()){
            for (var secondEntry : entry.getValue().entrySet()){
                if (secondEntry.getValue().size() != 0){
                    return true;
                }
            }
        }
        return  false;
    }

    public int kartenZaehlen(){
        int anzahlKarten = 0;
        for (var entry : nochNeuereHandkarten.entrySet()){
            for (var secondEntry : entry.getValue().entrySet()){
                if (secondEntry.getValue().size() != 0){
                    anzahlKarten = anzahlKarten + secondEntry.getValue().size();
                }
            }
        }
        return anzahlKarten;
}}

