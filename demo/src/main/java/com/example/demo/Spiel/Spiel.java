package com.example.demo.Spiel;

import com.example.demo.nichtablegen.NichtAblegen;
import com.example.demo.spieler.Computer;
import com.example.demo.StapelLeer.Stapelleer;
import com.example.demo.spieler.Spieler;
import com.example.demo.stapel.AblegeStapel;
import com.example.demo.stapel.ZiehenStapel;

import java.util.ArrayList;

public class Spiel {
    ArrayList<Spieler> spielende = new ArrayList<Spieler>();
    AblegeStapel ablegeStapel = new AblegeStapel();
    ZiehenStapel ziehenStapel = new ZiehenStapel();
    Spieler menschlicherSpieler;
    int derzeitigerSpieler = 0;
    int step = 1; //direction in which to work through arraylist

    public Spiel(int spielerAnzahl) {
        ziehenStapel.generieren();
        generiereSpieler(spielerAnzahl);
        kartenAusteilen();
    }

    private void generiereSpieler(int spielerAnzahl) {
        menschlicherSpieler = new Spieler("Mensch");
        spielende.add(menschlicherSpieler);
        for (int i = 0; i < spielerAnzahl; i++) {
            spielende.add(new Computer(i)); //add computergegner
        }
    }

    private void kartenAusteilen() {
        for (Spieler spieler:spielende) {
            for (int j =0; j<7;j++) {
                try {
                    spieler.ziehen(ziehenStapel.nehmen());
                } catch (Stapelleer e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private boolean jemandIstFertig() {
        for (Spieler spieler:spielende) {
            if (!spieler.hatKarten()){
                return true;
            }
        }
        return false;
    }

    public void spielen () {
        while (jemandIstFertig()){
            Spieler amZug = spielende.get(derzeitigerSpieler);
            if (amZug instanceof Computer) {
                Computer.waehleAktion();{
                    try {
                        if (!(ablegeStapel.ablegen(Computer.ablegen()))) {
                            throw new NichtAblegen("Kann keine Karte ablegen");

                        }
                        }catch(NichtAblegen e){
                            System.out.println(e.getMessage());
                    }
                    }else { Computer.ziehen(ziehenStapel.nehmen()); }
                }

                try{if ("ziehen".equals(amZug.waehleAktion())) { //Typ casten?
                    amZug.ziehen(ziehenStapel.nehmen());
                }
                } catch (Stapelleer e) {
                    System.out.println(e.getMessage());
                }
                }else {
                    ablegeStapel.ablegen(amZug.ablegen()); //TODO spieler.ablegen returned karte
            } else {
                    //enableActions()
                }
            //TODO: Check ob nächster spieler ist computer
            //          --> Dann dieser aktion
            //      Anosonten auf eingabe warten
            //

        }
    }
    }

    public static void main (String[] args) {
        Spiel spiel = new Spiel(2);
        //spiel.spielen();
    }
}
