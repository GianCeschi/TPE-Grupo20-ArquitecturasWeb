package com.example.integrador1Grupo20.dto;

public class ClienteDTO {
    private String nombre;
    private Float facturacion;

    public ClienteDTO(String nombre, Float facturacion) {
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