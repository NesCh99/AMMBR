/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.SitioHospedaje;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public class SitioHospedajeDaoImpl implements SitioHospedajeDao {

    ConexionDB conn;

    public SitioHospedajeDaoImpl() {
    }

    @Override
    public List<SitioHospedaje> list() {
        this.conn = FactoryConexionDB.open();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM sitiohospedaje ");  //construye la cadena de consulta

        List<SitioHospedaje> list = new ArrayList<>();

        try {
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()) {  //mientras haya registros en la tabla
                SitioHospedaje SitioHospedaje = new SitioHospedaje();
                SitioHospedaje.setIdHospedaje(rs.getString("IDHOSPEDAJE"));
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
                SitioHospedaje.setCat_Hotel(rs.getInt("CAT_HOTEL"));
                SitioHospedaje.setCat_Hostal(rs.getInt("CAT_HOSTAL"));
                SitioHospedaje.setCat_Hosteria(rs.getInt("CAT_HOSTERIA"));

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

            while (rs.next()) {          //mientras haya registros cargados en el reseltset              
                SitioHospedaje.setIdHospedaje(rs.getString("idHospedaje"));
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
            boolean find = false;
            StringBuilder sqls = new StringBuilder();   //para crear la sentencia sql
            sqls.append("SELECT IDHOSPEDAJE FROM sitiohospedaje WHERE IDHOSPEDAJE = '").append(SitioHospedaje.getIdHospedaje());  //construye la cadena de consulta
            sqls.append("'");
            ResultSet rs = this.conn.query(sqls.toString());  //ejecuta la consulta

            find = rs.next();

            if (find == false) {
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO sitiohospedaje (IDHOSPEDAJE, NOMBRE, LATITUD, LONGITUD,"
                        + "DESCRIPCION, TELEFONO, CELULAR, SITIOWEBURL, FANPAGEURL, "
                        + "WHATSAPPURL,PAGOEFECTIVO , PAGOELECTRONICO, PAGOTARJETA, "
                        + "CAT_HOTEL, CAT_HOSTAL, CAT_HOSTERIA) VALUES ('").append(SitioHospedaje.getIdHospedaje());
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
                sql.append("', '").append(SitioHospedaje.getPagoTarjeta());
                sql.append("', '").append(SitioHospedaje.getCat_Hotel());
                sql.append("', '").append(SitioHospedaje.getCat_Hostal());
                sql.append("', '").append(SitioHospedaje.getCat_Hosteria()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            } else {
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE sitiohospedaje SET NOMBRE = '").append(SitioHospedaje.getNombre());
                sql.append("', LATITUD = '").append(SitioHospedaje.getLatitud());
                sql.append("', LONGITUD = '").append(SitioHospedaje.getLongitud());
                sql.append("', DESCRIPCION = '").append(SitioHospedaje.getDescripcion());
                sql.append("', TELEFONO = '").append(SitioHospedaje.getTelefono());
                sql.append("', CELULAR = '").append(SitioHospedaje.getCelular());
                sql.append("', SITIOWEBURL = '").append(SitioHospedaje.getSitioWebURL());
                sql.append("', FANPAGEURL = '").append(SitioHospedaje.getFanPageURL());
                sql.append("', WHATSAPPURL = '").append(SitioHospedaje.getWhatsappURL());
                sql.append("', PAGOEFECTIVO = '").append(SitioHospedaje.getPagoEfectivo());
                sql.append("', PAGOELECTRONICO = '").append(SitioHospedaje.getPagoElectronico());
                sql.append("', PAGOTARJETA = '").append(SitioHospedaje.getPagoTarjeta());
                sql.append("', CAT_HOTEL = '").append(SitioHospedaje.getCat_Hotel());
                sql.append("', CAT_HOSTAL = '").append(SitioHospedaje.getCat_Hostal());
                sql.append("', CAT_HOSTERIA = '").append(SitioHospedaje.getCat_Hosteria()).append("' WHERE IDHOSPEDAJE= '").append(SitioHospedaje.getIdHospedaje());      //crear la cadena de conexion
                sql.append("'");
                this.conn.execute(sql.toString());      //ejecuta la query 
            }

            save = true;                                //cambia estado de bandera
        } catch (Exception e) {

        } finally {
            this.conn.close();      //cerrar la conexion
        }
        return save;
    }

    @Override
    public boolean delete(String idSitioHospedaje) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try {
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM sitiohospedaje WHERE IDHOSPEDAJE = '").append(idSitioHospedaje);    //crea la sentencia de borrado
            sql.append("'");
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {

        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }

    @Override
    public boolean search(String idSitioHospedaje) {
        boolean find = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT IDHOSPEDAJE FROM sitiohospedaje  WHERE IDHOSPEDAJE = '").append(idSitioHospedaje);  //construye la cadena de consulta
        sql.append("'");
        try {

            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta

            find = rs.next();

        } catch (SQLException e) {

        } finally {
            this.conn.close();      //cierra la conexion
        }
        return find;
    }

    @Override
    public List<SitioHospedaje> searchName(String nombre) {
        this.conn = FactoryConexionDB.open();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM sitiohospedaje  WHERE NOMBRE = '").append(nombre);  //construye la cadena de consulta
        sql.append("'");
        List<SitioHospedaje> list = new ArrayList<>();
        try {

            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta

            while (rs.next()) {  //mientras haya registros en la tabla
                SitioHospedaje SitioHospedaje = new SitioHospedaje();
                SitioHospedaje.setIdHospedaje(rs.getString("IDHOSPEDAJE"));
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
                SitioHospedaje.setCat_Hotel(rs.getInt("CAT_HOTEL"));
                SitioHospedaje.setCat_Hostal(rs.getInt("CAT_HOSTAL"));
                SitioHospedaje.setCat_Hosteria(rs.getInt("CAT_HOSTERIA"));

                list.add(SitioHospedaje);     //añade el objeto temporal en la lista
            }

        } catch (SQLException e) {

        } finally {
            this.conn.close();      //cierra la conexion
        }
        return list;
    }

}
