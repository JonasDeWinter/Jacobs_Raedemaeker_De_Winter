package model;

public abstract class WoordDecorator{
    private String zin;

    public WoordDecorator(String zin) {
        this.zin = zin;

    }

    public abstract String getZin();
}
