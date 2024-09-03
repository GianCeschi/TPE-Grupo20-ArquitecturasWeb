package com.example.integrador1Grupo20.entities;

public class Factura {
    private int idFactura;
    private int idCliente;

    public Factura(int idCliente, int idFactura) {
        this.idCliente = idCliente;
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

}
