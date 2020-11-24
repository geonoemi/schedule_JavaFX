package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
    private ResultSet result= db.query("SELECT vonalSzam, vonalBetujel FROM vonal");
    @FXML
    HBox hbox;
    @FXML
    VBox container;
    @FXML
    VBox content;
    @FXML
    Label title;
    @FXML
    ArrayList<String> buttons=new ArrayList();

    ArrayList<Button> buttonList=new ArrayList();

    public void initialize() throws SQLException {
        //container.getChildren().add(content);
        while(result.next()) {
            buttons.add(result.getString("vonalSzam")+result.getString("vonalBetujel"));
        }
        ArrayList<HBox>hboxes=new ArrayList();
        /*almost there
        for (int i=0;i<4; i++) {
            hboxes.add(new HBox());
            container.getChildren().add(hboxes.get(i));
            for(int j=0;j<5;j++){
                Button button=new Button(buttons.get(j));
                hboxes.get(i).getChildren().addAll(button);
            }
        }*/
        int a=0;
        int b=6;
        for (int i=0;i<5; i++) {

            hboxes.add(new HBox());
            container.getChildren().add(hboxes.get(i));
            for(int j=a;j<b;j++){
                Button button=new Button(buttons.get(j));
                hboxes.get(i).getChildren().addAll(button);
            }
            a+=5;
            b+=5;
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

