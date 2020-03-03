package Model;

public class Beschadigd implements MateriaalState {
    private Materiaal materiaal;
    private boolean isHerstelbaar;

    public Beschadigd(Materiaal materiaal, boolean isHerstalbaar){
        setMateriaal(materiaal);
        setHerstelbaar(isHerstalbaar);
    }

    private void setMateriaal(Materiaal materiaal) {
        this.materiaal = materiaal;
    }

    @Override
    public void verwijder() {
        if (this.materiaal.isHerstelbaar()){
            this.materiaal.herstel();
        }else{
            this.materiaal.setCurrentState(materiaal.getVerwijderd());
        }
    }

    @Override
    public void leenUit() {
        System.out.println("product kan niet worden uitgeleend als het beschadigd is");
    }

    @Override
    public void brengTerug(boolean isBeschadigd) {
        System.out.println("product kan niet worden teruggebracht als het al beschadigd is");
    }

    @Override
    public void herstel() {
        if (isHerstelbaar){
            this.materiaal.setCurrentState(this.materiaal.getUitleenbaar());
        }else{
            this.materiaal.setCurrentState(this.materiaal.getVerwijderd());
        }
    }

    public void setHerstelbaar(boolean herstelbaar) {
        isHerstelbaar = herstelbaar;
    }
}
