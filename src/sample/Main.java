package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {
    private VBox vbox;
    Button button=new Button("start");
    private ArrayList<String> bus = new ArrayList<>(10);

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {

        Font.loadFont(getClass().getResource("/fonts/VarelaRound-Regular.ttf").toExternalForm(), 10);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        primaryStage.setScene(new Scene(root,1000, 1000));
        //primaryStage.setResizable(false);
        primaryStage.setTitle("Schedule App");
        primaryStage.show();




    }


}
