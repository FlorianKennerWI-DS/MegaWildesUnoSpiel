package com.example.demo.stapel;

import com.example.demo.karten.Karte;

public class AblegeStapel {
    private int count;
    private Karte obersteKarte;

    public Karte getObersteKarte() {
        return obersteKarte;
    }

    private void higherCount() {
        this.count ++;
    }

    public void setObersteKarte(Karte obersteKarte) {
        higherCount();
        this.obersteKarte = obersteKarte;
    }
}
