package com.example.demo.karten;


// von Kim
public class Aktionskarte extends Karte  {
   private int id;

   public Aktionskarte(String farbe, int zahl, Action action) {
      super(farbe, zahl);
      this.action = action;
   }

   enum Action{  // Action als vordefinierte Variable
      zweiziehen, aussetzen, richtungswechsel, farbewünschen, vierziehen;

      public static final  Action[] actions= Action.values();
      public Action getAction (int id)
      {
         return Action.actions[id];
      }
   }

   public Action action;
}
