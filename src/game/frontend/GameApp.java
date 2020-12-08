package game.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		// cargamos el archivo FXML y lo guardamos en root
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Home.fxml"));
		Parent root = loader.load();
		((Home) loader.getController()).setPrimaryStage(primaryStage);
		// seteamos la escena de Home
		Scene homeScene = new Scene(root, 600, 400);
		((Home) loader.getController()).setHomeScene(homeScene);
		primaryStage.setResizable(false);
		primaryStage.setScene(homeScene);
		primaryStage.show();
	}

}
