/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Negocio;

import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import Modelo.SitioHospedaje;
import java.sql.ResultSet;

/**
 *
 * @author Fabian
 */
public class generaCodigoHospedaje {

    ConexionDB conn;

    public String  codigoHospedaje() {
        this.conn = FactoryConexionDB.open();
        int number = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM SitioHospedaje ");  //construye la cadena de consulta
        try {
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()) {  //mientras haya registros en la tabla
                number = number + 1;

                //añade el objeto temporal en la lista
            }
        } catch (Exception e) {

        } finally {
            this.conn.close();      //cierra la conexion
        }
        
        //devuelve la lista generada

      StringBuffer codigo = new StringBuffer();
      codigo.append("HOTEL-");
      codigo.append(number+1);
  
        return codigo.toString();
    }
}
