package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.PlayerView;
import view.ScoreView;

import java.util.ArrayList;
import java.util.Random;

public class Game implements Subject{
    private ArrayList<PlayerView> spelers;
    private ArrayList<Observer> observers;
    private ScoreView view;

    public Game(){
        this.spelers = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void setView(ScoreView view){
        this.view = view;
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
    public void notifyObservers(ArrayList<PlayerView> spelers, PlayerView p, ScoreView view, int getal1, int getal2, int totaal) {
        for(Observer o: observers){
            o.update(spelers, p, view, getal1, getal2, totaal);
        }
    }

    public void addPlayer(PlayerView p){
        spelers.add(p);
    }

    public ArrayList<PlayerView> getSpelers() {
        return spelers;
    }

    public ScoreView getView() {
        return view;
    }
}
