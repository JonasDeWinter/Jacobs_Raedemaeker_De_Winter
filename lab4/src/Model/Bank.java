package Model;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

public class Bank implements Subject {
    private String naam;
    private ArrayList<Rekening> rekeningen;
    private ArrayList<Observer> observers;

    public Bank(String naam){
        this.naam = naam;
        this.rekeningen = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update(rekeningen);
        }
    }

    public void addRekening(Rekening rekening){
        this.rekeningen.add(rekening);
        notifyObservers();
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Rekening> getRekeningen() {
        return rekeningen;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }
}
