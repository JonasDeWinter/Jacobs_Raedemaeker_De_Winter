package model;

import view.PlayerView;
import view.ScoreView;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<PlayerView> spelers, PlayerView playerView, ScoreView view, int getal1, int getal2, int totaal);
}
