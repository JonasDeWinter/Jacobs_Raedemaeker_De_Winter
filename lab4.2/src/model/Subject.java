package model;

import view.PlayerView;

import java.util.ArrayList;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(ArrayList<PlayerView> spelers, PlayerView p, int i1, int i2);
}
