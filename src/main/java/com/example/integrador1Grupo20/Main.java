package com.example.integrador1Grupo20;

import com.example.integrador1Grupo20.dao.ClienteDAO;
import com.example.integrador1Grupo20.dao.ProductoDAO;
import com.example.integrador1Grupo20.factory.AbstractFactory;
import com.example.integrador1Grupo20.utils.HelperMySQL;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        HelperMySQL dbMySQL = new HelperMySQL();
        dbMySQL.dropTables();
        dbMySQL.createTables();
        dbMySQL.populateDB();
        dbMySQL.closeConnection();

        AbstractFactory chosenFactory = AbstractFactory.getDAOFactory(1);
        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");
        System.out.println("Producto mayor recaudación: ");

        ProductoDAO productoDAO = chosenFactory.getProductoDAO();
        System.out.println(productoDAO.productoMasRecaudo());


        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");
        System.out.println("Listado de clientes ordenados por mayor facturación");

        ClienteDAO clienteDAO = chosenFactory.getClienteDAO();
        System.out.println(clienteDAO.getClientesMayorFacturacion());

//        Cliente cliente = new Cliente(500,"Pablo", "pablito@gmail.com");
//        clienteDAO.insertCliente(cliente);
//
//        cliente.setNombre("Gianluca");
//        clienteDAO.updateCliente(cliente);
    }
}
