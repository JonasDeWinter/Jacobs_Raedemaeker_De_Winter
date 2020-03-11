package model;

import javafx.scene.control.Label;
import view.PlayerView;

public class SpelersObserver implements Observer {
    private Game game;

    public SpelersObserver(Game game){
        this.game = game;
        game.registerObserver(this);
    }

    @Override
    public void update(PlayerView playerView) {
        playerView.setMessageLabel(new Label("test"));
    }
}
