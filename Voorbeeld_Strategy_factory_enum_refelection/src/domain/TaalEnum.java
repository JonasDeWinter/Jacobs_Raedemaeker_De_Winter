package domain;

public enum TaalEnum {
	NEDERLANDS ("Nederlands", "domain.TaalNed"),
	FRANS ("Frans", "domain.TaalFr"),
	ENGELS ("Engels", "domain.TaalEng");
		

	private final String omschrijving;
	private final String klasseNaam; 
		
	TaalEnum(String omschrijving, String klasseNaam) {
	    this.omschrijving = omschrijving;
	    this.klasseNaam = klasseNaam;
	}
		
	public String getOmschrijving() { return omschrijving; }
	public String getKlasseNaam() { return klasseNaam; }

}
