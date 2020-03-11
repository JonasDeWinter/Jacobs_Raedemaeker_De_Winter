package Model;

public interface Subject {
    public void registerObserver(Observer observer,BankEnum bankEnum);
    public void removeObserver(Observer observer);
    public void notifyObservers(BankEnum bankEnum);
}
