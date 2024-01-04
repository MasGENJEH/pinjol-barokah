package com.example.demo5;

public class User {

    private int nikValue;
    private String namaValue;
    private String kelaminValue;
    private String alamatValue;
    private String perkerjaanValue;
    private String gajiValue;
    private String teleponValue;

    public User(int nikValue, String namaValue, String kelaminValue, String alamatValue, String perkerjaanValue, String gajiValue, String teleponValue){
        this.nikValue = nikValue;
        this.namaValue = namaValue;
        this.kelaminValue = kelaminValue;
        this.alamatValue = alamatValue;
        this.perkerjaanValue = perkerjaanValue;
        this.gajiValue = gajiValue;
        this.teleponValue = teleponValue;
    }

    @Override
    public String toString() {
        return "User{" +
                "namaValue='" + namaValue + '\'' +
                ", nikValue=" + nikValue +
                '}';
    }

    public String getAlamatValue() {
        return alamatValue;
    }

    public void setAlamatValue(String alamatValue) {
        this.alamatValue = alamatValue;
    }

    public String getGajiValue() {
        return gajiValue;
    }

    public void setGajiValue(String gajiValue) {
        this.gajiValue = gajiValue;
    }

    public String getKelaminValue() {
        return kelaminValue;
    }

    public void setKelaminValue(String kelaminValue) {
        this.kelaminValue = kelaminValue;
    }

    public String getNamaValue() {
        return namaValue;
    }

    public void setNamaValue(String namaValue) {
        this.namaValue = namaValue;
    }

    public int getNikValue() {
        return nikValue;
    }

    public void setNikValue(int nikValue) {
        this.nikValue = nikValue;
    }

    public String getPerkerjaanValue() {
        return perkerjaanValue;
    }

    public void setPerkerjaanValue(String perkerjaanValue) {
        this.perkerjaanValue = perkerjaanValue;
    }

    public String getTeleponValue() {
        return teleponValue;
    }

    public void setTeleponValue(String teleponValue) {
        this.teleponValue = teleponValue;
    }
}
