package com.example.integrador1Grupo20;

import com.example.integrador1Grupo20.dao.ClienteDAO;
import com.example.integrador1Grupo20.dao.FacturaProductoDAO;
import com.example.integrador1Grupo20.dao.ProductoDAO;
import com.example.integrador1Grupo20.entities.Factura_Producto;
import com.example.integrador1Grupo20.entities.Producto;
import com.example.integrador1Grupo20.factory.AbstractFactory;
import com.example.integrador1Grupo20.utils.HelperMySQL;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        //HelperMySQL dbMySQL = new HelperMySQL();
        //dbMySQL.dropTables();
        //dbMySQL.createTables();
        //dbMySQL.populateDB();
        //dbMySQL.closeConnection();

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





        System.out.println();
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");
        System.out.println("Listado de clientes ordenados por mayor facturación");

        ClienteDAO clienteDAO = chosenFactory.getClienteDAO();
        System.out.println(clienteDAO.getClientesMayorFacturacion());
        /*
        DireccionDAO direccion = chosenFactory.getDireccionDAO();
        PersonaDAO persona = chosenFactory.getPersonaDAO();


        System.out.println("Busco una Persona por id: ");
        Persona personaById = persona.find(2);
        System.out.println(personaById);
        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");
        System.out.println("Lista de direcciones: ");
        List<Direccion> listadoDirecciones = direccion.selectList();
        System.out.println(listadoDirecciones);
        List<Direccion> listadoDirecciones = direccion.selectList();
        for (Direccion dir : listadoDirecciones) {
            System.out.println(dir);
        }

        System.out.println("////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////");

        Persona p = new Persona(6,"Sergio",50,2);
        persona.insertPersona(p);

        PersonaDTO personaDTO = persona.findPersonaDTO(2);
        System.out.println(personaDTO);
*/
    }
}
