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

public class DaftarLender {

    @FXML
    private Button btnBatal;

    @FXML
    private Button btnOk;

    @FXML
    private TextField txtTelp;

    @FXML
    private TextField txtalamat;

    @FXML
    private TextField txtkelamin;

    @FXML
    private TextField txtnama;

    @FXML
    private TextField txtnik;

    String nikValue;
    String namaValue;
    String kelaminValue;
    String alamatValue;
    String telpValue;

    @FXML
    void batalin(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LenderUI.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("LENDER");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void handleOkButton(ActionEvent event) {

        nikValue = txtnik.getText();
        namaValue = txtnama.getText();
        kelaminValue = txtkelamin.getText();
        alamatValue = txtalamat.getText();
        telpValue = txtTelp.getText();



        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "INSERT INTO lender VALUES ('" + nikValue + "','" + namaValue + "','" + kelaminValue + "','" + alamatValue + "','" + telpValue + "')";

        if ((txtnik.getText() != null && !txtnik.getText().isEmpty())
                && (txtnama.getText() != null && !txtnama.getText().isEmpty())
                && (txtkelamin.getText() != null && !txtkelamin.getText().isEmpty())
                && (txtalamat.getText() != null && !txtalamat.getText().isEmpty())
                && (txtTelp.getText() != null && !txtTelp.getText().isEmpty())){
            try {

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(query);

                txtnik.clear();
                txtnama.clear();
                txtkelamin.clear();
                txtalamat.clear();
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

}
