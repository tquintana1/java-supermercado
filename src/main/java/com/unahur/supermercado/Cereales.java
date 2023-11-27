package com.unahur.supermercado;
import java.time.LocalDate;

public class Cereales implements EsAlimento {
    private String marca;
    private double precio;
    private String tipoCereal;
    private LocalDate caducidad;
    private int calorias;

    public Cereales(String marca, double precio, String tipoCereal) {
        this.marca = marca;
        this.precio = precio;
        this.tipoCereal = tipoCereal;
        asignarCalorias();
    }

    // Métodos set y get
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoCereal() {
        return tipoCereal;
    }

    public void setTipoCereal(String tipoCereal) {
        this.tipoCereal = tipoCereal;
        asignarCalorias();
    }

    // Métodos de las interfaces
    @Override
    public void setCaducidad(LocalDate fc) {
        this.caducidad = fc;
    }

    @Override
    public LocalDate getCaducidad() {
        return caducidad;
    }

    @Override
    public int getCalorias() {
        return calorias;
    }

    private void asignarCalorias() {
        switch (tipoCereal.toLowerCase()) {
            case "espelta":
                calorias = 5;
                break;
            case "maíz":
                calorias = 8;
                break;
            case "trigo":
                calorias = 12;
                break;
            default:
                calorias = 15;
        }
    }

    @Override
    public String toString() {
        return "Cereales [marca=" + marca + ", precio=" + precio + ", tipoCereal=" + tipoCereal +
                ", caducidad=" + caducidad + ", calorias=" + calorias + "]";
    }
}
