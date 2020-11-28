package sample.Controllers;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private String lineNum, lineLetter;
    private Button clickedStation;
    private Model model = new Model();

    public Stations(String lineNum, String lineLetter) {
        this.lineNum = lineNum;
       // System.out.println(lineLetter);
        this.lineLetter = lineLetter;
        //System.out.println(lineNum);
    }
    public void initialize() throws SQLException, IOException {
        //choicebox hozzáadása a containerhez
        this.container.getChildren().add(this.stationChoice);
        //kiszedjük az állomásokat stringként
        ArrayList<String> temp = model.getStationName(this.lineNum, lineLetter);
        stations.add("Válasszon állomást");
        for (String s:
             temp) {
            stations.add(s);
        }
        //az állomásneveket átadjuk a choiceboxnak
        for (int i=0;i<stations.size();i++){
            this.stationChoice.getItems().addAll(stations.get(i));
          //  System.out.println("stations: "+stations.get(i));
        }
        //coiceboxnak kezdőérték
        this.stationChoice.setValue(this.stationChoice.getItems().get(0));
        this.stationChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                 if (t1 != null) {
                     try {
                         nextScene(lineNum, lineLetter);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
            }
        });

        };
        //clickedStation();



    /*public void clickedStation() throws IOException {
        //choiceboxra eseményfigyelő, melyiket választotta
        this.stationChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.clickedStation.setText(this.stationChoice + " "+newValue));
        System.out.println("clickedStation:"+this.clickedStation);
        //nextScene();

    }*/
    private void nextScene(String lineNum, String lineLetter) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/way.fxml"));

        Way way = new Way(lineNum, lineLetter);
        loader.setController(way);
        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));


        stage.show();
    }

/*System.out.println("Gecikurvaanyád");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stations.fxml"));
        Stations stations = new Stations(lineNum, lineLetter);

        loader.setController(stations);
        Stage stage = (Stage) this.container.getScene().getWindow();
        Parent root = loader.load();
        stage.setScene(new Scene(root, 700, 500));

        stage.show();
    }*/

}

