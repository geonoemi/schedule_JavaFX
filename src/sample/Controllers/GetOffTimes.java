package sample.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetOffTimes {
    private String lineNum, lineLetter, stationName;
    private Model model = new Model();
    @FXML
    VBox container;
    @FXML
    Label title;

    public GetOffTimes(String lineNum, String lineLetter, String stationName) {
        this.lineNum = lineNum;
        this.lineLetter = lineLetter;
        this.stationName = stationName;
    }

    public void initialize() throws SQLException, IOException {
        ArrayList<String> temp = model.getTimesFromStations(this.lineNum, this.lineLetter, this.stationName);
        Label label = new Label();
        String test = "";
        for (String s:
             temp) {
            test += s + "\n";
        }
        label.setText(test);
        this.container.getChildren().add(label);


    }
    public void nextScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/getofftimes.fxml"));

        GetOffTimes got = new GetOffTimes(lineNum, lineLetter, stationName);
        loader.setController(got);
        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));


        stage.show();
    }
}
