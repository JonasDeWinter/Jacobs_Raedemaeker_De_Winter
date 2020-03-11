package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;

import java.util.Random;

public class PlayerView {
	private Stage stage = new Stage();
	private Scene playerScene;
	private Label diceLabel; 
	private Button playButton; 
	private Label messageLabel;
	private PlayerView playerView;
	
	private int spelerNummer;
	private Game game;
	
	public PlayerView(int spelerNummer, Game game){
		playerView = this;
		this.game = game;
		this.spelerNummer = spelerNummer;
		diceLabel = new Label("beurt 1: ");
		playButton = new Button("Werp dobbelstenen");
		playButton.setOnAction(new ThrowDicesHandler());
		playButton.setDisable(true);
		messageLabel = new Label("Spel nog niet gestart");
		layoutComponents();
		stage.setScene(playerScene);
		stage.setTitle("Speler "+ spelerNummer);
		stage.setResizable(false);		
		stage.setX(100+(spelerNummer-1) * 350);
		stage.setY(200);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox(10);
		playerScene = new Scene(root,250,100);
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);			
	}
	
	public void isAanBeurt(boolean aanBeurt){
		playButton.setDisable(!aanBeurt);		
	}
	
	class ThrowDicesHandler implements EventHandler<ActionEvent> {
		@Override
        public void handle(ActionEvent event) {
			int randomdice1 = new Random().nextInt(5) + 1;
			int randomdice2 = new Random().nextInt(5) + 1;
			int totaal = randomdice1 + randomdice2;

			game.notifyObservers(game.getSpelers(), playerView, randomdice1, randomdice2);
        }
    }

	public void setMessageLabel(String tekst) {
		playerView.messageLabel.setText(tekst);
	}

	public int getSpelerNummer() {
		return spelerNummer;
	}
}
