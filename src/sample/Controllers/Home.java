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
import javafx.stage.StageStyle;
import sample.Database;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class Home extends VBox {

    @FXML VBox container;
    @FXML Label title;
    @FXML ArrayList<Button> buttonList=new ArrayList();

    private ArrayList<HBox> hboxes = new ArrayList();
    private ArrayList<String> buttons = new ArrayList();
    private String clickedButtonText;
    private Model model = new Model();
    private ArrayList<String[]> iHaveGivenUp;

    public void initialize() throws SQLException {
        //a lekérdezett rekordok Stringjeiből létrehozok egy tömblistát, ez lesz majd a gombok felirata
        iHaveGivenUp = model.getLineNumLetter();
        for (int i = 0; i< iHaveGivenUp.size(); i++) {
            buttons.add(iHaveGivenUp.get(i)[0] + iHaveGivenUp.get(i)[1]);
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

    public void clickedButton(){

        for(int i=0;i<buttonList.size();i++){
            buttonList.get(i).setOnAction(e-> {
                //System.out.println("Button pressed " + ((Button) e.getSource()).getText());
                //kiszedjük a megnyomott gomb szövegét


                try {

                    this.clickedButtonText=((Button) e.getSource()).getText();
                    String lineNum = "", lineLetter = "";
                    for(int j = 0; j<buttons.size(); j++) {
                        if (this.clickedButtonText.equals(buttons.get(j))) {
                            lineNum = iHaveGivenUp.get(j)[0];
                            lineLetter = iHaveGivenUp.get(j)[1];
                        }
                    }
                    nextScene(lineNum, lineLetter);

                } catch (Exception ioException) {
                    ioException.printStackTrace();
                }
            });
        }



    }
    private void nextScene(String lineNum, String lineLetter) throws IOException {
        System.out.println("Gecikurvaanyád");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/stations.fxml"));
        Stations stations = new Stations(lineNum, lineLetter);

        loader.setController(stations);
        Stage stage = (Stage) this.container.getScene().getWindow();
        Parent root = loader.load();
        stage.setScene(new Scene(root, 700, 500));

        stage.show();
    }

}






