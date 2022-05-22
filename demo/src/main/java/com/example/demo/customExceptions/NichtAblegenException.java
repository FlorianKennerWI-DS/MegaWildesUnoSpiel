package com.example.demo.customExceptions;

public class NichtAblegenException extends RuntimeException{

    public NichtAblegenException() {
        super("Hilfe ich kann ablegen");
    }

    public NichtAblegenException(String fehler){
        super(fehler);
    }

}
