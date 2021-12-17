/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nes Ch
 */
public class ConexionMySQL extends ConexionDB {

    public ConexionMySQL(String[] params) {  //recibve un array de string parametros
        this.params = params;    //el atributo params de superclase recibe el parametro del constructor
        this.open();        //llama al metodo que se implementa abajo
    }
     //private static Connection connection;
    private static final String driver="com.mysql.jdbc.Driver";
    @Override
    public Connection open() {   //implementacion del metodo abstracto que abre bd
        try{
            Class.forName(driver);
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.params[0], this.params[1], this.params[2]);  //subindice 0: nombre bd. paremtro 1: usr; parametro 2: clave.. llega en constructor
            if(connection!=null){
                System.out.println("Conexión establecida");
            }
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion " + e);
        }
        return this.connection;     //devuelve la conexion q es atributo declarada en superclase
    }
}
