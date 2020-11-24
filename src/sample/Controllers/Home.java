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
import sample.Database;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Home extends VBox{

    Database db = new Database("localhost", "menetrend_javafx", "root", "");
    private ResultSet result= db.query("SELECT vonalSzam FROM vonal");

    @FXML
    public VBox container;
    @FXML
    Label title;
    @FXML
    ArrayList<String> buttons=new ArrayList();

    public void initialize() throws SQLException {

        while(result.next()) {
            buttons.add(result.getString("vonalSzam"));
        }
        for (String buttons:buttons) {
            Button button=new Button(buttons);
            container.getChildren().add(button);
            System.out.println(button.getText());
        }
    }






   /* @FXML
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
        this.stage.show();
       // bus.busClick();
    }

    public void tramClick(ActionEvent actionEvent) {

    }

    public void trolleyClick(ActionEvent actionEvent) {
    }*/
}

