package com.example.integrador1Grupo20.dao;

import com.example.integrador1Grupo20.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Cliente> selectList() {
        String query = "SELECT * " +
                "FROM Cliente ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cliente> listado = new ArrayList<Cliente>();;
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            // Crear una nueva instancia de Cliente con los datos recuperados de la consulta
            while (rs.next()) { // Verificar si hay resultados
                int idCliente = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");

                Cliente cliente = new Cliente(idCliente, nombre, email);
                listado.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listado;
    }


}
