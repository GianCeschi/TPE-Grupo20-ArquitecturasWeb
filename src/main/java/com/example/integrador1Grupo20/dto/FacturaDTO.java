package com.example.integrador1Grupo20.dto;

public class FacturaDTO {
    private int idCliente;

    public FacturaDTO(int idCliente) {
        this.idCliente = idCliente;
    }


    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "FacturaDTO [ getIdCliente()=" + getIdCliente() + "]";
    }

}
