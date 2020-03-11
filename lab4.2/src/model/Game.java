package model;

import view.PlayerView;

import java.util.ArrayList;

public class Game implements Subject{
    private ArrayList<PlayerView> spelers;
    private ArrayList<Observer> observers;

    public Game(){

        this.spelers = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(0<= i){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers){
            o.update();
        }
    }

    public void addPlayer(PlayerView p){
        spelers.add(p);
    }


}
