package com.example.dw_1.pattern.observer;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Observer> observerArrayList;
    protected Subject(){
        observerArrayList = new ArrayList<>();
    }
    public void attach (Observer newObserver){
        observerArrayList.add(newObserver);
    }
    public void detach (Observer removeObs){
        observerArrayList.remove(removeObs);
    }
    protected void notifyObs(){
        for (Observer observer : observerArrayList){
            observer.update();
        }
    }
}
