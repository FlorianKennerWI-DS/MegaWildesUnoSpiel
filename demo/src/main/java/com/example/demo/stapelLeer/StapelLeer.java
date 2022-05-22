package com.example.demo.stapelLeer;

public class StapelLeer extends Exception{

    public StapelLeer(){
        super("Stapel leer");
    }

    public StapelLeer(String fehler){
        super(fehler);
    }

}
