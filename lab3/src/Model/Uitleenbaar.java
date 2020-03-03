package Model;

import java.sql.SQLOutput;

public class Uitleenbaar implements MateriaalState {
    private Materiaal materiaal;

    public Uitleenbaar(Materiaal materiaal){
        setMateriaal(materiaal);
    }

    private void setMateriaal(Materiaal materiaal) {
        this.materiaal = materiaal;
    }

    @Override
    public void verwijder() {
        materiaal.setCurrentState(materiaal.getVerwijderd());
    }

    @Override
    public void leenUit() {
        materiaal.setCurrentState(materiaal.getUitgeleend());
    }

    @Override
    public void brengTerug(boolean isBeschadigd) {
        System.out.println("product kan niet worden teruggebrengen");
    }

    @Override
    public void herstel() {
        System.out.println("product is niet beschadigtd");
    }
}
