package com.example.demo.nichtablegen;

public class NichtAblegen extends RuntimeException{

    public NichtAblegen() {
        super("Hilfe ich kann ablegen");
    }

    public NichtAblegen(String fehler){
        super(fehler);
    }

}
