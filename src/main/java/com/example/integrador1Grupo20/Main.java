package com.example.integrador1Grupo20;

import com.example.integrador1Grupo20.dao.ClienteDAO;
import com.example.integrador1Grupo20.dao.FacturaProductoDAO;
import com.example.integrador1Grupo20.dao.ProductoDAO;
import com.example.integrador1Grupo20.entities.Cliente;
import com.example.integrador1Grupo20.entities.Factura_Producto;
import com.example.integrador1Grupo20.entities.Producto;
import com.example.integrador1Grupo20.factory.AbstractFactory;
import com.example.integrador1Grupo20.utils.HelperMySQL;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
//        HelperMySQL dbMySQL = new HelperMySQL();
//        dbMySQL.dropTables();
//        dbMySQL.createTables();
//        dbMySQL.populateDB();
//        dbMySQL.closeConnection();

        AbstractFactory chosenFactory = AbstractFactory.getDAOFactory(1);
        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////  CONSIGNA 3  ////////////////////////");
        System.out.println("Producto mayor recaudación: ");

        ProductoDAO productoDAO = chosenFactory.getProductoDAO();
        System.out.println(productoDAO.productoMasRecaudo());


        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////  CONSIGNA 4  ////////////////////////");
        System.out.println("Listado de clientes ordenados por mayor facturación");

        ClienteDAO clienteDAO = chosenFactory.getClienteDAO();
        System.out.println(clienteDAO.getClientesMayorFacturacion());

        /*

        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");
        System.out.println("CRUD de producto ");

        System.out.println(productoDAO.findProductoDTO(1));
        System.out.println(productoDAO.getProductos());

        Producto p1 = new Producto(1001,"ProductoPrueba", 20);
        productoDAO.insertProducto(p1);
        System.out.println(productoDAO.findProductoDTO(1001));


        p1.setNombre("ProductoPrueba2");
        productoDAO.updateProducto(p1);
        System.out.println(productoDAO.findProductoDTO(1001));

        productoDAO.deleteProducto(1001);
        System.out.println(productoDAO.findProductoDTO(1001));

        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");
        System.out.println("dao de factura-producto ");

        FacturaProductoDAO facturaProductoDAO = chosenFactory.getFacturaProductoDAO();

        Factura_Producto fp1 = new Factura_Producto(1000,1,500);
        facturaProductoDAO.insertFacturaProducto(fp1);

        fp1.setCantidad(600);
        facturaProductoDAO.updateFacturaProducto(fp1);

        facturaProductoDAO.deleteFacturaProducto(1000,1);






        Cliente cliente = new Cliente(500,"Pablo", "pablito@gmail.com");
        clienteDAO.insertCliente(cliente);

        cliente.setNombre("Gianluca");
        clienteDAO.updateCliente(cliente);

         */
    }
}
