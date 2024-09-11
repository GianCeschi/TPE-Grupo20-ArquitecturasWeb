package com.example.integrador1Grupo20.dto;

public class ClienteDTO {
    private int idCliente;
    private String nombre;
    private String email;

    public ClienteDTO(int idCliente, String nombre, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ClienteDTO [getIdCliente()=" + getIdCliente() + ", getNombre()=" + getNombre() + ", getEmail()="
                + getEmail() + "]";
    }
    
}
