package com.example.integrador1Grupo20.entities;

public class Factura_Producto {
    private int idFactura;
    private int idProducto;
    private int cantidad;

    public Factura_Producto(int idFactura, int idProducto, int cantidad) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdFactura() {
        return idFactura;
    }

}
