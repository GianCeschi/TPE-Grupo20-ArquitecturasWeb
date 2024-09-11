package com.example.integrador1Grupo20.dto;

public class ProductoMayorRecaudacionDTO {
    private  String nombre;
    private float recaudacion;

    public ProductoMayorRecaudacionDTO(String nombre, float recaudacion) {
        this.nombre = nombre;
        this.recaudacion = recaudacion;
    }

    public String getNombre() {
        return nombre;
    }


    public float getRecaudacion() {
        return recaudacion;
    }


    @Override
    public String toString() {
        return "ProductoDTO{" +
                "nombre='" + nombre + '\'' +
                ", recaudacion=" + recaudacion +
                '}';
    }
}
