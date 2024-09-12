package com.example.integrador1Grupo20.dao;

import com.example.integrador1Grupo20.dto.ProductoDTO;
import com.example.integrador1Grupo20.dto.ProductoMayorRecaudacionDTO;
import com.example.integrador1Grupo20.entities.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private Connection conn;

    public ProductoDAO(Connection conn) {
        this.conn = conn;
    }

    /*3)Escriba un programa JDBC que retorne el producto que más recaudó. Se define
      “recaudación” como cantidad de productos vendidos multiplicado por su valor*/

    public ProductoMayorRecaudacionDTO productoMasRecaudo() throws SQLException {
        String query = "SELECT P.nombre, SUM(fp.cantidad * P.valor) recaudacion " +
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

    public List<ProductoDTO> getProductos() {
        String query = "SELECT * " +
                "FROM Producto ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProductoDTO> listado = new ArrayList<ProductoDTO>();
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            // Crear una nueva instancia de Producto con los datos recuperados de la consulta
            while (rs.next()) { // Verificar si hay resultados
                String nombre = rs.getString("nombre");
                Float valor = rs.getFloat("valor");

                ProductoDTO productoDTO = new ProductoDTO(nombre, valor);
                listado.add(productoDTO);
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

    public ProductoDTO findProductoDTO(Integer pk) {
        String query = "SELECT nombre, valor " +
                "FROM Producto " +
                "WHERE idProducto = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, pk); // Establecer el parámetro en la consulta SQL
            rs = ps.executeQuery();
            if (rs.next()) { // Verificar si hay resultados
                String nombre = rs.getString("nombre");
                Float valor = rs.getFloat("valor");

                // Crear una nueva instancia de ProductoDTO con los datos recuperados de la consulta
                ProductoDTO productoDTO = new ProductoDTO(nombre, valor);
                return productoDTO;
            }
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

        return null;
    }

    public void insertProducto(Producto producto){
        String query = "INSERT INTO Producto (idProducto,nombre,valor) VALUES (?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, producto.getIdProducto()); // idProducto
            ps.setString(2, producto.getNombre()); // nombre
            ps.setFloat(3, producto.getValor()); // valor
            ps.executeUpdate();
            System.out.println("Producto insertado exitosamente.");
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

    public void updateProducto(Producto producto){
        String query = "UPDATE Producto SET nombre = ?, valor = ? WHERE idProducto = ?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, producto.getNombre()); // nombre
            ps.setFloat(2, producto.getValor()); // valor
            ps.setInt(3, producto.getIdProducto()); // idProducto
            ps.executeUpdate();
            System.out.println("Producto actualizado exitosamente.");
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

    public Boolean deleteProducto(Integer id){
        String query = "DELETE FROM Producto WHERE idProducto = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id); // idProducto
            ps.executeUpdate();
            System.out.println("Producto eliminado exitosamente.");
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
