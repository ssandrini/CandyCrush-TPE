package game.frontend;

import game.backend.CandyGame;
import game.backend.GameListener;
import game.backend.cell.Cell;
import game.backend.element.Element;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;

public class CandyFrame extends VBox {

	private static final int CELL_SIZE = 65;

	private final BoardPanel boardPanel;
	private final ScorePanel scorePanel;
	private final ImageManager images;
	private Point2D lastPoint;
	private final CandyGame game;

	public CandyFrame(CandyGame game, Stage primaryStage, Scene home) {
		this.game = game;
		getChildren().add(new AppMenu(primaryStage, home));
		images = new ImageManager();
		boardPanel = new BoardPanel(game.getSize(), game.getSize(), CELL_SIZE);
		getChildren().add(boardPanel);
		scorePanel = new ScorePanel();
		getChildren().add(scorePanel);
		game.initGame();
		GameListener listener;
		scorePanel.updateScore(game().getScores());
		game.addGameListener(listener = new GameListener() {
			@Override
			public void gridUpdated() {
				Timeline timeLine = new Timeline();
				Duration frameGap = Duration.millis(100);
				Duration frameTime = Duration.ZERO;
				for (int i = game().getSize() - 1; i >= 0; i--) {
					for (int j = game().getSize() - 1; j >= 0; j--) {
						int finalI = i;
						int finalJ = j;
						Cell cell = CandyFrame.this.game.get(i, j);
						Element element = cell.getContent();
						Image image = images.getImage(element);
						timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, null,null)));
						timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, image,cell.getColor())));
					}
					frameTime = frameTime.add(frameGap);
				}
				timeLine.play();
			}
			@Override
			public void cellExplosion(Element e) {
				//
			}
		});

		listener.gridUpdated();

		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (lastPoint == null) {
				lastPoint = translateCoords(event.getX(), event.getY());
				System.out.println("Get first = " +  lastPoint);
			} else {
				Point2D newPoint = translateCoords(event.getX(), event.getY());
				if (newPoint != null) {
					System.out.println("Get second = " +  newPoint);
					game().tryMove((int)lastPoint.getX(), (int)lastPoint.getY(), (int)newPoint.getX(), (int)newPoint.getY());
					String[] messages = game().getScores();
					if (game().isFinished()) {
						if (game().playerWon()) {
							messages[ScorePanel.SCORE_INDEX] = messages[ScorePanel.SCORE_INDEX] + "Player Won!";
						} else {
							messages[ScorePanel.SCORE_INDEX] = messages[ScorePanel.SCORE_INDEX] + " Loser !";
						}
						scorePanel.updateScore(messages);
						Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("Candy Crush");
						alert.setHeaderText("The game has finished");
						alert.setContentText("Would you like to go back to Home Screen?");
						Optional<ButtonType> result = alert.showAndWait();
						if(result.isPresent()) {
							if (result.get() == ButtonType.OK) {
								primaryStage.setScene(home);
								primaryStage.setTitle("Candy Crush");
							}
							else{
								Platform.exit();
							}
						}
					}
					scorePanel.updateScore(messages);
					lastPoint = null;
				}
			}
		});

	}

	private CandyGame game() {
		return game;
	}

	private Point2D translateCoords(double x, double y) {
		double i = x / CELL_SIZE;
		double j = y / CELL_SIZE;
		return (i >= 0 && i < game.getSize() && j >= 0 && j < game.getSize()) ? new Point2D(j, i) : null;
	}

}
