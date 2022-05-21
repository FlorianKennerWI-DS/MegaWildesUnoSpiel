package com.example.demo.spieler;
import com.example.demo.Karten.Karte;
import com.example.demo.stapel.AblegeStapel;

public class Computer extends Spieler {


    public Computer(int i) {
        super("com" + Integer.toString(i));
    }

    public Karte karteFinden(Karte obersteKarte) throws Exception {
        if (!nochNeuereHandkarten.get(obersteKarte.getFarbe()).containsKey(obersteKarte.getZahl())) {
            throw new Exception();
        }
        if (nochNeuereHandkarten.get(obersteKarte.getZahl()).containsKey(obersteKarte.getFarbe()) && nochNeuereHandkarten.get(obersteKarte.getFarbe()).get(obersteKarte.getZahl()).size() == 0) {
            throw new Exception();
        }
        return ablegen(nochNeuereHandkarten.get(obersteKarte.getFarbe()).get(obersteKarte.getZahl()).get(0));
        // alle durchgehen
        //if(AblegeStapel.getObersteKarte().getFarbe().equals(handkarten.get(0))) {
        //    ablegen(handkarten.get()); }
        // macht es hier mehr Sinn die Farbe und dann evtl Zahl der obersten Karte abzufragen oder
        // die Karte mit der kompatibleFarbe und kompatibleZahl aus AblegeStapel zu vergleichen?
    }
}
    /**
    public Karte ablegen() throws Exception{
        Karte abgelegteKarte = null;
        if (handkarten.get())
    }
}
*/