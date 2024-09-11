package com.example.integrador1Grupo20.dto;

public class ProductoDTO {
    private String nombre;
    private float valor;

    public ProductoDTO(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}