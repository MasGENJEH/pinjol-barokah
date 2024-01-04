package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class InvestasiUI {

    @FXML
    private Button btnBatal;

    @FXML
    private Button btnPinjam;

    @FXML
    private Button btnSearch;

    @FXML
    private ComboBox<Integer> cmbTenor;

    @FXML
    private Label labelNIK;

    @FXML
    private Label labelNama;

    @FXML
    private TextField txtCari;

    @FXML
    private TextField txtPinjaman;

    @FXML
    private TextField txtTenor;



    @FXML
    void toSearch() {


    }


    public void pinjam(ActionEvent actionEvent) {


    }

    @FXML
    void toHome(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("BorrowerUI.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("PINJOL BAROKAH");
        stage.setScene(scene);
        stage.show();

    }
}
