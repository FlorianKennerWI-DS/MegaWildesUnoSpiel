package com.example.demo.StapelLeer;

public class Stapelleer extends Exception{

    public Stapelleer (){
        super("Stapel leer");
    }

    public Stapelleer(String fehler){
        super(fehler);
    }

}
