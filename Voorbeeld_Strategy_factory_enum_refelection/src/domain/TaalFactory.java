package domain;

public class TaalFactory {
	public static TaalInterface createTaal(String taalCode){
		TaalEnum taalEnum = TaalEnum.valueOf(taalCode);
		String klasseNaam = taalEnum.getKlasseNaam();
		TaalInterface taalInterface = null;
		try{
			Class dbClass = Class.forName(klasseNaam);
			Object dbObject = dbClass.newInstance();
			taalInterface = (TaalInterface) dbObject;
		}
		catch (Exception e){}
		return taalInterface;
	}
}
