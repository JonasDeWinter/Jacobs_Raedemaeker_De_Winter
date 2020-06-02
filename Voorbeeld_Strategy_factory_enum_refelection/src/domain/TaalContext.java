package domain;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

public class TaalContext {
	private TaalInterface taalInterface;
	
	public TaalContext(){
		
	}
	
	public void setTaalInterface(TaalInterface taalInterface){
		this.taalInterface = taalInterface;
	}
	
	public String getAanspreking(){
		return taalInterface.getAanspreking();
	}
	
	public List<String> getTaalLijst(){
		List <String> taalLijst = new ArrayList<String>();
		for (TaalEnum taal:TaalEnum.values()){
			taalLijst.add(taal.toString());
		}
		return taalLijst;
	}
	
}
