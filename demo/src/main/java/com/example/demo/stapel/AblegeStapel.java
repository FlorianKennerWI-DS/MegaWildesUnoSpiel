package com.example.demo.stapel;
import com.example.demo.Karten.Karte;
public class AblegeStapel {
    private int count;
    private Karte obersteKarte;
    private String kompatibleFarbe;
    private int kompatibleZahl;

    public void higherCount() {
        this.count ++;
    }

    public void setObersteKarte(Karte obersteKarte) {
        this.obersteKarte = obersteKarte;
    }

    public void setKompatibleFarbe(String kompatibleFarbe) {
        this.kompatibleFarbe = kompatibleFarbe;
    }

    public void setKompatibleZahl(int kompatibleZahl) {
        this.kompatibleZahl = kompatibleZahl;
    }


    public void ablegen(Karte abgelegteKarte){
        higherCount();

        //TODO:
        // kompatible Farbe und Zahl hier ändern
        setObersteKarte(abgelegteKarte);
        setKompatibleZahl(abgelegteKarte.getZahl());
        setKompatibleFarbe(abgelegteKarte.getFarbe());
    }
}
