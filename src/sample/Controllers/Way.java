package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import sample.Database;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Way {
    @FXML VBox container;
    @FXML Label title;

    private String[] wayArray =new String[2];
    private ChoiceBox<String> wayChoice = new ChoiceBox();

    Database db = new Database("localhost", "menetrend_javafx", "root", "");
    private ResultSet result = db.query("SELECT\n" +
            "\n" +
            "vonal.kezdoAllomasSorszam ,\n" +
            "vonal.vegAllomasSorszam \n" +
            "FROM erint\n" +
            "INNER JOIN vonal ON erint.vonalSorszam = vonal.vonalSorszam\n" +
            "INNER JOIN allomas ON erint.allomasSorszam = allomas.allomasSorszam\n" +
            "WHERE\n" +
            "allomas.nev LIKE 'Anna-kút' AND vonal.vonalSzam LIKE \"2\" AND vonal.vonalSorszam%2=0");
}
