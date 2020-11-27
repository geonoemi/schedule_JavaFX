package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
    private Button clickedWay;
   /* private String num=Home.getClickedButtonText().substring(0,2);
    private String letter=Home.getClickedButtonText().substring(2,3);*/

    Database db = new Database("localhost", "menetrend_javafx", "root", "");
    private ResultSet result = db.query("SELECT\n" +
            "A.nev,\n" +
            "V1.vonalSzam,\n" +
            "V1.vonalSorszam,\n" +
            "V1.kezdoAllomasSorszam,\n" +
            "V1.vegAllomasSorszam\n" +
            "FROM allomas AS A\n" +
            "INNER JOIN vonal AS V1 ON A.allomasSorszam = V1.kezdoAllomasSorszam\n" +
            "\n" +
            "WHERE V1.vonalSzam LIKE '90'"+/*this.num*/ "AND V1.vonalBetujel LIKE 'H'" /*this.letter*/);

    public void initialize() throws SQLException, IOException {
        //choicebox hozzáadása a containerhez
        this.container.getChildren().add(this.wayChoice);
        //kiszedjük a kezdő és végállomásokat stringként
        while (result.next()) {
            wayList.add(result.getString("nev"));
        }
        //az kezdő és végállomásokat átadjuk a choiceboxnak
        for (int i = 0; i < wayList.size(); i++) {
            this.wayChoice.getItems().addAll(wayList.get(i));
            System.out.println("stations: " + wayList.get(i));
        }
        //coiceboxnak kezdőérték
        this.wayChoice.setValue(this.wayChoice.getItems().get(0));
        //choiceboxra eseményfigyelő, melyiket választotta
        this.wayChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.clickedWay.setText(this.wayChoice.getValue() + " "+newValue));
        System.out.println("clickedWay:"+this.clickedWay);
        // clickedStation();
    }



}
