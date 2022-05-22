package com.example.demo.spiel;


import com.example.demo.nichtablegen.NichtAblegen;

import com.example.demo.Karten.Karte;

import com.example.demo.spieler.Computer;
import com.example.demo.spieler.Spieler;
import com.example.demo.stapel.AblegeStapel;
import com.example.demo.stapel.ZiehenStapel;
import com.example.demo.stapelLeer.StapelLeer;

import java.util.ArrayList;

public class Spiel {
    public ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();
    public AblegeStapel ablegeStapel = new AblegeStapel();
    public ZiehenStapel ziehenStapel = new ZiehenStapel();
    Spieler menschlicherSpieler;
    int derzeitigerSpieler = 0;
    int step = 1; //direction in which to work through arraylist


    public Spiel(int spielerAnzahl) {

        ziehenStapel.generieren();
        generiereSpieler(spielerAnzahl);
        kartenAusteilen();
    }

    public String getSpielerName() {
        return spielerListe.get(derzeitigerSpieler).getName();
    }

    public String getKartenStand() {
        StringBuilder result = new StringBuilder();
        for (Spieler spieler: spielerListe) {
            result.append("Spieler "+spieler.getName()+": "+spieler.getKartenZahl()+" Karten");
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }

    public Karte showLetzteKarte() {
        return new Karte("Gruen", 3);
    }

    public ObservableList<Node> getHandKarten() {
        ObservableList<Node> result = FXCollections.observableArrayList();
        result.add(new Karte("Gruen", 3));
        result.add(new Karte("Blau", 7));
        return result;
    }

    private void generiereSpieler(int spielerAnzahl) {

        menschlicherSpieler = new Spieler();
        spielerListe.add(menschlicherSpieler);
        for (int i = 0; i < spielerAnzahl; i++) {
            spielerListe.add(new Spieler()); //add computergegner
        }
    }

    private void kartenAusteilen() {

        for (Spieler spieler:spielerListe) {
            for (int j =0; j<7;j++) {
                try {
                    spieler.ziehen(ziehenStapel.nehmen());
                } catch (StapelLeer e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    private boolean jemandIstFertig() {

        for (Spieler spieler:spielerListe) {
            if (!spieler.hatKarten()){
                return true;
            }
        }
        return false;
    }

    public void spielen () {
        while (!jemandIstFertig()){
            Spieler amZug = spielerListe.get(derzeitigerSpieler);
            if (amZug instanceof Computer) {
                Computer.waehleAktion();{
                    try {
                        //computer.waehleAktion()
                        if (!(ablegeStapel.ablegen(Computer.ablegen()))) {
                            throw new NichtAblegen("Kann keine Karte ablegen");

                        }

                        }catch(NichtAblegen e){
                            System.out.println(e.getMessage());
                            Computer.ziehen(ziehenStapel.nehmen());
                    }

                }

                try{if ("ziehen".equals(amZug.waehleAktion())) { //Typ casten?
                    amZug.ziehen(ziehenStapel.nehmen());
                } else {
                    ablegeStapel.ablegen(amZug.ablegen()); //TODO spieler.ablegen returned karte
            } //else {
                    //enableActions()
                // }
            //TODO: Check ob nächster spieler ist computer
            //          --> Dann dieser aktion
            //      Anosonten auf eingabe warten
        }
    }
    }/*

    public static void main (String[] args) {
        Spiel spiel = new Spiel(2);
        //spiel.spielen();
    }*/
}
