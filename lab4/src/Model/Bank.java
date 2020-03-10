package Model;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank implements Subject {
    private String naam;
    private ArrayList<Rekening> rekeningen;
    private HashMap<BankEnum, List<Observer>> observers;

    public Bank(String naam){
        this.naam = naam;
        this.rekeningen = new ArrayList<>();
        this.observers = new HashMap<>();
        this.observers.put(BankEnum.ADD,new ArrayList<>());
        this.observers.put(BankEnum.WITHDRAW,new ArrayList<>());
        this.observers.put(BankEnum.DEPOSIT,new ArrayList<>());
    }

    @Override
    public void registerObserver(Observer observer,BankEnum bankEnum) {
        observers.get(bankEnum).add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        for (List<Observer> o : observers.values()) {
            for (int i = 0; i != o.size(); i++) {
                if (o.get(i).equals(observer)) {
                    o.remove(i);
                }
            }
        }
    }

    @Override
    public void notifyObservers(BankEnum bankEnum) {
        for (Observer o : observers.get(bankEnum)){
            o.update(rekeningen, bankEnum);
        }
    }

    public void addRekening(Rekening rekening){
        this.rekeningen.add(rekening);
        notifyObservers(BankEnum.ADD);
    }

    public void storten(Rekening rekening, double bedrag){
        rekening.stortBedrag(bedrag);
        notifyObservers(BankEnum.DEPOSIT);
    }

    public void opnemen(Rekening rekening, double bedrag){
        rekening.neemOp(bedrag);
        notifyObservers(BankEnum.WITHDRAW);
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Rekening> getRekeningen() {
        return rekeningen;
    }

    public HashMap<BankEnum, List<Observer>> getObservers() {
        return observers;
    }
}
