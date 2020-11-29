package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetOffTimes {

    private String lineNum, lineLetter, stationName;
    private Model model = new Model();
    private ArrayList<HBox> hboxes = new ArrayList();

    @FXML VBox container;
    @FXML ArrayList timesContainer;
    @FXML Label title;
    @FXML HBox notificationBox;
    @FXML Rectangle rect;
    @FXML Button back;
    @FXML Button home;


    public GetOffTimes(String lineNum, String lineLetter, String stationName) {
        this.lineNum = lineNum;
        this.lineLetter = lineLetter;
        this.stationName = stationName;
    }

    public void initialize() throws SQLException, IOException {
        ArrayList<String> timesList = model.getDisabledVehicleTimesFromStations(this.lineNum, this.lineLetter, this.stationName);
        Label label = new Label();
        String times = "";
        String timesSubstring="";
        /*7.index rokkantszám, 9. index alacsonypadlos true*/
        this.timesContainer.add(this.hboxes);
        for (int i=0;i<timesList.size();i++) {
            hboxes.add(new HBox(label));
            times += timesList.get(i) + "\n";
            timesSubstring+=timesList.get(i).substring(0,5) + "\n";
            label.setText(timesSubstring);

            if(Integer.parseInt(String.valueOf(times.charAt(6)))>=1 && Integer.parseInt(String.valueOf(times.charAt(8)))==1){
            //if(Integer.parseInt(String.valueOf(timesList.get(i).charAt(6)))>=1 && Integer.parseInt(String.valueOf(timesList.get(i).charAt(8)))==1){
                //System.out.println(timesSubstring+"rokkant: "+Integer.parseInt(String.valueOf(timesList.get(i).charAt(6)))+" alacsonypadlós? "+Integer.parseInt(String.valueOf(timesList.get(i).charAt(8))));
                label.setBackground(new Background(new BackgroundFill(Color.rgb(255, 204, 0,1), new CornerRadii(5.0), new Insets(-5.0))));
            }else{
                label.setBackground(new Background(new BackgroundFill(Color.rgb(18, 54, 125,1), new CornerRadii(5.0), new Insets(-5.0))));
            }
            this.container.getChildren().add(label);
        }

        notification();
        navigation();
    }

    private void notification() {
        rect = new Rectangle(0,0, 10, 10);
        rect.setFill(Color.rgb(255, 204, 0,1));

        notificationBox.getChildren().addAll(rect);
        notificationBox.setAlignment(Pos.BOTTOM_RIGHT);
    }

    private void navigation(){
        back.setOnAction(e-> {
            try {
                prevScene( );
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        home.setOnAction(e-> {
            try {
                homeScene();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    private void homeScene() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) this.container.getScene().getWindow();
            stage.setScene(new Scene(root, 700, 500));
    }

    public void prevScene() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/way.fxml"));
            Way way = new Way(lineNum, lineLetter);
            loader.setController(way);
            Parent root = loader.load();
            Stage stage = (Stage) this.container.getScene().getWindow();
            stage.setScene(new Scene(root, 700, 500));
            stage.show();
    }
}
