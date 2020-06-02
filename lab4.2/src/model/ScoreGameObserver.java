package model;

import view.PlayerView;
import view.ScoreView;

import java.util.ArrayList;

public class ScoreGameObserver implements Observer {

    private Game game;

    public ScoreGameObserver(Game game){
        this.game = game;
        game.registerObserver(this);
    }

    @Override
    public void update(ArrayList<PlayerView> spelers, PlayerView playerView, ScoreView view, int getal1, int getal2, int totaal) {
        view.setScoreLabel("sp" + playerView.getSpelerNummer() + ":" + totaal, playerView.getSpelerNummer());
    }
}
