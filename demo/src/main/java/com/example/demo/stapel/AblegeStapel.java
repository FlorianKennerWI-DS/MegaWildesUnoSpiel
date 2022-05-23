package com.example.demo.stapel;

import com.example.demo.karten.Karte;
import javafx.beans.value.ObservableValue;


public class AblegeStapel {
    private int count;
    private Karte obersteKarte;
    //public ObservableValue<Karte> obersteKarteView = (ObservableValue<Karte>) new Karte("Gruen", 4);

    public Karte getObersteKarte() {
        return obersteKarte;
    }

    private void higherCount() {
        this.count ++;
    }

    public void setObersteKarte(Karte obersteKarte) {
        higherCount();
        this.obersteKarte = obersteKarte;
        //obersteKarteView.
    }
}
