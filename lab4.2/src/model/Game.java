package model;

import view.PlayerView;

import java.util.ArrayList;

public class Game implements Subject{
    private ArrayList<PlayerView> spelers;

    public Game(){
        this.spelers = new ArrayList<>();
    }

    @Override
    public void registerObserver() {

    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void notifyObservers() {

    }
}
