package com.example.demo.customExceptions;

// beide vom Kim

public class NichtAblegenException extends RuntimeException{

    public NichtAblegenException() {
        super("Hilfe ich kann ablegen");
    }

    public NichtAblegenException(String fehler){
        super(fehler);
    }

}
