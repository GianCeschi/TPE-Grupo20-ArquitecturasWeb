package com.example.integrador1Grupo20.dao;

import java.sql.Connection;

public class FacturaProductoDAO {
    private Connection conn;

    public FacturaProductoDAO(Connection conn) {
        this.conn = conn;
    }
}
