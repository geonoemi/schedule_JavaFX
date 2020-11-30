package sample.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Model.Model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Way {
    @FXML VBox container;
    @FXML Button back;
    @FXML Button home;
    @FXML ArrayList<String> wayList = new ArrayList();

    private ChoiceBox<String> wayChoice = new ChoiceBox();
    private String clickedWay;
    private String lineNum,lineLetter,stationName;
    private Model model = new Model();

    public Way(String lineNum, String lineLetter,String stationName) {
        this.lineNum = lineNum;
        this.lineLetter = lineLetter;
        this.stationName = stationName;
    }

    public void initialize() throws SQLException, IOException {

        this.container.getChildren().add(this.wayChoice);
        wayList.add("Válassz állomást");
        ArrayList<String> ways = model.getWayList(lineNum, lineLetter, stationName);
        for (String way:ways) {
            if (!way.equals(stationName)) {
                wayList.add(way);
            }
        }

        for (int i = 0; i < wayList.size(); i++) {
            this.wayChoice.getItems().addAll(wayList.get(i));
        }

        this.wayChoice.setValue(this.wayChoice.getItems().get(0));
        this.wayChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (t1 != null) {
                    clickedWay = wayChoice.getItems().get((int) t1);

                    try {
                        nextScene(lineNum, lineLetter, clickedWay);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        navigation();
    }

    public void navigation() {
        back.setOnAction(e-> {
            try {
                prevScene( lineNum,  lineLetter);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        home.setOnAction(e-> {
            try {
                homeScene();
            } catch (IOException ioException) {
                ioException.printStackTrace();
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

    private void prevScene(String lineNum, String lineLetter) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stations.fxml"));
        Stations stations = new Stations(lineNum, lineLetter);
        loader.setController(stations);

        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));

        stage.show();
    }

    private void homeScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));

    }
}
