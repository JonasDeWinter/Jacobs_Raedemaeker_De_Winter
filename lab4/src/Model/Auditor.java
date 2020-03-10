package Model;

import java.util.ArrayList;

public class Auditor implements Observer {
    private Bank bank;

    public Auditor(Bank bank){
        this.bank = bank;
        this.bank.registerObserver(this);
    }



    @Override
    public void update(ArrayList<Rekening>rekeningen) {
        System.out.println((bank.getRekeningen().get(bank.getRekeningen().size()-1)).toString());
    }
}
