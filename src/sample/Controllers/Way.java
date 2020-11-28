package sample.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private String clickedWay;
    private String lineNum;
    private String lineLetter;
    private Model model = new Model();

   /* private String num=Home.getClickedButtonText().substring(0,2);
    private String letter=Home.getClickedButtonText().substring(2,3);*/
    public Way(String lineNum, String lineLetter) {

        this.lineNum = lineNum;
        this.lineLetter = lineLetter;
        System.out.println(lineNum);
        System.out.println(lineLetter);
    }

    public void initialize() throws SQLException, IOException {
        //choicebox hozzáadása a containerhez
        this.container.getChildren().add(this.wayChoice);
        //kiszedjük a kezdő és végállomásokat stringként
        wayList.add("Válasszon állomást");
        ArrayList<String> temp = model.getWayList(lineNum, lineLetter);
        for (String s:
                temp) {
            wayList.add(s);
        }

        //az kezdő és végállomásokat átadjuk a choiceboxnak
        for (int i = 0; i < wayList.size(); i++) {
            this.wayChoice.getItems().addAll(wayList.get(i));
            System.out.println("stations: " + wayList.get(i));
        }
        //coiceboxnak kezdőérték
        this.wayChoice.setValue(this.wayChoice.getItems().get(0));
        this.wayChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (t1 != null) {
                    clickedWay = wayList.get((int) t1);
                    try {
                        nextScene(lineNum, lineLetter, clickedWay);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void nextScene(String lineNum, String lineLetter, String stationName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/getOffTimes.fxml"));
        GetOffTimes got = new GetOffTimes(lineNum, lineLetter, stationName);
        loader.setController(got);
        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));


        stage.show();
    }

}
