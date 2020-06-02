package Model;

public enum CodeerEnum {
    CAESAR("Caesar", "Model.CaesarStrategy"),
    SPIEGELING("Spiegeling", "Model.SpiegelingStrategy"),
    CIPHER("Cipher", "Model.CipherStrategy");

    private String omschrijving;
    private  String klasseNaam;

    CodeerEnum(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getKlasseNaam() {
        return klasseNaam;
    }
}
