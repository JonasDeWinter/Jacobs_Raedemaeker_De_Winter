package Model;

public interface MateriaalState {
    /*kan ook met abstracte class*/
    public void verwijder();
    public void leenUit();
    public void brengTerug(boolean isBeschadigd);
    public void herstel();
}
