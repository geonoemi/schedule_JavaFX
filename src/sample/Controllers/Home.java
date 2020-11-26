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


public class Home extends VBox {

    @FXML VBox container;
    @FXML Label title;

    @FXML ArrayList<Button> buttonList=new ArrayList();
    private ArrayList<HBox> hboxes = new ArrayList();

    private Button clicked;
    private ArrayList<String> buttons = new ArrayList();

    Database db = new Database("localhost", "menetrend_javafx", "root", "");
    private ResultSet result = db.query("SELECT vonalSzam, vonalBetujel FROM vonal where vonal.vonalSorszam%2=0");


    public void initialize() throws SQLException {
       //a lekérdezett rekordok Stringjeiből létrehozok egy tömblistát, ez lesz majd a gombok felirata
        while (result.next()) {
            buttons.add(result.getString("vonalSzam") + result.getString("vonalBetujel"));
        }

        int a = 0;
        int b = 5;
        for (int i = 0; i < 3; i++) {

            this.hboxes.add(new HBox());
            container.getChildren().add(hboxes.get(i));
            for (int j = a; j < b; j++) {
             //a tömblista elemeit átadom a generált gombok feliratának
                buttonList.add(new Button(buttons.get(j)));
                this.hboxes.get(i).getChildren().addAll(buttonList.get(j));
             //   this.clicked=buttonList.get(j).getText();
                this.clicked=buttonList.get(j);
                this.clicked.setOnAction(e-> {
                    try {
                        buttonClick();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
                /*buttonList.get(j).setOnAction(e-> {
                    try {
                        buttonClick(this.clicked);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });*/

            }
            a += 5;
            b += 5;
        }
    }

    private void buttonClick() throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/Stations/stations.fxml"));
           Stage stage=(Stage)clicked.getScene().getWindow();
           stage.setScene(new Scene(root,300,300 ));
    }
}

//select vonal.vonalSzam, vonal.kezdoAllomasSorszam
//FROM vonal inner join allomas on vonal.vonalSorszam=allomas.allomasSorszam


        //SELECT
        //vonal.vonalSzam AS 'Vonal szam',
        //vonal.vonalBetujel AS 'Vonal betujel',
        //vonal.kezdoAllomasSorszam AS 'Kezdo allomas',
        //vonal.vegAllomasSorszam AS 'Vegallomas',
        //allomas.nev
        //
        //FROM erint
        //INNER JOIN vonal ON erint.vonalSorszam = vonal.vonalSorszam
        //INNER JOIN allomas ON erint.allomasSorszam = allomas.allomasSorszam
        //WHERE
        //vonal.vonalSzam LIKE '2'



        //adott vonal állomásai:
        /*SELECT

        allomas.nev

        FROM erint
        INNER JOIN vonal ON erint.vonalSorszam = vonal.vonalSorszam
        INNER JOIN allomas ON erint.allomasSorszam = allomas.allomasSorszam
        WHERE
        vonal.vonalSzam LIKE '2' AND vonal.vonalSorszam%2=0*/





