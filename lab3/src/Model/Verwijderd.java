package Model;

public class Verwijderd implements MateriaalState {
    private Materiaal materiaal;

    public Verwijderd(Materiaal materiaal){
        setMateriaal(materiaal);
    }

    @Override
    public void verwijder() {
        System.out.println("al verwijderd");
    }

    @Override
    public void leenUit() {
        System.out.println("kan niet worden uitgeleend");
    }

    @Override
    public void brengTerug(boolean isBeschadigd) {
        System.out.println("kan niet worden teruggebracht");
    }

    @Override
    public void herstel() {
        System.out.println("geen herstel mogelijk");
    }

    public void setMateriaal(Materiaal materiaal) {
        this.materiaal = materiaal;
    }
}
