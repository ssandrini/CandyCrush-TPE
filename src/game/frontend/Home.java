package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level3;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Home {

    private Stage stage;
    private Scene homeScene;

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void setHomeScene(Scene scene){
        this.homeScene = scene;
    }

    public void level1(ActionEvent event) { choose(Level1.class); }
    public void level2(ActionEvent event) { choose(Level2.class); }
    public void level3(ActionEvent event) {
        choose(Level3.class);
    }

    public void choose(Class<?> level) {
        CandyGame game = new CandyGame(level);
        CandyFrame frame = new CandyFrame(game, stage, homeScene);
        Scene scene = new Scene(frame);
        stage.setScene(scene);
        stage.setResizable(false);
    }

}
