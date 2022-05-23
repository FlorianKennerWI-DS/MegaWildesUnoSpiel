package com.example.demo.spiel;


import com.example.demo.UpdateThread;
import com.example.demo.customExceptions.NichtAblegenException;

import com.example.demo.karten.Karte;

import com.example.demo.spieler.Computer;
import com.example.demo.spieler.Spieler;
import com.example.demo.stapel.AblegeStapel;
import com.example.demo.stapel.ZiehenStapel;
import com.example.demo.customExceptions.StapelLeerException;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Spiel {
    private ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();
    private AblegeStapel ablegeStapel = new AblegeStapel();
    private ZiehenStapel ziehenStapel = new ZiehenStapel();


    public StringProperty aktuellerSpielerName = new SimpleStringProperty();
    public StringProperty getKartenStand = new SimpleStringProperty();
    public ListProperty menschlicherSpielerKarten = new SimpleListProperty();

    public ObservableList<Node> spielerButtons = FXCollections.observableArrayList();
    Spieler menschlicherSpieler;
    int derzeitigerSpieler = 0;
    int step = 1; //direction in which to work through arraylist
    int anfang = 0; //0 or spielerliste.size() falls Reihenfolge falschrum


    public Spiel(int spielerAnzahl) {

        ziehenStapel.generieren();
        generiereSpieler(spielerAnzahl);
        kartenAusteilen();
        getKartenStand.setValue(setKartenStand());
        menschlicherSpielerKarten.setValue(spielerButtons);
        try {
            ablegeStapel.setObersteKarte(ziehenStapel.nehmen());
        }
        catch(Exception e){}
    }

    public String getAktSpieler() {
        return "Spieler "+spielerListe.get(derzeitigerSpieler).getName()+" ist dran.";
    }

    public String setKartenStand() {
        StringBuilder result = new StringBuilder();
        for (Spieler spieler: spielerListe) {
            result.append("Spieler "+spieler.getName()+": "+spieler.kartenZaehlen()+" Karten");
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }

    public Karte showLetzteKarte() {
        return new Karte("Gelb", 1);
    }

    public void buttonsFuerMenschlichenSpieler() {
        spielerButtons.clear();
        System.out.println(menschlicherSpieler.getHandkartenArrayList());
        for (Karte karte: menschlicherSpieler.getHandkartenArrayList()){
            Button button = new Button(Integer.toString(karte.getZahl()));
            button.setOnAction(actionEvent -> {
                amZugPruefen(karte);
                UpdateThread update = new UpdateThread(button);
                naechsterSpieler();
                update.start();
            });
            button.setDisable(!ablegeStapel.getObersteKarte().kompatibilitaetPruefen(karte));
            button.setMinSize(60, 100);
            button.setFont(new Font(20));
            button.setStyle(String.format("-fx-background-color: %s;-fx-background-radius: 10px", Karte.hexColors.get(karte.getFarbe())));
            spielerButtons.add(button);
        }
    }

    public void menschlicherSpielerZiehen(){
        //  if (!(spielerListe.get(derzeitigerSpieler) instanceof Computer)){
        menschlicherSpieler.ziehen(new Karte("Blau", 1));//}
        menschlicherSpieler.handKartenToArrayList();
        System.out.println(menschlicherSpieler.getHandkartenArrayList());
        menschlicherSpieler.handKartenToArrayList();

        naechsterSpieler();
    }

    public void amZugPruefen(Karte karte){
        if (!(spielerListe.get(derzeitigerSpieler) instanceof Computer)){
            ablegeStapel.setObersteKarte(menschlicherSpieler.ablegen(karte));
        }
    }

    private void naechsterSpieler() {
        //int anfang + spielerliste.size()*step == derzeitigerSpieler -> fuer aktionskarte
        if (derzeitigerSpieler == (spielerListe.size()-1)) {
            derzeitigerSpieler = anfang;
        } else {
            derzeitigerSpieler = derzeitigerSpieler + step;
        }
        aktuellerSpielerName.setValue(getAktSpieler());
        getKartenStand.setValue(setKartenStand());
    }

    private void generiereSpieler(int spielerAnzahl) {

        menschlicherSpieler = new Spieler("");
        spielerListe.add(menschlicherSpieler);
        for (int i = 0; i < spielerAnzahl; i++) {
            spielerListe.add(new Computer(i)); //add computergegner
        }
    }

    private void kartenAusteilen() {

        for (Spieler spieler:spielerListe) {
            for (int j =0; j<7;j++) {
                try {
                    spieler.ziehen(ziehenStapel.nehmen());
                } catch (StapelLeerException e) {
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
                    try {
                        //computer.waehleAktion()
                        ablegeStapel.setObersteKarte(((Computer) amZug).karteFinden(ablegeStapel.getObersteKarte()));
                        }

                        catch(NichtAblegenException e){
                            System.out.println(e.getMessage());
                            try {
                                amZug.ziehen(ziehenStapel.nehmen());}
                            catch (StapelLeerException stapelLeerExceptionE){
                                stapelLeerExceptionE.getMessage();
                    }}
                naechsterSpieler();
                }

            }
            //else {
                    //enableActions()
                // }
            //TODO: Check ob nächster spieler ist computer
            //          --> Dann dieser aktion
            //      Anosonten auf eingabe warten
        }
    }
    /*

    public static void main (String[] args) {
        Spiel spiel = new Spiel(2);
        //spiel.spielen();
    }*/

