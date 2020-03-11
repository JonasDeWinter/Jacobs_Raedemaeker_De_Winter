package Model;

import java.util.ArrayList;

public class Auditor implements Observer {
    private Bank bank;

    public Auditor(Bank bank){
        this.bank = bank;
        this.bank.registerObserver(this,BankEnum.ADD);

    }



    @Override
    public void update(ArrayList<Rekening>rekeningen, BankEnum bankEnum) {
        System.out.println((bank.getRekeningen().get(bank.getRekeningen().size()-1)).toString() + " " + bankEnum.toString());
    }
}
