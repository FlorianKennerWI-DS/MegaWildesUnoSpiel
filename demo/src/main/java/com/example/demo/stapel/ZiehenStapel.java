package com.example.demo.stapel;

import java.util.Stack;

public class ZiehenStapel {
    private Stack<String> kartenStack = new Stack<>();
    public int laenge;

    public String nehmen(){
        return kartenStack.pop();
    }


    public void generieren(){
        kartenStack.push("test");


    }
}


