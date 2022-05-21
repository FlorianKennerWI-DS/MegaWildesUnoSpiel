package com.example.demo.stapel;

import com.example.demo.Karten.Karte;

import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
      ZiehenStapel.generieren();
      ZiehenStapel.kartenStack.forEach(System.out::println);

    }
}
