package model;

import view.PlayerView;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(PlayerView p);
}
