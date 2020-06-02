package model;

import javafx.scene.control.Label;
import view.PlayerView;
import view.ScoreView;

import java.util.ArrayList;

public class SpelersObserver implements Observer {
    private Game game;
    private int teller;
    public SpelersObserver(Game game){
        this.game = game;
        this.teller = 0;
        game.registerObserver(this);
    }

    @Override
    public void update(ArrayList<PlayerView> spelers, PlayerView playerView, ScoreView view, int getal1, int getal2, int totaal) {
        playerView.setDiceLabel("Beurt " + (teller + 1) + ": " + getal1 + " en " + getal2 + " - " + "score: " + totaal);
        if(teller != 4 ) {
            for (PlayerView p : spelers) {
                if (p.equals(playerView)) {
                    p.isAanBeurt(false);
                }
                if (p.getSpelerNummer() == playerView.getSpelerNummer() + 1) {
                    p.isAanBeurt(true);
                } else if (playerView.getSpelerNummer() == 3) {
                    if(teller != 3) {
                        if (p.getSpelerNummer() == 1) {
                            p.isAanBeurt(true);
                        }
                    }

                }
                p.setMessageLabel("Speler " + playerView.getSpelerNummer() + " werpt " + getal1 + " en " + getal2 + " - score: " +totaal);
            }
        }else{
            for (PlayerView p : spelers) {
                p.isAanBeurt(false);
            }
        }
        if (playerView.getSpelerNummer() == 3) {
            teller++;
        }
    }
}
