package Model;

import java.util.ArrayList;

public class RekeningLogger implements Observer {
    private Bank bank;

    public RekeningLogger(Bank bank){
        this.bank = bank;
        this.bank.registerObserver(this);
    }

    @Override
    public void update(ArrayList<Rekening>rekeningen) {
        System.out.println((bank.getRekeningen().get(bank.getRekeningen().size()-1)).getRekeningnummer() + " " +  bank.getRekeningen().size());
    }
}
