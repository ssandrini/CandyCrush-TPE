package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ScorePanel extends BorderPane {

	private Label[] labels = new Label[2];

	public ScorePanel() {

		setStyle("-fx-background-color: #5490ff");
		labels[0] = new Label("0");
		labels[0].setAlignment(Pos.CENTER);
		labels[0].setStyle("-fx-font-size: 24");
		setLeft(labels[0]);

		labels[1] = new Label("");
		labels[1].setAlignment(Pos.CENTER);
		labels[1].setStyle("-fx-font-size: 24");
		setRight(labels[1]);

	}
	
	public void updateScore(String[] scores) {
		for(int i = 0; i < scores.length; i++) {
			labels[i].setText(scores[i]);
		}
	}

}