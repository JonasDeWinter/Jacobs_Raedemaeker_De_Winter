package Model;

import java.time.LocalDate;

public class Rekening {
    private double saldo;
    private String rekeningnummer;
    private LocalDate datum;

    public Rekening(String rekeningnummer, double saldo, LocalDate datum){
        this.saldo = saldo;
        this.rekeningnummer = rekeningnummer;
        this.datum = datum;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String toString(){
        return this.datum + " " + this.rekeningnummer + " " + this.saldo;
    }
}
