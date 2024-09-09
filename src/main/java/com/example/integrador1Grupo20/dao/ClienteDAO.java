package com.example.integrador1Grupo20.dao;

import com.example.integrador1Grupo20.dto.ClienteDTO;
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

    public List<ClienteDTO> getClientesMayorFacturacion() {
        String query = "SELECT c.nombre ,SUM(fp.cantidad * P.valor) facturacion, F.idCliente " +
                       "FROM Factura_Producto fp " +
                       "JOIN Producto P ON fp.idProducto = P.idProducto " +
                       "JOIN Factura F ON fp.idFactura = F.idFactura " +
                       "JOIN Cliente c ON F.idCliente = c.idCliente " +
                       "GROUP BY F.idCliente " +
                       "ORDER BY facturacion DESC";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClienteDTO> listado = new ArrayList<ClienteDTO>();;
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            // Crear una nueva instancia de Cliente con los datos recuperados de la consulta
            while (rs.next()) { // Verificar si hay resultados
                String nombre = rs.getString("nombre");
                Float facturacion = rs.getFloat("facturacion");

                ClienteDTO clienteDTO = new ClienteDTO(nombre, facturacion);
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


}
