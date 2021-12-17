package Modelo.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Modelo.ServiciosExtra;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;

public class ServiciosExtraDaoImpl implements ServiciosExtraDao{
	  ConexionDB conn;
	 public ServiciosExtraDaoImpl() {}
	@Override
	public List<ServiciosExtra> list() {
		// TODO Auto-generated method stub
// TODO Auto-generated method stub
		
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ServiciosExtra ");
        
        List<ServiciosExtra> list  = new ArrayList<>();
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
            	ServiciosExtra ServiciosExtra = new ServiciosExtra();
            	ServiciosExtra.setIdHospedaje(rs.getString("idHospedaje"));
            	ServiciosExtra.setDescripcion(rs.getString("Descripcion"));
            
       
         
                list.add(ServiciosExtra);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        
		return list;
	}

	@Override
	public ServiciosExtra edit(String idHospedaje) {
		this.conn = FactoryConexionDB.open();
		ServiciosExtra ServiciosExtra = new ServiciosExtra();
		  
		  StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
	       sql.append("SELECT * FROM ServiciosExtra WHERE idHospedaje = ").append(idHospedaje);   //cadena de consulta
	        
	       try {
	            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

	            while (rs.next()){   
	            	
	            	ServiciosExtra.setIdHospedaje(rs.getString("idHospedaje"));
	            	ServiciosExtra.setDescripcion(rs.getString("Descripcion"));
	            	
	               
	            }
	        } catch (Exception e) {
	            
	        } finally {
	            this.conn.close();          //cierra la conexion
	        }
	                  //devuelve el objeto creado
		// TODO Auto-generated method stub
		return ServiciosExtra;
	}

	@Override
	public boolean save(ServiciosExtra ServiciosExtra) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				this.conn = FactoryConexionDB.open();
		        boolean save = true;        //bandera para indicar si se almacenaron los cambios
		        
		        try {/*
		                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
		                sql.append("INSERT INTO ServiciosExtra (idHospedaje, Descripcion) VALUES ('").append(ServiciosExtra.getIdHospedaje());
		                sql.append("', '").append(ServiciosExtra.getDescripcion()).append("')");      //crear la cadena de conexion
		                this.conn.execute(sql.toString());      //ejecuta la query*/
		        	if("".equals(ServiciosExtra.getIdHospedaje())){
		        		StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
		                sql.append("INSERT INTO ServiciosExtra (idHospedaje, Descripcion) VALUES ('").append(ServiciosExtra.getIdHospedaje());
		                sql.append("', '").append(ServiciosExtra.getDescripcion()).append("')");      //crear la cadena de conexion
		                this.conn.execute(sql.toString());    //ejecuta la query
		            }else{
		                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
		                sql.append("UPDATE ServiciosExtra SET idHospedaje = ").append(ServiciosExtra.getIdHospedaje());
		                sql.append(", Descripcion = '").append(ServiciosExtra.getDescripcion()).append(" WHERE idHospedaje = ").append(ServiciosExtra.getIdHospedaje());      //crear la cadena de conexion
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
		// TODO Auto-generated method stub
		boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM ServiciosExtra WHERE idHospedaje = ").append(idHospedaje);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;     
	}

}
