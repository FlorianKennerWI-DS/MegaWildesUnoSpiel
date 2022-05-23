package com.example.demo.stapel;

import com.example.demo.karten.Karte;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AblegeStapel {
    private int count;
    private Karte obersteKarte;
    public ObservableList<Karte> obersteKarteBeobachten = FXCollections.observableArrayList();

    public Karte getObersteKarte() {
        return obersteKarte;
    }

    private void higherCount() {
        this.count ++;
    }

    public void setObersteKarte(Karte obersteKarte) {
        higherCount();
        this.obersteKarte = obersteKarte;
        obersteKarteBeobachten.clear();
        obersteKarteBeobachten.add(obersteKarte);
        //obersteKarteView.
    }
}
