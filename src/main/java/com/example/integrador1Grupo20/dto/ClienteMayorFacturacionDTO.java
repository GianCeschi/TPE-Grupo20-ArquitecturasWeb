package com.example.integrador1Grupo20.dto;

public class ClienteMayorFacturacionDTO {
    private String nombre;
    private Float facturacion;

    public ClienteMayorFacturacionDTO(String nombre, Float facturacion) {
        this.nombre = nombre;
        this.facturacion = facturacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getFacturacion() {
        return facturacion;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "nombre='" + nombre + '\'' +
                ", facturacion=" + facturacion +
                '}';
    }
}