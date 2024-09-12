package com.example.integrador1Grupo20.dto;

public class ClienteDTO {
    private String nombre;
    private String email;

    public ClienteDTO(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ClienteDTO [ getNombre()=" + getNombre() + ", getEmail()="
                + getEmail() + "]";
    }
    
}
