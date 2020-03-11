package Model;

import java.util.ArrayList;

public class RekeningLogger implements Observer {
    private Bank bank;

    public RekeningLogger(Bank bank){
        this.bank = bank;
        this.bank.registerObserver(this,BankEnum.ADD);
        this.bank.registerObserver(this,BankEnum.DEPOSIT);
        this.bank.registerObserver(this,BankEnum.WITHDRAW);
    }

    @Override
    public void update(ArrayList<Rekening>rekeningen, BankEnum bankEnum) {
        System.out.println((bank.getRekeningen().get(bank.getRekeningen().size()-1)).getRekeningnummer() + " "
                +  bank.getRekeningen().size() + " "
                + (bank.getRekeningen().get(bank.getRekeningen().size()-1)).getSaldo() + " "
                + bankEnum.toString());
    }
}
