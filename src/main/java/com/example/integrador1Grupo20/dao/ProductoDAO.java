package com.example.integrador1Grupo20.dao;

import java.sql.Connection;

public class ProductoDAO {
    private Connection conn;

    public ProductoDAO(Connection conn) {
        this.conn = conn;
    }
}
