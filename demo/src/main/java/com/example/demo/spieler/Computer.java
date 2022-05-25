package com.example.demo.spieler;

import com.example.demo.karten.Karte;
import com.example.demo.customExceptions.NichtAblegenException;

public class Computer extends Spieler {

    // Malena, Annika und Florian
    public Computer(int i) {
        super("com" + Integer.toString(i));
    } //erzeugt Computergegner mit Namen

    public Karte karteFinden(Karte obersteKarte) throws NichtAblegenException { //sucht Karte, die abgelegt werden kann

        boolean passendeFarbe = false;
        boolean passendeZahl = false;
        Karte passendeKarte = null ;

        //suche nach Karte derselben Farbe
        for (var entry : handkarten.get(obersteKarte.getFarbe()).entrySet()){
            if (entry.getValue().size() > 0){
                passendeFarbe = true;
                passendeKarte = entry.getValue().get(0);
                break; //for-Schleife beenden, sobald passende Karte gefunden -> Laufzeitoptimierung
            }
        }

        //suche nach Karte mit derselben Zahl, falls keine mit passender Farbe gefunden
        if (!passendeFarbe) {
            for (var entry : handkarten.entrySet()){

                for (var secondEntry : entry.getValue().entrySet()){
                    if (secondEntry.getValue().size() != 0) {
                        if (secondEntry.getValue().get(0).getZahl() == obersteKarte.getZahl()){
                            passendeZahl = true;
                            passendeKarte = secondEntry.getValue().get(0);
                            break;
                        }
                    }
                }
            }
        }

        if (!passendeFarbe && !passendeZahl){
            throw new NichtAblegenException();
        }
        return ablegen(passendeKarte);
}}
