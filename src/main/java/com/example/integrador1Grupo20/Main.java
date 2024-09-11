package com.example.integrador1Grupo20;

//import com.example.ejemplodaoypatrones.dao.DireccionDAO;
//import com.example.ejemplodaoypatrones.dao.PersonaDAO;
//import com.example.ejemplodaoypatrones.dto.PersonaDTO;
//import com.example.ejemplodaoypatrones.factory.AbstractFactory;
import com.example.integrador1Grupo20.dao.ClienteDAO;
import com.example.integrador1Grupo20.dao.ProductoDAO;
import com.example.integrador1Grupo20.entities.Cliente;
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

        Cliente cliente = new Cliente(500,"Pablo", "pablito@gmail.com");
        clienteDAO.insertCliente(cliente);

        cliente.setNombre("Gianluca");
        clienteDAO.updateCliente(cliente);

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
