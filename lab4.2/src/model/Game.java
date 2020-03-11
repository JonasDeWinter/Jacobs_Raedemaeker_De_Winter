package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.PlayerView;

import java.util.ArrayList;
import java.util.Random;

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
    public void notifyObservers(ArrayList<PlayerView> spelers, PlayerView p, int getal1, int getal2) {
        for(Observer o: observers){
            o.update(spelers, p, getal1, getal2);
        }
    }


    public void addPlayer(PlayerView p){
        spelers.add(p);
    }

    public ArrayList<PlayerView> getSpelers() {
        return spelers;
    }
}
