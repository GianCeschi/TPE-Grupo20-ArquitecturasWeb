package com.example.integrador1Grupo20.dao;

import com.example.integrador1Grupo20.dto.ProductoMayorRecaudacionDTO;
import com.example.integrador1Grupo20.entities.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {
    private Connection conn;

    public ProductoDAO(Connection conn) {
        this.conn = conn;
    }

    /*3)Escriba un programa JDBC que retorne el producto que más recaudó. Se define
      “recaudación” como cantidad de productos vendidos multiplicado por su valor*/

    public ProductoMayorRecaudacionDTO productoMasRecaudo() throws SQLException {
        String query = "SELECT P.nombre, count(fp.idProducto) * P.valor recaudacion " +
                        "FROM Factura_Producto fp " +
                        "JOIN Producto P on fp.idProducto = P.idProducto " +
                        "GROUP BY fp.idProducto " +
                        "ORDER BY recaudacion DESC " +
                        "LIMIT 1";

        PreparedStatement ps = null;
        ResultSet rs = null;

        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();

        if (rs.next()) { // Verificar si hay resultados
            String nombre = rs.getString("nombre");
            float recaudacion = rs.getFloat("recaudacion");

            ProductoMayorRecaudacionDTO prodDTO = new ProductoMayorRecaudacionDTO(nombre,recaudacion);

            return prodDTO;
        }
        return null;

    }

}
