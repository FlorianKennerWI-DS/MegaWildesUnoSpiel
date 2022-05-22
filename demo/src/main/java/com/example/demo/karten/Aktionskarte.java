package com.example.demo.karten;

public class Aktionskarte extends Karte  {
   private int id;

   public Aktionskarte(String farbe, int zahl, Action action) {
      super(farbe, zahl);
      this.action = action;
   }

   enum Action{  // Action als vordefinierte Variable
      zweiziehen, aussetzen, richtungswechsel, farbewünschen, vierziehen;     // besondere Aktionsattribute

      public static final  Action[] actions= Action.values();
      public Action getAction (int id)
      {
         return Action.actions[id];
      }
   }

   public Action action;
    public Aktionskarte (Action action){
       super();
       this.action = action;
    }


}
