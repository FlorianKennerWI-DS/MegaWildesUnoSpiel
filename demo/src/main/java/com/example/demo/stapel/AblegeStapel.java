package com.example.demo.stapel;

public class AblegeStapel {
    private int count;
    private String obersteKarte;
    private String kompatibleFarbe;
    private int kompatibleZahl;

    public void higherCount() {
        this.count ++;
    }

    public void setObersteKarte(String obersteKarte) {
        this.obersteKarte = obersteKarte;
    }

    public void setKompatibleFarbe(String kompatibleFarbe) {
        this.kompatibleFarbe = kompatibleFarbe;
    }

    public void setKompatibleZahl(int kompatibleZahl) {
        this.kompatibleZahl = kompatibleZahl;
    }


    public void ablegen(){
        higherCount();

        //TODO:
        // kompatible Farbe und Zahl hier ändern
        setKompatibleFarbe("Gruen");
        setKompatibleZahl(1);
    }
}
