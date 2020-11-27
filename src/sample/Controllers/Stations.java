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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stations {
    @FXML VBox container;
    @FXML Label title;
    @FXML ArrayList<Button> stationsButtonList=new ArrayList();

    private ChoiceBox<String> stationChoice = new ChoiceBox(); //fxmlből nem látja

    private ArrayList<String> stations = new ArrayList();
    private String clickedNum;
    private Button clickedStation;
    private Model model = new Model();

    public Stations(String clickedButton) {
        this.clickedNum = clickedButton;
    }
    public void initialize() throws SQLException, IOException {
        //choicebox hozzáadása a containerhez
        this.container.getChildren().add(this.stationChoice);
        //kiszedjük az állomásokat stringként
        stations = model.getStationName(this.clickedNum);
        //az állomásneveket átadjuk a choiceboxnak
        for (int i=0;i<stations.size();i++){
            this.stationChoice.getItems().addAll(stations.get(i));
            System.out.println("stations: "+stations.get(i));
        }
        //coiceboxnak kezdőérték
        this.stationChoice.setValue(this.stationChoice.getItems().get(0));
        //clickedStation();

    }

    public void clickedStation() throws IOException {
        //choiceboxra eseményfigyelő, melyiket választotta
        this.stationChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.clickedStation.setText(this.stationChoice + " "+newValue));
        System.out.println("clickedStation:"+this.clickedStation);
        //nextScene();

    }
    private void nextScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/way.fxml"));


        Parent root = loader.load();
        Stage stage=(Stage)this.clickedStation.getScene().getWindow();
        stage.setScene(new Scene(root,600,300 ));
    }



}

