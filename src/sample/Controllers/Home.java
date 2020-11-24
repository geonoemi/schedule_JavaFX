package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Home extends VBox{
    public ArrayList<Scene> scenes=new ArrayList<>();

    @FXML
    public VBox container;
    @FXML
    Label title;
    @FXML
    public Button buttonBus;
    @FXML
    public Button buttonTram;
    @FXML
    public Button buttonTrolley;
    private Stage stage;

    public void busClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/bus.fxml"));
        Stage stage=(Stage)buttonBus.getScene().getWindow();
        stage.setScene(new Scene(root,500,500 ));

        Bus bus=new Bus();
        this.stage=new Stage();

       /* Pane buses= FXMLLoader.load(getClass().getResource("/fxml/bus70.fxml"));
        this.stage.setScene(new Scene(buses,500, 500));
        this.stage.show();*/
       // bus.busClick();
    }

    public void tramClick(ActionEvent actionEvent) {

    }

    public void trolleyClick(ActionEvent actionEvent) {
    }
}

