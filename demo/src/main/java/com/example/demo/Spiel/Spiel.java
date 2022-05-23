package com.example.demo.Spiel;


import com.example.demo.nichtablegen.NichtAblegen;

import com.example.demo.Karten.Karte;

import com.example.demo.spieler.Computer;
import com.example.demo.StapelLeer.Stapelleer;
import com.example.demo.spieler.Spieler;
import com.example.demo.stapel.AblegeStapel;
import com.example.demo.stapel.ZiehenStapel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

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

    public String getSpielerName() {
        return spielende.get(derzeitigerSpieler).getName();
    }

    public String getKartenStand() {
        StringBuilder result = new StringBuilder();
        for (Spieler spieler: spielende) {
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
                    System.exit(0);
                    if((spieler.kartenZaehlen())>(Computer.kartenZaehlen())) {
                        System.out.println("Unentschieden");
                    }
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
                    System.exit(0);
                    System.out.println("Unentschieden");
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

}
