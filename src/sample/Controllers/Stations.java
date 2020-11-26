package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stations {
    @FXML
    VBox container;
    @FXML
    Label title;
    @FXML
    ArrayList<String> buttons = new ArrayList();

    Database db = new Database("localhost", "menetrend_javafx", "root", "");
    private ResultSet result = db.query("SELECT allomas.nev\n" +
            "\n" +
            "    FROM erint\n" +
            "    INNER JOIN vonal ON erint.vonalSorszam = vonal.vonalSorszam\n" +
            "    INNER JOIN allomas ON erint.allomasSorszam = allomas.allomasSorszam\n" +
            "            WHERE\n" +
            "    vonal.vonalSzam LIKE '2' AND vonal.vonalSorszam%2=0");

    public void showStations() throws SQLException {
        while (result.next()) {
            buttons.add(result.getString("nev"));
        }
        for (int i=0;i<buttons.size();i++){
            System.out.println(buttons.get(i));

        }
    }

}
