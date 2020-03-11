package model;

import view.PlayerView;

public interface Observer {
    public void update(PlayerView playerView);
}
