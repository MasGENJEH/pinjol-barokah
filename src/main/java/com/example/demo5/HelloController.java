package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnBorrower;

    @FXML
    private Button btnLender;

    @FXML
    void switchToBorrowerUI(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("BorrowerUI.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("PINJOL BAROKAH");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void switchToLenderUI(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LenderUI.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("PINJOL BAROKAH");
        stage.setScene(scene);
        stage.show();


    }

}