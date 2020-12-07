package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ScorePanel extends BorderPane {

	public static final int MAX_LABELS = 3;
	public static final int SCORE_INDEX = 0;
	public static final int MOVES_INDEX = 1;
	public static final int REMAINING_INDEX = 2;

	private final Label[] labels = new Label[MAX_LABELS];

	public ScorePanel() {

		setStyle("-fx-background-color: #5490ff");
		labels[SCORE_INDEX] = new Label("0");
		labels[SCORE_INDEX].setAlignment(Pos.CENTER);
		labels[SCORE_INDEX].setStyle("-fx-font-size: 24");
		setLeft(labels[SCORE_INDEX]);

		labels[MOVES_INDEX] = new Label("");
		labels[MOVES_INDEX].setAlignment(Pos.CENTER);
		labels[MOVES_INDEX].setStyle("-fx-font-size: 24");
		setCenter(labels[MOVES_INDEX]);

		labels[REMAINING_INDEX] = new Label("");
		labels[REMAINING_INDEX].setAlignment(Pos.CENTER);
		labels[REMAINING_INDEX].setStyle("-fx-font-size: 24");
		setRight(labels[REMAINING_INDEX]);

	}
	
	public void updateScore(String[] scores) {
		for(int i = 0; i < scores.length; i++) {
			labels[i].setText(scores[i]);
		}
	}

}