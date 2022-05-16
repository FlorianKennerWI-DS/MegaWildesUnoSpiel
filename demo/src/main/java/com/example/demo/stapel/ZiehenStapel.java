package com.example.demo.stapel;

import java.util.ArrayList;
import java.util.Stack;

public class ZiehenStapel {
    private Stack<String> kartenStack = new Stack<>();
    public int laenge;

    public String nehmen(){
        return kartenStack.pop();
    }


    public void generieren(){
        ArrayList<String> blaueKarten = new ArrayList<String>();
        ArrayList<String> grueneKarten = new ArrayList<String>();
        ArrayList<String> gelbeKarten = new ArrayList<String>();
        ArrayList<String> roteKarten = new ArrayList<String>();
        ArrayList<String> alleKarten = new ArrayList<>(){
        };




    }
}


