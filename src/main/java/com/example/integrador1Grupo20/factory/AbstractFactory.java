package com.example.integrador1Grupo20.factory;


import com.example.integrador1Grupo20.dao.ClienteDAO;
import com.example.integrador1Grupo20.dao.FacturaDAO;
import com.example.integrador1Grupo20.dao.FacturaProductoDAO;
import com.example.integrador1Grupo20.dao.ProductoDAO;

public abstract class AbstractFactory {
    public static final int MYSQL_JDBC = 1;
    public static final int DERBY_JDBC = 2;
    public abstract ClienteDAO getClienteDAO();
    public abstract ProductoDAO getProductoDAO();
    public abstract FacturaDAO getFacturaDAO();
    public abstract FacturaProductoDAO getFacturaProductoDAO();
    public static AbstractFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC : {
                return MySQLDAOFactory.getInstance();
            }
            case DERBY_JDBC: return null;
            default: return null;
        }
    }

}
