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

    public String  codigoHospedaje(int tipoHospedaje) {
        this.conn = FactoryConexionDB.open();
        int number = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM sitiohospedaje ");  //construye la cadena de consulta
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
      if(tipoHospedaje == 1){
          codigo.append("HOT-");
      }else if (tipoHospedaje == 2){
          codigo.append("HOS-");
      }else{
          codigo.append("HST-");
      }
      if(number < 10){
          codigo.append("00");
          codigo.append(number+1);    
      }else if(number >= 10 && number <100){
          codigo.append("0");
          codigo.append(number+1);
      }else{          
          codigo.append(number+1);
      }
  
        return codigo.toString();
    }
}
