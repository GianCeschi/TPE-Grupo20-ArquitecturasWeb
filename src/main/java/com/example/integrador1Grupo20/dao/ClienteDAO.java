package com.example.integrador1Grupo20.dao;

import com.example.integrador1Grupo20.dto.ClienteMayorFacturacionDTO;
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

    public List<ClienteMayorFacturacionDTO> getClientesMayorFacturacion() {
        String query = "SELECT c.nombre ,SUM(fp.cantidad * P.valor) facturacion " +
                       "FROM Factura_Producto fp " +
                       "JOIN Producto P ON fp.idProducto = P.idProducto " +
                       "JOIN Factura F ON fp.idFactura = F.idFactura " +
                       "JOIN Cliente c ON F.idCliente = c.idCliente " +
                       "GROUP BY F.idCliente " +
                       "ORDER BY facturacion DESC";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClienteMayorFacturacionDTO> listado = new ArrayList<ClienteMayorFacturacionDTO>();;
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            // Crear una nueva instancia de Cliente con los datos recuperados de la consulta
            while (rs.next()) { // Verificar si hay resultados
                String nombre = rs.getString("nombre");
                Float facturacion = rs.getFloat("facturacion");

                ClienteMayorFacturacionDTO clienteDTO = new ClienteMayorFacturacionDTO(nombre, facturacion);
                listado.add(clienteDTO);
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
    
    public void insertCliente(Cliente cliente){
        String query = "INSERT INTO Cliente (idCliente,nombre,email) VALUES (?,?,?)";
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, cliente.getIdCliente()); // idCliente
            ps.setString(2, cliente.getNombre()); // nombre
            ps.setString(3, cliente.getEmail()); // email
            ps.executeUpdate();
            System.out.println("Cliente insertado exitosamente.");
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
    
    public void updateCliente(Cliente cliente){
        String query = "UPDATE Cliente SET nombre = ?, email = ? WHERE idCliente = ?";
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, cliente.getNombre()); // nombre
            ps.setString(2, cliente.getEmail()); // email
            ps.setInt(3, cliente.getIdCliente()); // idCliente
            ps.executeUpdate();
            System.out.println("Cliente actualizado exitosamente.");
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
    
    public Boolean deleteCliente(Integer id){
        String query = "DELETE FROM Cliente WHERE idCliente = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id); // idCliente
            ps.executeUpdate();
            System.out.println("Cliente eliminado exitosamente.");
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
