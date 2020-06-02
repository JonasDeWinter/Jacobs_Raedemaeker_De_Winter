package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScoreView {
	private Stage stage = new Stage();
	private Scene scoreScene;
	private Label scoreLabel;
	private int teller = 1;
		
	public ScoreView(){
		scoreLabel = new Label();
		scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");
		layoutComponents();
		stage.setScene(scoreScene);
		stage.setTitle("Overzicht scores");
		stage.setResizable(false);		
		stage.setX(100);
		stage.setY(400);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox();
		scoreScene = new Scene(root,400,200);
		root.getChildren().add(scoreLabel);
	}
	
	private void voegScoreLijnToe(String scoreLijn){
		scoreLabel.setText(scoreLabel.getText()+"\n"+scoreLijn);
	}

	private void voegScoreToe(String score){
		scoreLabel.setText(scoreLabel.getText()+" "+score);
	}

	public void setScoreLabel(String test, int nummer) {
		if (nummer == 1){
			voegScoreLijnToe("Beurt " + teller + ":");
			voegScoreToe(test);
			teller ++;
		}else{
			voegScoreToe(test);
		}

	}
}
