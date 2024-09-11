package com.example.integrador1Grupo20.dto;

public class FacturaDTO {
    private int idFactura;
    private int idCliente;

    public FacturaDTO(int idFactura, int idCliente) {
        this.idCliente = idCliente;
        this.idFactura = idFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "FacturaDTO [getIdFactura()=" + getIdFactura() + ", getIdCliente()=" + getIdCliente() + "]";
    }

}
