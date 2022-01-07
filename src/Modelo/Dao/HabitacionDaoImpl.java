/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import Modelo.Habitacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public class HabitacionDaoImpl implements HabitacionDao{

    ConexionDB conn;
    @Override
    public List<Habitacion> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Habitacion ");  //construye la cadena de consulta

        List<Habitacion> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                Habitacion Habitacion = new Habitacion(); 
                Habitacion.setIdHabitacion(rs.getString("idHabitacion"));
                Habitacion.setCategoriaHabitacion(rs.getString("idCategoriaHabitacion"));
                Habitacion.setIdHospedaje(rs.getString("idHospedaje"));
                Habitacion.setNumeroCamas(rs.getInt("numeroCamas"));
                Habitacion.setDescripcion(rs.getString("descripcion"));
                Habitacion.setPrecio(rs.getDouble("precio"));
                
         
                list.add(Habitacion);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public Habitacion edit(String idHabitacion) {
        this.conn = FactoryConexionDB.open();
        Habitacion Habitacion = new Habitacion();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM Habitacion WHERE idHabitacion = ").append(idHabitacion);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset              
                Habitacion.setIdHabitacion(rs.getString("idHabitacion"));
                Habitacion.setCategoriaHabitacion(rs.getString("idCategoriaHabitacion"));
                Habitacion.setIdHospedaje(rs.getString("idHospedaje"));
                Habitacion.setNumeroCamas(rs.getInt("numeroCamas"));
                Habitacion.setDescripcion(rs.getString("descripcion"));
                Habitacion.setPrecio(rs.getDouble("precio"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return Habitacion;             //devuelve el objeto creado
    }

    @Override
    public boolean save(Habitacion Habitacion) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            boolean find = false;
            StringBuilder sqls = new StringBuilder();   //para crear la sentencia sql
            sqls.append("SELECT IDHABITACION FROM habitacion WHERE IDHABITACION = '").append(Habitacion.getIdHabitacion());  //construye la cadena de consulta
            sqls.append("'");
            ResultSet rs = this.conn.query(sqls.toString());  //ejecuta la consulta

            find = rs.next();

            if (find == false) {
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO habitacion (IDHABITACION, CategoriaHabitacion, IDHOSPEDAJE, NUMEROCAMAS, DESCRIPCION, "
                        + "PRECIO) VALUES ('").append(Habitacion.getIdHabitacion());                
                sql.append("', '").append(Habitacion.getCategoriaHabitacion());
                sql.append("', '").append(Habitacion.getIdHospedaje());
                sql.append("', '").append(Habitacion.getNumeroCamas());
                sql.append("', '").append(Habitacion.getDescripcion());
                sql.append("', '").append(Habitacion.getPrecio()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query                
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE habitacion SET CATEGORIAHABITACION = '").append(Habitacion.getCategoriaHabitacion());
                sql.append("', NUMEROCAMAS= '").append(Habitacion.getNumeroCamas());
                sql.append("', DESCRIPCION = '").append(Habitacion.getDescripcion());
                sql.append("', PRECIO = '").append(Habitacion.getPrecio()).append(" WHERE IDHABITACION = ").append(Habitacion.getIdHabitacion());      //crear la cadena de conexion
                sql.append("'");
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
    public boolean delete(String idHabitacion) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM habitacion WHERE IDHABITACION = ").append(idHabitacion);    //crea la sentencia de borrado
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
    public boolean search(String idHabitacion) {
        boolean find = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT IDHABITACION FROM habitacion  WHERE IDHABITACION = '").append(idHabitacion);  //construye la cadena de consulta
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
    
}
