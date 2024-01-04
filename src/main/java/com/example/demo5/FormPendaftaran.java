package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FormPendaftaran {

    @FXML
    private Button btnBatal;

    @FXML
    private Button btnOk;

    @FXML
    private TextField txtalamat;

    @FXML
    private TextField txtgaji;

    @FXML
    private TextField txtkelamin;

    @FXML
    private TextField txtnama;

    @FXML
    private TextField txtnik;

    @FXML
    private TextField txtperkerjaan;

    @FXML
    private TextField txtTelp;


    String nikValue;
    String namaValue;
    String kelaminValue;
    String alamatValue;
    String perkerjaanValue;
    String gajiValue;
    String telpValue;

    @FXML
    private void handleOkButton(ActionEvent event) throws SQLException, ClassNotFoundException {

        nikValue = txtnik.getText();
        namaValue = txtnama.getText();
        kelaminValue = txtkelamin.getText();
        alamatValue = txtalamat.getText();
        perkerjaanValue = txtperkerjaan.getText();
        gajiValue = txtgaji.getText();
        telpValue = txtTelp.getText();



        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "INSERT INTO nasabah VALUES ('" + nikValue + "','" + namaValue + "','" + kelaminValue + "','" + alamatValue + "','" + perkerjaanValue + "','" + gajiValue + "','" + telpValue + "')";

        if ((txtnik.getText() != null && !txtnik.getText().isEmpty())
                && (txtnama.getText() != null && !txtnama.getText().isEmpty())
                && (txtkelamin.getText() != null && !txtkelamin.getText().isEmpty())
                && (txtalamat.getText() != null && !txtalamat.getText().isEmpty())
                && (txtperkerjaan.getText() != null && !txtperkerjaan.getText().isEmpty())
                && (txtgaji.getText() != null && !txtgaji.getText().isEmpty())
                && (txtTelp.getText() != null && !txtTelp.getText().isEmpty())){
            try {

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(query);

                txtnik.clear();
                txtnama.clear();
                txtkelamin.clear();
                txtalamat.clear();
                txtperkerjaan.clear();
                txtgaji.clear();
                txtTelp.clear();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }



        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SUKSES!!!");

        alert.setContentText("Silahkan kembali ke home");
        alert.showAndWait();
    }

    @FXML
    void batalin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowerUI.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("PINJOL BAROKAH");
        stage.setScene(scene);
        stage.show();

    }

}
