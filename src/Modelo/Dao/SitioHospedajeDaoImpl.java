/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.SitioHospedaje;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public class SitioHospedajeDaoImpl implements SitioHospedajeDao {

    ConexionDB conn;
    
    public SitioHospedajeDaoImpl(){}
    @Override
    public List<SitioHospedaje> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM sitiohospedaje ");  //construye la cadena de consulta

        List<SitioHospedaje> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                SitioHospedaje SitioHospedaje = new SitioHospedaje(); 
                SitioHospedaje.setIdHospedaje(rs.getString("IDHOSPEDAJE"));
                SitioHospedaje.setIdCategoriaHospedaje(rs.getString("IDCATEGORIAHOSPEDAJE"));
                SitioHospedaje.setNombre(rs.getString("NOMBRE"));
                SitioHospedaje.setLatitud(rs.getString("LATITUD"));
                SitioHospedaje.setLongitud(rs.getString("LONGITUD"));
                SitioHospedaje.setDescripcion(rs.getString("DESCRIPCION"));
                SitioHospedaje.setTelefono(rs.getString("TELEFONO"));
                SitioHospedaje.setCelular(rs.getString("CELULAR"));
                SitioHospedaje.setSitioWebURL(rs.getString("SITIOWEBURL"));
                SitioHospedaje.setFanPageURL(rs.getString("FANPAGEURL"));
                SitioHospedaje.setWhatsappURL(rs.getString("WHATSAPPURL"));
                SitioHospedaje.setPagoEfectivo(rs.getInt("PAGOEFECTIVO"));
                SitioHospedaje.setPagoElectronico(rs.getInt("PAGOELECTRONICO"));
                SitioHospedaje.setPagoTarjeta(rs.getInt("PAGOTARJETA"));
         
                list.add(SitioHospedaje);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public SitioHospedaje edit(String idSitioHospedaje) {
        this.conn = FactoryConexionDB.open();
        SitioHospedaje SitioHospedaje = new SitioHospedaje();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM SitioHospedaje WHERE idHospedaje = ").append(idSitioHospedaje);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset              
                SitioHospedaje.setIdHospedaje(rs.getString("idHospedaje"));
                SitioHospedaje.setIdCategoriaHospedaje(rs.getString("idCategoriaHospedaje"));
                SitioHospedaje.setNombre(rs.getString("nombre"));
                SitioHospedaje.setLatitud(rs.getString("latitud"));
                SitioHospedaje.setLongitud(rs.getString("longitud"));
                SitioHospedaje.setDescripcion(rs.getString("descripcion"));
                SitioHospedaje.setTelefono(rs.getString("telefono"));
                SitioHospedaje.setCelular(rs.getString("celular"));
                SitioHospedaje.setSitioWebURL(rs.getString("sitioWebURL"));
                SitioHospedaje.setFanPageURL(rs.getString("fanpageURL"));
                SitioHospedaje.setWhatsappURL(rs.getString("whatsappURL"));
                SitioHospedaje.setPagoEfectivo(rs.getInt("pagoEfectivo"));
                SitioHospedaje.setPagoElectronico(rs.getInt("pagoElectronico"));
                SitioHospedaje.setPagoTarjeta(rs.getInt("pagoTarjeta"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return SitioHospedaje;             //devuelve el objeto creado
    }

    @Override
    public boolean save(SitioHospedaje SitioHospedaje) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            if("".equals(SitioHospedaje.getIdHospedaje())){
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO SitioHospedaje (idHospedaje, idCategoriaHospedaje, nombre, latitud, longitud,"
                        + "descripcion, telefono, celular, sitioWebURL, fanPageURL, "
                        + "whatsappURL, pagoEfectivo, pagoElectronico, pagoTarjeta) VALUES ('").append(SitioHospedaje.getIdHospedaje());
                sql.append("', '").append(SitioHospedaje.getIdCategoriaHospedaje());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getNombre());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getLatitud());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getLongitud());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getDescripcion());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getTelefono());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getCelular());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getSitioWebURL());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getFanPageURL());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getWhatsappURL());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getPagoEfectivo());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getPagoElectronico());      //crear la cadena de conexion
                sql.append("', '").append(SitioHospedaje.getPagoTarjeta()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            }else{
               StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE SitioHospedaje SET idHospedaje = ").append(SitioHospedaje.getIdHospedaje());
                sql.append(", idCategoriaHospedaje = '").append(SitioHospedaje.getIdCategoriaHospedaje());
                sql.append(", nombre = '").append(SitioHospedaje.getNombre());
                sql.append(", latitud = '").append(SitioHospedaje.getLatitud());
                sql.append(", longitud = '").append(SitioHospedaje.getLongitud());
                sql.append(", descripcion = '").append(SitioHospedaje.getDescripcion());
                sql.append(", telefono = '").append(SitioHospedaje.getTelefono());
                sql.append(", celular = '").append(SitioHospedaje.getCelular());
                sql.append(", sitioWeb = '").append(SitioHospedaje.getSitioWebURL());
                sql.append(", fanPageURL = '").append(SitioHospedaje.getFanPageURL());
                sql.append(", whatsappURL = '").append(SitioHospedaje.getWhatsappURL());
                sql.append(", pagoEfectivo = '").append(SitioHospedaje.getPagoEfectivo());
                sql.append(", pagoElectonico = '").append(SitioHospedaje.getPagoElectronico());                                
                sql.append(", pagoTarjeta = ").append(SitioHospedaje.getPagoTarjeta()).append(" WHERE idHospedaje = ").append(SitioHospedaje.getIdHospedaje());      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query 
            }
                
            
            save = true;                                //cambia estado de bandera
        } catch(Exception e){
            
        } finally {
           this.conn.close();      //cerrar la conexion
        }
        return save;
    }

    @Override
    public boolean delete(String idSitioHospedaje) {
         boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM SitioHospedaje WHERE idHospedaje = ").append(idSitioHospedaje);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
    
}
