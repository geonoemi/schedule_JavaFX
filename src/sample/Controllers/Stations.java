package sample.Controllers;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stations {
    @FXML VBox container;
    @FXML Label title;
    @FXML Button back;
    @FXML Button home;

  //  @FXML ArrayList<Button> stationsButtonList=new ArrayList();

    private ChoiceBox<String> stationChoice = new ChoiceBox(); //fxmlből nem látja
    private ArrayList<String> stations = new ArrayList();
    private String lineNum, lineLetter;
  //  private Button clickedStation;
    private Model model = new Model();

    public Stations(String lineNum, String lineLetter) {
        this.lineNum = lineNum;
        this.lineLetter = lineLetter;
    }
    public void initialize() throws SQLException, IOException {
        this.container.getChildren().add(this.stationChoice);
        ArrayList<String> temp = model.getStationName(this.lineNum, lineLetter);
        stations.add("Válasszon állomást");
        for (String s:
             temp) {
            stations.add(s);
        }
        for (int i=0;i<stations.size();i++){
            this.stationChoice.getItems().addAll(stations.get(i));
        }
        this.stationChoice.setValue(this.stationChoice.getItems().get(0));
        this.stationChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                 if (t1 != null) {
                     try {
                         nextScene(lineNum, lineLetter);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
            }
        });
        back.setOnAction(e-> {
            try {
                prevScene();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        home.setOnAction(e-> {
            try {
                prevScene();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    };

    private void nextScene(String lineNum, String lineLetter) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/way.fxml"));

        Way way = new Way(lineNum, lineLetter);
        loader.setController(way);
        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));

        stage.show();
    }


    public void prevScene() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));

       // Way way = new Way(lineNum, lineLetter);
       // loader.setController(way);
        Parent root = loader.load();
        Stage stage = (Stage) this.container.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));

        stage.show();
    }
}

