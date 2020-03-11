package model;

import javafx.scene.control.Label;
import view.PlayerView;

import java.util.ArrayList;

public class SpelersObserver implements Observer {
    private Game game;

    public SpelersObserver(Game game){
        this.game = game;
        game.registerObserver(this);
    }

    @Override
    public void update(ArrayList<PlayerView> spelers, PlayerView playerView, int getal1, int getal2) {
        for (PlayerView p : spelers){
            if (p.equals(playerView)){
                p.setMessageLabel(getal1 + " " + getal2);
            }

        }

    }
}
