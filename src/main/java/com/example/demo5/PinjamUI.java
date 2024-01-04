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
import java.sql.*;
import java.time.LocalDate;

public class PinjamUI {

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

    LocalDate currentDate = LocalDate.now();

    // Konversi tanggal menjadi objek java.sql.Date
    Date currentSqlDate = Date.valueOf(currentDate);

    private String searchText;
    private String searchTex;
    private String gaji;


    @FXML
    void toSearch() {

        searchText = txtCari.getText();


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try {
            String query = "SELECT nik, Nama FROM nasabah WHERE nik = '" + searchText + "'";
            Statement statement = connectDB.createStatement();

            ResultSet result = statement.executeQuery(query);

            if (result.next()) {
                searchText = result.getString("nik");
                searchTex = result.getString("nama");

            } else {
                searchText = "Tidak ditemukan";
                searchTex = "Tidak ditemukan";
            }


            labelNIK.setText(searchText);
            labelNama.setText(searchTex);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }


    public void pinjam(ActionEvent actionEvent) {
        toSearch();

        int tenor = Integer.parseInt(txtTenor.getText());
        long pinjam = Long.parseLong(txtPinjaman.getText());

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        double cicilan = (pinjam / tenor) + (pinjam * 0.04);

        String gajiQuery = "SELECT gaji FROM nasabah WHERE nik = '" + searchText + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet gajiResult = statement.executeQuery(gajiQuery);

            if (gajiResult.next()) {
                int gaji = gajiResult.getInt("gaji");


                if (gaji <= 5000000) {
                    double pinjamanMaksimum = 10000000;

                    if (pinjam > pinjamanMaksimum) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("GAGAL!!!");
                        alert.setHeaderText("Nilai yang Anda masukkan melebihi pinjaman maksimum");
                        alert.showAndWait();
                    } else {
                        String query = "INSERT INTO pinjaman VALUES ('" + uniqueCode.Unique() + "','" + currentSqlDate + "','" + pinjam + "','" + tenor + "','" + searchText + "','" + cicilan + "')";
                        statement.executeUpdate(query);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("SUKSES!!!");
                        alert.setHeaderText("Data yang Anda masukkan telah berhasil!!!");
                        alert.showAndWait();
                    }

                } else if (gaji <= 50000000) {
                    double pinjamanMaksimum = 100000000;

                    if (pinjam > pinjamanMaksimum) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("GAGAL!!!");
                        alert.setHeaderText("Nilai yang Anda masukkan melebihi pinjaman maksimum");
                        alert.showAndWait();
                    } else {
                        String query = "INSERT INTO pinjaman VALUES ('" + uniqueCode.Unique() + "','" + currentSqlDate + "','" + pinjam + "','" + tenor + "','" + searchText + "','" + cicilan + "')";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        statement.executeUpdate(query);
                        alert.setTitle("SUKSES!!!");
                        alert.setHeaderText("Data yang Anda masukkan telah berhasil!!!");
                        alert.showAndWait();
                    }
                } else if (gaji <= 500000000) {
                    double pinjamanMaksimum = 1000000000;
                    if (pinjam > pinjamanMaksimum) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("GAGAL!!!");
                        alert.setHeaderText("Nilai yang Anda masukkan melebihi pinjaman maksimum");
                        alert.showAndWait();
                    }else {
                        String query = "INSERT INTO pinjaman VALUES ('" + uniqueCode.Unique() + "','" + currentSqlDate + "','" + pinjam + "','" + tenor + "','" + searchText + "','" + cicilan + "')";
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        statement.executeUpdate(query);
                        alert.setTitle("SUKSES!!!");
                        alert.setHeaderText("Data yang Anda masukkan telah berhasil!!!");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("GAGAL!!!");
                    alert.setHeaderText("Nilai yang Anda masukkan melebihi pinjaman maksimum");
                    alert.showAndWait();
                    return; // Keluar dari method pinjam jika gaji melebihi batas
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

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
