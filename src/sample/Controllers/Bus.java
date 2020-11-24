package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Bus {

        @FXML
        Button button70;
        @FXML
        Button button71A;
        @FXML
        Button button90;

        public void bus70Click(ActionEvent actionEvent) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Stations/stations70.fxml"));
                Stage stage=(Stage)button70.getScene().getWindow();
                stage.setScene(new Scene(root,500,500 ));
        }

        public void bus71AClick(ActionEvent actionEvent) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/71AStations.fxml"));
                Stage stage=(Stage)button71A.getScene().getWindow();
                stage.setScene(new Scene(root,500,500 ));
        }

        public void bus90Click(ActionEvent actionEvent) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/90Stations.fxml"));
                Stage stage=(Stage)button90.getScene().getWindow();
                stage.setScene(new Scene(root,500,500 ));
        }

       /* public ResultSet query(String sql) {
            try {
                db.rs = db.sm.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println("Adatbázis hiba");
            }
            return db.rs;
        }*/




}
