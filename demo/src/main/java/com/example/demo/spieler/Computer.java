package com.example.demo.spieler;

import com.example.demo.karten.Karte;
import com.example.demo.customExceptions.NichtAblegenException;

public class Computer extends Spieler {

    public Computer(int i) {
        super("com" + Integer.toString(i));
    }

    public Karte karteFinden(Karte obersteKarte) throws NichtAblegenException {

        boolean passendeFarbe = false;
        boolean passendeZahl = false;
        Karte passendeKarte = null ;

        //suche nach Karte derselben Farbe
        for (var entry : handkarten.get(obersteKarte.getFarbe()).entrySet()){
            if (entry.getValue().size() > 0){
                passendeFarbe = true;
                passendeKarte = entry.getValue().get(0);
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
                        }
                    }
                }
            }
        }

        if (!passendeFarbe && !passendeZahl){
            throw new NichtAblegenException();
        }
        return ablegen(passendeKarte);

        /**

        if (!nochNeuereHandkarten.get(obersteKarte.getFarbe()).containsKey(obersteKarte.getZahl())) {
            throw new Exception();
        }
        else if (nochNeuereHandkarten.get(obersteKarte.getFarbe()).get(obersteKarte.getZahl()).size() == 0) {
            throw new Exception();
        }
        return ablegen(nochNeuereHandkarten.get(obersteKarte.getFarbe()).get(obersteKarte.getZahl()).get(0));
        // alle durchgehen
        //if(AblegeStapel.getObersteKarte().getFarbe().equals(handkarten.get(0))) {
        //    ablegen(handkarten.get()); }
        // macht es hier mehr Sinn die Farbe und dann evtl Zahl der obersten Karte abzufragen oder
        // die Karte mit der kompatibleFarbe und kompatibleZahl aus AblegeStapel zu vergleichen?
    }**/
}}
    /**
    public Karte ablegen() throws Exception{
        Karte abgelegteKarte = null;
        if (handkarten.get())
    }
}
*/