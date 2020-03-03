package Model;

import javax.swing.plaf.nimbus.State;

public class Materiaal {
    MateriaalState uitleenbaar;
    MateriaalState uitgeleend;
    MateriaalState verwijderd;
    MateriaalState beschadigd;
    MateriaalState currentState;
    private String naam;
    private double aanschafprijs;
    private boolean herstelbaar;

    public Materiaal(String naam, double aanschafprijs){
        uitleenbaar = new Uitleenbaar(this);
        uitgeleend = new Uitgeleend(this);
        verwijderd = new Verwijderd(this);
        beschadigd = new Beschadigd(this,true);

        currentState = this.uitleenbaar;
        setNaam(naam);
        setAanschafprijs(aanschafprijs);
    }

    public double getUitleenprijs(){
        return this.aanschafprijs / 5;
    }

    private void setAanschafprijs(double aanschafprijs) {
        this.aanschafprijs = aanschafprijs;
    }

    private void setNaam(String naam) {
        this.naam = naam;
    }

    public void setCurrentState(MateriaalState currentState) {
        this.currentState = currentState;
    }

    public MateriaalState getUitleenbaar() {
        return uitleenbaar;
    }

    public MateriaalState getUitgeleend() {
        return uitgeleend;
    }

    public MateriaalState getVerwijderd() {
        return verwijderd;
    }

    public MateriaalState getBeschadigd() {
        return beschadigd;
    }

    public MateriaalState getCurrentState() {
        return currentState;
    }

    public String getNaam() {
        return naam;
    }

    public double getAanschafprijs() {
        return aanschafprijs;
    }

    public void verwijder(){
        currentState.verwijder();
    }

    public void leenUit(){
        currentState.leenUit();
    }

    public void brengTerug(boolean isBeschadigd){
        currentState.brengTerug(isBeschadigd);
    }

    public void herstel(){
        currentState.herstel();
    }

    public boolean isHerstelbaar() {
        return herstelbaar;
    }

    public void setHerstelbaar(boolean herstelbaar) {
        this.herstelbaar = herstelbaar;
    }
}
