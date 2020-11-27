package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Home extends VBox {

    @FXML VBox container;
    @FXML Label title;
    @FXML ArrayList<Button> buttonList=new ArrayList();

    private ArrayList<HBox> hboxes = new ArrayList();
    private ArrayList<String> buttons = new ArrayList();
    private Button clickedButton;
    private static String clickedButtonText;

    Database db = new Database("localhost", "menetrend_javafx", "root", "");
    private ResultSet result = db.query("SELECT vonalSzam, vonalBetujel FROM vonal where vonal.vonalSorszam%2=0");

    public static String getClickedButtonText(){ return clickedButtonText; }

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
            }
            a += 5;
            b += 5;
        }
        clickedButton();
    }

    public Button clickedButton(){

        for(int i=0;i<buttonList.size();i++){
            buttonList.get(i).setOnAction(e-> {
                //System.out.println("Button pressed " + ((Button) e.getSource()).getText());
                //kiszedjük a megnyomott gomb szövegét
                this.clickedButtonText=((Button) e.getSource()).getText();
                System.out.println("this.clicked: "+this.clickedButtonText);
            });
        }
        this.clickedButton=new Button(this.clickedButtonText);
        System.out.println("clickedbutton: "+this.clickedButton.getText());
        this.clickedButton.setOnAction(e-> {
            try {
                buttonClick();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        return this.clickedButton;
    }

    private void buttonClick() throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/stations.fxml"));
           Stage stage=(Stage)clickedButton.getScene().getWindow();
           stage.setScene(new Scene(root,600,300 ));
    }
}






