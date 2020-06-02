package sample;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Game;
import model.ScoreGameObserver;
import model.SpelersObserver;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ScoreView view = new ScoreView();
        Game game = new Game();
        game.setView(view);
        PlayerView pv3 = new PlayerView(3,game);
        PlayerView pv2 = new PlayerView(2,game);
        PlayerView pv1 = new PlayerView(1,game);

        SpelersObserver sp1 = new SpelersObserver(game);
        ScoreGameObserver score = new ScoreGameObserver(game);

        game.addPlayer(pv2);
        game.addPlayer(pv3);
        game.addPlayer(pv1);

        pv1.isAanBeurt(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
