/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.CategoriaHospedaje;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public class CategoriaHospedajeDaoImpl implements CategoriaHospedajeDao{

    ConexionDB conn;
    
    public CategoriaHospedajeDaoImpl(){}
    @Override
    public List<CategoriaHospedaje> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CategoriaHospedaje ");  //construye la cadena de consulta

        List<CategoriaHospedaje> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                CategoriaHospedaje CategoriaHospedaje = new CategoriaHospedaje(); 
                CategoriaHospedaje.setIdCategoriaHospedaje(rs.getString("idCategoriaHospedaje"));
                CategoriaHospedaje.setNombre(rs.getString("nombre"));
         
                list.add(CategoriaHospedaje);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public CategoriaHospedaje edit(String idCategoriaHospedaje) {
        this.conn = FactoryConexionDB.open();
        CategoriaHospedaje CategoriaHospedaje = new CategoriaHospedaje();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM CategoriaHospedaje WHERE idCategoriaHospedaje = ").append(idCategoriaHospedaje);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                CategoriaHospedaje.setIdCategoriaHospedaje(rs.getString("idCategoriaHospedaje")); 
                CategoriaHospedaje.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return CategoriaHospedaje;             //devuelve el objeto creado
    }

    @Override
    public boolean save(CategoriaHospedaje CategoriaHospedaje) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            if("".equals(CategoriaHospedaje.getIdCategoriaHospedaje())){
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO CategoriaHospedaje (idCategoriaHospedaje, nombre) VALUES ('").append(CategoriaHospedaje.getIdCategoriaHospedaje());
                sql.append("', '").append(CategoriaHospedaje.getNombre()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query                
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE CategoriaHospedaje SET idHospedaje = ").append(CategoriaHospedaje.getIdCategoriaHospedaje());
                sql.append(", nombre = '").append(CategoriaHospedaje.getNombre()).append(" WHERE idCategoriaHospedaje = ").append(CategoriaHospedaje.getIdCategoriaHospedaje());      //crear la cadena de conexion
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
    public boolean delete(String idCategoriaHospedaje) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM CategoriaHospedaje WHERE idCategoriaHospedaje = ").append(idCategoriaHospedaje);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
    
}
