package com.unahur.supermercado;

public class Vino implements EsLiquido, ConDescuento {
    private String marca;
    private String tipoVino;
    private double gradosAlcohol;
    private double precio;
    private double descuento;
    private double volumen;
        private int calorias;
    
    public Vino(String marca, String tipoVino, double gradosAlcohol, double precio) {
        this.marca = marca;
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        this.precio = precio;
        calcularCalorias();
    }
    
    // Métodos set y get
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

  public void setGradosAlcohol(double gradosAlcohol) {
        if (this.gradosAlcohol != gradosAlcohol) {
            this.gradosAlcohol = gradosAlcohol;
            calcularCalorias();
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Métodos de las interfaces
    @Override
    public void setVolumen(double v) {
        this.volumen = v;
    }

    @Override
    public double getVolumen() {
        return this.volumen;
    }

    @Override
    public void setTipoEnvase(String env) {
    }

    @Override
    public String getTipoEnvase() {
        return null;
    }

    // Métodos de ConDescuento
    @Override
    public void setDescuento(double des) {
        this.descuento = des;
    }

    @Override
    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioDescuento() {
        return precio - (precio * descuento);
    }
    

    private void calcularCalorias() {
        long caloriasCalculadas = Math.round(gradosAlcohol * 10.0);
        
        this.calorias = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, caloriasCalculadas));

        System.out.println("---------------------------------");
        System.out.println("Calorías del vino: " + calorias);
    }

    @Override
    public String toString() {
        return "Vino [marca=" + marca + ", tipoVino=" + tipoVino + ", gradosAlcohol=" + gradosAlcohol +
                ", precio=" + precio + ", descuento=" + descuento + "]";
    }
}