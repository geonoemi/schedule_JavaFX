package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database;


import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Way {
    @FXML VBox container;
    @FXML Label title;
    @FXML ArrayList<String> wayList = new ArrayList();

    private ChoiceBox<String> wayChoice = new ChoiceBox();
    private Button clickedWay;
    private String lineNum;
    private String lineLetter;
    private Model model = new Model();

   /* private String num=Home.getClickedButtonText().substring(0,2);
    private String letter=Home.getClickedButtonText().substring(2,3);*/
    public Way(String lineNum, String lineLetter) {

        this.lineNum = lineNum;
        this.lineLetter = lineLetter;
        System.out.println(lineNum);
    }

    public void initialize() throws SQLException, IOException {
        //choicebox hozzáadása a containerhez
        this.container.getChildren().add(this.wayChoice);
        //kiszedjük a kezdő és végállomásokat stringként
        wayList = model.getWayList(lineNum, lineLetter);
        //az kezdő és végállomásokat átadjuk a choiceboxnak
        for (int i = 0; i < wayList.size(); i++) {
            this.wayChoice.getItems().addAll(wayList.get(i));
            System.out.println("stations: " + wayList.get(i));
        }
        //coiceboxnak kezdőérték
        this.wayChoice.setValue(this.wayChoice.getItems().get(0));

    }

    public void clickedWay() throws IOException {
        //choiceboxra eseményfigyelő, melyiket választotta
        this.wayChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.clickedWay.setText(this.wayChoice.getValue() + " "+newValue));
        System.out.println("clickedWay:"+this.clickedWay);
        //nextScene();
    }

    private void nextScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/getOffTimes.fxml"));
        Stage stage=(Stage)this.clickedWay.getScene().getWindow();
        stage.setScene(new Scene(root,600,300 ));
    }

}
