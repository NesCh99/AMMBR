/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;


import Modelo.CategoriaHabitacion;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public class CategoriaHabitacionDaoImpl implements CategoriaHabitacionDao{

    ConexionDB conn;
    
    public CategoriaHabitacionDaoImpl(){}
    
    @Override
    public List<CategoriaHabitacion> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CategoriaHabitacion");  //construye la cadena de consulta

        List<CategoriaHabitacion> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                CategoriaHabitacion CategoriaHabitacion = new CategoriaHabitacion(); 
                CategoriaHabitacion.setIdCategoriaHabitacion(rs.getString("idCategoriaHabitacion"));
                CategoriaHabitacion.setNombre(rs.getString("nombre"));
         
                list.add(CategoriaHabitacion);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public CategoriaHabitacion edit(String idCategoriaHabitacion) {
        this.conn = FactoryConexionDB.open();
        CategoriaHabitacion CategoriaHabitacion = new CategoriaHabitacion();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM CategoriaHabitacion WHERE idCategoriaHabitacion = ").append(idCategoriaHabitacion);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                CategoriaHabitacion.setIdCategoriaHabitacion(rs.getString("idCategoriaHabitacion")); 
                CategoriaHabitacion.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return CategoriaHabitacion;             //devuelve el objeto creado
    }

    @Override
    public boolean save(CategoriaHabitacion CategoriaHabitacion) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            //if("".equals(CategoriaHabitacion.getIdCategoriaHabitacion())){
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO CategoriaHabitacion (idCategoriaHabitacion, nombre) VALUES ('").append(CategoriaHabitacion.getIdCategoriaHabitacion());
                sql.append("', '").append(CategoriaHabitacion.getNombre()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            /*}else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE CategoriaHabitacion SET idCategoriaHabitacion = ").append(CategoriaHabitacion.getIdCategoriaHabitacion());
                sql.append(", nombre = '").append(CategoriaHabitacion.getNombre()).append(" WHERE idCategoriaHabitacion = ").append(CategoriaHabitacion.getIdCategoriaHabitacion());      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query 
            }*/
            
            save = true;                                //cambia estado de bandera
        } catch(Exception e){
            
        } finally {
           this.conn.close();      //cerrar la conexion
        }
        return save;
    }

    @Override
    public boolean delete(String idCategoriaHabitacion) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM CategoriaHabitacion WHERE idCategoriaHabitacion = ").append(idCategoriaHabitacion);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
    
}
