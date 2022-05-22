package com.example.demo.spiel;

import com.example.demo.spieler.Computer;
import com.example.demo.spieler.Spieler;
import com.example.demo.stapel.AblegeStapel;
import com.example.demo.stapel.ZiehenStapel;
import java.util.ArrayList;

public class Spiel {
    public ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();
    public AblegeStapel ablegeStapel = new AblegeStapel();
    public ZiehenStapel ziehenStapel = new ZiehenStapel();
    Spieler menschlicherSpieler;
    int derzeitigerSpieler = 0;
    int step = 1; //direction in which to work through arraylist

    public Spiel(int spielerAnzahl) {

        ZiehenStapel.generieren();
        generiereSpieler(spielerAnzahl);
        kartenAusteilen();
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
                spieler.ziehen(ziehenStapel.nehmen());
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

        while (jemandIstFertig()){
            Spieler amZug = spielerListe.get(derzeitigerSpieler);
            if (amZug instanceof Computer) {
                //computer.waehleAktion()
                if ("ziehen".equals(amZug.waehleAktion())) { //Typ casten?
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
    }

    public static void main (String[] args) {

        Spiel spiel = new Spiel(2);
        spiel.spielen();
    }
}
