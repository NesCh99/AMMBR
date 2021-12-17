package Modelo.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Modelo.Imagen;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;

public class ImagenDaoImpl implements ImagenDao{
	 ConexionDB conn;
	 public ImagenDaoImpl() {}

	@Override
	public List<Imagen> list() {
		// TODO Auto-generated method stub
		
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Imagen ");
        
        List<Imagen> list  = new ArrayList<>();
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
            	Imagen Imagen  = new Imagen();
            	Imagen.setIdHospedaje(rs.getString("idHospedaje"));
            	Imagen.setImagen(rs.getString("imagen"));
       
         
                list.add(Imagen);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        
		return list;
	}

	@Override
	public Imagen edit(String idHospedaje) {
		
		  this.conn = FactoryConexionDB.open();
		  Imagen Imagen = new Imagen();
		  
		  StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
	       sql.append("SELECT * FROM Imagen WHERE idHospedaje = ").append(idHospedaje);   //cadena de consulta
	        
	       try {
	            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

	            while (rs.next()){   
	            	Imagen.setIdHospedaje(rs.getString("idHospedaje"));
	            	Imagen.setImagen(rs.getString("imagen"));
	               
	            }
	        } catch (Exception e) {
	            
	        } finally {
	            this.conn.close();          //cierra la conexion
	        }
	                  //devuelve el objeto creado
		// TODO Auto-generated method stub
		return Imagen;
	}

	@Override
	public boolean save(Imagen Imagen) {
		
		// TODO Auto-generated method stub
		this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {/*
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO Imagen (idHospedaje, imagen) VALUES ('").append(Imagen.getIdHospedaje());
                sql.append("', '").append(Imagen.getImagen()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      *///ejecuta la query
        	
        	
        	if("".equals(Imagen.getIdHospedaje())){
        		 StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                 sql.append("INSERT INTO Imagen (idHospedaje, imagen) VALUES ('").append(Imagen.getIdHospedaje());
                 sql.append("', '").append(Imagen.getImagen()).append("')");      //crear la cadena de conexion
                 this.conn.execute(sql.toString());   
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE Imagen SET idHospedaje = ").append(Imagen.getIdHospedaje());
                sql.append(", imagen = '").append(Imagen.getImagen()).append(" WHERE idHospedaje = ").append(Imagen.getIdHospedaje());      //crear la cadena de conexion
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
	public boolean delete(String idHospedaje) {
		boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM Imagen WHERE idHospedaje = ").append(idHospedaje);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
	}

}
