package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {

        Font.loadFont(getClass().getResource("/fonts/VarelaRound-Regular.ttf").toExternalForm(), 10);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        primaryStage.setScene(new Scene(root,700, 500));
        primaryStage.setTitle("Menetrend");
        primaryStage.show();




    }


}
