package com.example.dw_1.pattern.observer;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Observer> observerArrayList;
   public void notifyObserver(){
       for (Observer ob: observerArrayList){ob.update();}
   }
   public void register(Observer ob){
       if(!observerArrayList.contains(ob))
           observerArrayList.add(ob);
   }
   public void unregister(Observer ob){
       observerArrayList.remove(ob);
   }
}
