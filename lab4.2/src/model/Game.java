package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.PlayerView;

import java.util.ArrayList;
import java.util.Random;

public class Game implements Subject{
    private ArrayList<PlayerView> spelers;
    private ArrayList<Observer> observers;
    private PlayerView currentplayerview;

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
    public void notifyObservers(PlayerView p) {
        for(Observer o: observers){
            o.update(p);
        }
    }

    public void addPlayer(PlayerView p){
        currentplayerview = p;
        p.getPlayButton().setOnAction(new ThrowDicesHandler());

        spelers.add(p);
    }

    class ThrowDicesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int randomdice1 = new Random().nextInt(6);
            int randomdice2 = new Random().nextInt(6);
            int totaal = randomdice1 + randomdice2;
            System.out.println(randomdice1+ " " + randomdice2 + " " + totaal);
            notifyObservers(currentplayerview);
        }
    }


}
