package game.frontend.ScorePanels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class ScorePanel2 extends ScorePanel {

    private Label remainingLabel;

    public ScorePanel2() {
        remainingLabel = new Label("0");
        remainingLabel.setAlignment(Pos.CENTER);
        remainingLabel.setStyle("-fx-font-size: 24");
        setRight(remainingLabel);
    }

    public void updateScore(String text, String remaining){
        updateScore(text);
        remainingLabel.setText(remaining);
    }

}
