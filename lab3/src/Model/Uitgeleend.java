package Model;

public class Uitgeleend implements MateriaalState {
    private Materiaal materiaal;

    public Uitgeleend(Materiaal materiaal){
        setMateriaal(materiaal);
    }

    @Override
    public void verwijder() {
        System.out.println("product kan niet verwijderd worden als het uitgeleend zijn");
    }

    @Override
    public void leenUit() {
        System.out.println("product is al uitgeleend");
    }

    @Override
    public void brengTerug(boolean isBeschadigd) {
        if (isBeschadigd){
            this.materiaal.setCurrentState(this.materiaal.getBeschadigd());
        }else{
            this.materiaal.setCurrentState(this.materiaal.getUitleenbaar());
        }
    }

    @Override
    public void herstel() {
        System.out.println("product kan niet hersteld worden als het is uitgeleend");
    }

    public void setMateriaal(Materiaal materiaal) {
        this.materiaal = materiaal;
    }
}
