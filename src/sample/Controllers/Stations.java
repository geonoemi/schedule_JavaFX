package sample.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Model.Model;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stations {
    @FXML VBox container;
    @FXML Button back;
    @FXML HBox navButtons;
    @FXML ArrayList<String> stations = new ArrayList();

    private ChoiceBox<String> stationChoice = new ChoiceBox();
    private String lineNum, lineLetter, stationName;
    private Model model = new Model();

    public Stations(String lineNum, String lineLetter) {
        this.lineNum = lineNum;
        this.lineLetter = lineLetter;

    }

    public void initialize() throws SQLException, IOException {
        this.container.getChildren().add(this.stationChoice);
        stations.add("Válassz állomást");
        ArrayList<String> stationList = model.getStationName(this.lineNum, lineLetter);

        for (String station : stationList) {

                stations.add(station);

        }

        for (int i=0;i<stations.size();i++){
            this.stationChoice.getItems().addAll(stations.get(i));
        }

        this.stationChoice.setValue(this.stationChoice.getItems().get(0));
        this.stationChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                 if (t1 != null) {
                     stationName = stationChoice.getItems().get((int) t1);
                     try {

                         nextScene(lineNum, lineLetter,stationName);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
            }
        });
        navigation();
    };

    private void navigation(){
        navButtons.setPadding(new Insets(10));
        navButtons.getStyleClass().add("navButtonClass");
        navButtons.setAlignment(Pos.BOTTOM_RIGHT);
        back.setOnAction(e-> {
            try {
                prevScene();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
    private void nextScene(String lineNum, String lineLetter, String stationName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/way.fxml"));
        Way way = new Way(lineNum, lineLetter, stationName);
        loader.setController(way);

        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }


    public void prevScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}

