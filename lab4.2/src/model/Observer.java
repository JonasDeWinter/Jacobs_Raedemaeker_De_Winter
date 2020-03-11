package model;

import view.PlayerView;

import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<PlayerView> spelers, PlayerView playerView, int getal1, int getal2);
}
