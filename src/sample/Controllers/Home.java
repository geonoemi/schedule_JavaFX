package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Controllers.Bus;

import java.io.IOException;
import java.util.ArrayList;

public class Home extends VBox{
    public ArrayList<Scene> scenes=new ArrayList<>();

    @FXML
    public VBox container;
    @FXML
    Label title;
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    private Stage stage;

    public void busClick(ActionEvent actionEvent) throws IOException {

        Bus bus=new Bus();
        this.stage=new Stage();

        Pane buses= FXMLLoader.load(getClass().getResource("/fxml/bus.fxml"));
        this.stage.setScene(new Scene(buses,500, 500));
        this.stage.show();
        bus.busClick();
    }

    public void tramClick(ActionEvent actionEvent) {
    }

    public void trolleyClick(ActionEvent actionEvent) {
    }
}

