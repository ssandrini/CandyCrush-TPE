package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Home {

    private Stage stage;

    public Home(Stage stage) {
        this.stage = stage;
    }
    public void level1(ActionEvent event) {
        choose(Level1.class);
    }
    public void level2(ActionEvent event) {
        choose(Level2.class);
    }
    public void level3(ActionEvent event) {
        //choose(Level3.class);
    }

    public void choose(Class<?> clazz) {
        CandyGame game = new CandyGame(clazz);
        CandyFrame frame = new CandyFrame(game);
        Scene scene = new Scene(frame);
        stage.setScene(scene);
        stage.setResizable(false);
    }
}
