package com.example.demo.stapel;
import com.example.demo.Karten.Karte;
public class AblegeStapel {
    private int count;
    private Karte obersteKarte;
    private String kompatibleFarbe;

    public Karte getObersteKarte() {
        return obersteKarte;
    }
    private int kompatibleZahl;

    public void higherCount() {
        this.count ++;
    }

    public void setObersteKarte(Karte obersteKarte) {
        higherCount();
        this.obersteKarte = obersteKarte;
    }
}
