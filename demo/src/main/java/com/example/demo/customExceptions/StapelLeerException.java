package com.example.demo.customExceptions;

public class StapelLeerException extends Exception{
    //Ziehstapel ist leer

    public StapelLeerException(){
        super("Stapel leer");
    }

    public StapelLeerException(String fehler){
        super(fehler);
    }

}
