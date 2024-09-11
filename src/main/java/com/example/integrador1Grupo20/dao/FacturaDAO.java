package com.example.integrador1Grupo20.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.integrador1Grupo20.entities.Factura;

public class FacturaDAO {
    private Connection conn;

    public FacturaDAO(Connection conn) {
        this.conn = conn;
    }
	
	public void insertFactura(Factura factura){
		String query = "INSERT INTO Factura (idFactura, idCliente) VALUES (?,?) ";
		PreparedStatement ps = null;
		
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, factura.getIdFactura());
			ps.setInt(2, factura.getIdCliente());
			ps.executeUpdate();
			System.out.println("Factura ingresada exitosamente.");
		} catch(SQLException e){
			e.printStackTrace();
		}finally{
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
	
	public void updateFactura(Factura factura){
		String query = "UPDATE Factura SET idCliente = ? WHERE IdFactura =  ? ";
		PreparedStatement ps = null;
		
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, factura.getIdCliente());
			ps.setInt(2, factura.getIdFactura());
			ps.executeUpdate();
			System.out.println("La factura se actualizó exitosamente.");
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(ps != null){
					ps.close();
				}
				conn.commit();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public Boolean deleteFactura(Integer idFactura){
		String query = "DELETE FROM Factura WHERE idFactura = ? ";
		PreparedStatement ps = null;
		
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, idFactura);
			ps.executeUpdate();
			System.out.println("La factura fue eliminada exitosamente.");
			return true;
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally {
			try{
				if(ps != null) {
					ps.close();
				}
				conn.commit();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public Factura find(Integer pk) {
		String query = "SELECT f.idCliente " +
				"FROM Factura f " +
				"WHERE f.idFactura = ?";
		Factura facturaById = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, pk); // Establecer el parámetro en la consulta SQL
			rs = ps.executeQuery();
			if (rs.next()) { // Verificar si hay resultados
				int idCliente = rs.getInt("idCliente");

				// Crear una nueva instancia de Persona con los datos recuperados de la consulta
				facturaById = new Factura(pk, idCliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) {
					ps.close();
				}
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return facturaById;
	}


	public List<Factura> selectListFacturas() {
		String query = "SELECT * " +
				"FROM Factura ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Factura> listado = null;
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			// Crear una nueva instancia de Persona con los datos recuperados de la consulta
			listado = new ArrayList<Factura>();
			while (rs.next()) { // Verificar si hay resultados
				int idFactura = rs.getInt("idFactura");
				int idCliente = rs.getInt("idCliente");
				Factura factura = new Factura(idFactura, idCliente);
				listado.add(factura);
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
