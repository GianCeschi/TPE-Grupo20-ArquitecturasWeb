package com.example.integrador1Grupo20.dao;

import com.example.integrador1Grupo20.entities.Factura_Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacturaProductoDAO {
    private Connection conn;

    public FacturaProductoDAO(Connection conn) {

        this.conn = conn;
    }
    public void insertFacturaProducto(Factura_Producto facturaProducto){
        String query = "INSERT INTO Factura_Producto (idFactura,idProducto,cantidad) VALUES (?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, facturaProducto.getIdFactura()); // idfactura
            ps.setInt(2, facturaProducto.getIdProducto()); // idProducto
            ps.setInt(3, facturaProducto.getCantidad()); // cantidad
            ps.executeUpdate();
            System.out.println("Factura_Producto insertada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateFacturaProducto(Factura_Producto facturaProducto){
        String query = "UPDATE Factura_Producto SET cantidad = ? WHERE idFactura = ? AND idProducto = ?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, facturaProducto.getIdFactura()); // idFactura
            ps.setInt(2, facturaProducto.getIdProducto()); // idProducto
            ps.setInt(3, facturaProducto.getCantidad()); // cantidad
            ps.executeUpdate();
            System.out.println("Factura_Producto actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean deleteFacturaProducto(Integer idFactura, Integer idProducto){
        String query = "DELETE FROM Factura_Producto WHERE idFactura = ? AND idProducto = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idFactura); // idFactura
            ps.setInt(2, idProducto); // idProducto
            ps.executeUpdate();
            System.out.println("Factura_Producto eliminada exitosamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
