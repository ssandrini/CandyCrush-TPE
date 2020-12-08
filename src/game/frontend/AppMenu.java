package game.frontend;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class AppMenu extends MenuBar {

    public AppMenu(Stage stage, Scene scene) {
        Menu file = new Menu("File");
        MenuItem goBack = new MenuItem(" Go back");
        goBack.setOnAction(event -> {
            stage.setScene(scene);
            stage.setTitle("Candy Crush");
        });
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setHeaderText("Quit application");
            alert.setContentText("Are you sure do you want to exit app?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });
        file.getItems().addAll(goBack, exitMenuItem);
        Menu help = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Candy TPE");
            alert.setContentText("""
                    OOP course 2020.

                    Version History:
                    Original Implementation: Laura Zabaleta (OOP 2013)
                    Further Updates: Santiago Sandrini and Sol Konfederak (OOP 2020).

                    for more information contact us on itba.edu.ar""");
            alert.showAndWait();
        });
        help.getItems().add(aboutMenuItem);
        getMenus().addAll(file, help);
    }

}
