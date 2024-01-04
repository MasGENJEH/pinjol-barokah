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

public class BorrowerUI {

    @FXML
    private Button btnDaftar;

    @FXML
    private Button btnPinjam;

    @FXML
    void toDaftar(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("daftarform.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("PINJOL BAROKAH");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void toPinjam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pinjamUI.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("PINJOL BAROKAH");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("PINJOL BAROKAH");
        stage.setScene(scene);
        stage.show();
    }

}