package com.example.demo.stapel;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Stack;

public class ZiehenStapel {
    private Stack<String> kartenStack = new Stack<>();
    public int laenge;

    public String nehmen(){
        return kartenStack.pop();
    }


    public static Stack<String> generieren(){
        ArrayList<String> alleKarten = new ArrayList<String>(){};
        alleKarten.add("a");
        alleKarten.add("b");

        int kartenAnzahl = alleKarten.size();
        Stack<String> gemischterStapel = new Stack<>();

        for (int i = 0; i < kartenAnzahl; i ++){
            int index = ThreadLocalRandom.current().nextInt(0, alleKarten.size()) ;
            gemischterStapel.push(alleKarten.get(index));
            alleKarten.remove(index);
        }
        return gemischterStapel;





    }
}


