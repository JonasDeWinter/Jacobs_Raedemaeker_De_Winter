package application;

import domain.TaalContext;
import domain.TaalFactory;
import domain.TaalInterface;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SpelenMetComboBox  {
  private TaalContext taalContext;	
  private Label aanspreekLabel = new Label("");
  
  public SpelenMetComboBox(Stage stage) {
	taalContext = new TaalContext();  
    stage.setTitle("ComboBoxSample met strategy, enum en reflection");
    GridPane grid = new GridPane();
    grid.setVgap(4);
    grid.setHgap(10);
    grid.setPadding(new Insets(5, 5, 5, 5));    
    
    ComboBox <String>taalComboBox = new ComboBox<String>();
    ObservableList <String> talen = FXCollections.observableList(taalContext.getTaalLijst());
    taalComboBox.setItems(talen);
    //taalComboBox.setPromptText("Email address");
    taalComboBox.setEditable(true);        
    taalComboBox.valueProperty().addListener(new ClickComboBoxLineHandler());
    grid.add(taalComboBox, 0, 0);
    grid.add(aanspreekLabel,1,0);
    Scene scene = new Scene(grid, 450, 250);
    stage.setScene(scene);
    stage.show();
  }
  
  class ClickComboBoxLineHandler implements ChangeListener<String>{
	  @Override 
	  public void changed(ObservableValue ov, String t, String t1) {
		  TaalInterface taalInterface = TaalFactory.createTaal(t1);
		  taalContext.setTaalInterface(taalInterface);
		  aanspreekLabel.setText(taalContext.getAanspreking());
      }    
  }
}

