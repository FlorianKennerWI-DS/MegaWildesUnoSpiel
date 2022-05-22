package com.example.demo.customExceptions;

public class StapelLeerException extends Exception{

    public StapelLeerException(){
        super("Stapel leer");
    }

    public StapelLeerException(String fehler){
        super(fehler);
    }

}
