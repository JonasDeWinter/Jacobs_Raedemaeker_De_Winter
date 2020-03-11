package model;

import javafx.scene.control.Label;
import view.PlayerView;

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
    public void update(ArrayList<PlayerView> spelers, PlayerView playerView, int getal1, int getal2) {
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
                p.setMessageLabel(playerView.getSpelerNummer() + " heeft " + getal1 + " " + getal2);
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
