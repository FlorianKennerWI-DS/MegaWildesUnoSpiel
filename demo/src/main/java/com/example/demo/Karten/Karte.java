package com.example.demo.Karten;

import java.util.Random;

public class Karte {

    static String farbe;
    static int zahl;

    public Karte (String farbe, int zahl) {
        this.farbe = farbe;
        this.zahl =  zahl;
    }

    public String toString() {
        return (farbe + " " + Integer.toString(zahl));
    }

/*public static void Stapel() {
            String[] Stapel = new String [76]; //Kartenstapel muss generiert werden

            Stapel[0] = "Rot 0";
            Stapel[1] = "Rot 1";
            Stapel[2] = "Rot 2";
            Stapel[3] = "Rot 3";
            Stapel[4] = "Rot 4";
            Stapel[5] = "Rot 5";
            Stapel[6] = "Rot 6";
            Stapel[7] = "Rot 7";
            Stapel[8] = "Rot 8";
            Stapel[9] = "Rot 9";
            Stapel[10] = "Rot 1";
            Stapel[11] = "Rot 2";
            Stapel[12] = "Rot 3";
            Stapel[13] = "Rot 4";
            Stapel[14] = "Rot 5";
            Stapel[15] = "Rot 6";
            Stapel[16] = "Rot 7";
            Stapel[17] = "Rot 8";
            Stapel[18] = "Rot 9";

            Stapel[19] = "Blau 0";
            Stapel[20] = "Blau 1";
            Stapel[21] = "Blau 2";
            Stapel[22] = "Blau 3";
            Stapel[23] = "Blau 4";
            Stapel[24] = "Blau 5";
            Stapel[25] = "Blau 6";
            Stapel[26] = "Blau 7";
            Stapel[27] = "Blau 8";
            Stapel[28] = "Blau 9";
            Stapel[29] = "Blau 0";
            Stapel[30] = "Blau 1";
            Stapel[31] = "Blau 2";
            Stapel[32] = "Blau 3";
            Stapel[33] = "Blau 4";
            Stapel[34] = "Blau 5";
            Stapel[35] = "Blau 6";
            Stapel[36] = "Blau 7";
            Stapel[37] = "Blau 8";

            Stapel[38] = "Gelb 0";
            Stapel[39] = "Gelb 1";
            Stapel[40] = "Gelb 2";
            Stapel[41] = "Gelb 3";
            Stapel[42] = "Gelb 4";
            Stapel[43] = "Gelb 5";
            Stapel[44] = "Gelb 6";
            Stapel[45] = "Gelb 7";
            Stapel[46] = "Gelb 8";
            Stapel[47] = "Gelb 9";
            Stapel[48] = "Gelb 0";
            Stapel[49] = "Gelb 1";
            Stapel[50] = "Gelb 2";
            Stapel[51] = "Gelb 3";
            Stapel[52] = "Gelb 4";
            Stapel[53] = "Gelb 5";
            Stapel[54] = "Gelb 6";
            Stapel[55] = "Gelb 7";
            Stapel[56] = "Gelb 8";

            Stapel[57] = "Grün 0";
            Stapel[58] = "Grün 1";
            Stapel[59] = "Grün 2";
            Stapel[60] = "Grün 3";
            Stapel[61] = "Grün 4";
            Stapel[62] = "Grün 5";
            Stapel[63] = "Grün 6";
            Stapel[64] = "Grün 7";
            Stapel[65] = "Grün 8";
            Stapel[66] = "Grün 9";
            Stapel[67] = "Grün 0";
            Stapel[68] = "Grün 1";
            Stapel[69] = "Grün 2";
            Stapel[70] = "Grün 3";
            Stapel[71] = "Grün 4";
            Stapel[72] = "Grün 5";
            Stapel[73] = "Grün 6";
            Stapel[74] = "Grün 7";
            Stapel[75] = "Grün 8";

            int i = 0;

            for(i=<7; i++){

                String randomKarte;
                Random random =new Random();
                randomKarte = Stapel[random.nextInt(76)-1]; //random Karte wird generiert
                System.out.println(randomKarte);

            }


        }*/

    }

