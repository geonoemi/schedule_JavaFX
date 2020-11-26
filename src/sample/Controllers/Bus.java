package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Bus {

        @FXML
        Label title;

        @FXML
        Button bus70;
        @FXML
        Button bus71a;
        @FXML
        Button bus90;

       /* public void bus70Click(ActionEvent actionEvent) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Buses/bus70.fxml"));
                Stage stage=(Stage)bus70.getScene().getWindow();
                stage.setScene(new Scene(root,500,500 ));
        }

        public void bus71AClick(ActionEvent actionEvent) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Buses/bus71A.fxml"));
                Stage stage=(Stage)bus71a.getScene().getWindow();
                stage.setScene(new Scene(root,500,500 ));
        }

        public void bus90Click(ActionEvent actionEvent) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Buses/bus90.fxml"));
                Stage stage=(Stage)bus90.getScene().getWindow();
                stage.setScene(new Scene(root,500,500 ));
        }
*/
       /* public ResultSet query(String sql) {
            try {
                db.rs = db.sm.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println("Adatbázis hiba");
            }
            return db.rs;
        }*/




}
