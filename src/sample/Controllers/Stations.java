package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private ArrayList<String> buttons = new ArrayList();
    private Button clickedNum=new Button(Home.getClickedButtonText());
    private ArrayList<String> stationsText = new ArrayList();
    private Button clickedStation;
    Database db = new Database("localhost", "menetrend_javafx", "root", "");
    private ResultSet result = db.query("SELECT allomas.nev\n" +
            "\n" +
            "    FROM erint\n" +
            "    INNER JOIN vonal ON erint.vonalSorszam = vonal.vonalSorszam\n" +
            "    INNER JOIN allomas ON erint.allomasSorszam = allomas.allomasSorszam\n" +
            "            WHERE\n" +
            "    vonal.vonalSzam LIKE '"+this.clickedNum/*"ide jönne a Home.clickedButton, ha látná"*/+"' AND vonal.vonalSorszam%2=0");


    public void showStations() throws SQLException {
        while (result.next()) {
            buttons.add(result.getString("nev"));

        }
        for (int i=0;i<buttons.size();i++){
            stationsButtonList.add(new Button(buttons.get(i)));
            System.out.println(buttons.get(i));
        }

        for(int i=0;i<stationsButtonList.size();i++){
            this.container.getChildren().addAll(stationsButtonList.get(i));
            /*this.clickedStation=stationsButtonList.get(i);
            this.clickedStation.setOnAction(e-> {
                clickedStation();
            });*/
        }
        clickedStation();
    }

    private void clickedStation() {

    }


}
