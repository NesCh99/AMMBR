package Modelo.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Modelo.Imagen;
import Modelo.Opiniones;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;

public class OpinionesDaoImpl implements OpinionesDao{
    	ConexionDB conn;
	 public OpinionesDaoImpl() {}
	@Override
	
	
	public List<Opiniones> list() {
		// TODO Auto-generated method stub
// TODO Auto-generated method stub
		
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Opiniones ");
        
        List<Opiniones> list  = new ArrayList<>();
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
            	Opiniones Opiniones = new Opiniones();
            	Opiniones.setIdHospedaje(rs.getString("idHospedaje"));
            	Opiniones.setEstrellas(rs.getInt(1));
            	Opiniones.setComentario(rs.getString("comentario"));
                
               list.add(Opiniones);
         
                //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        
		return list;
	}

	@Override
	public Opiniones edit(String idHospedaje) {
		// TODO Auto-generated method stub

		  this.conn = FactoryConexionDB.open();
		  Opiniones Opiniones = new Opiniones();
		  
		  StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
	       sql.append("SELECT * FROM Opiniones WHERE idHospedaje = ").append(idHospedaje);   //cadena de consulta
	        
	       try {
	            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

	            while (rs.next()){ 
	            	Opiniones.setIdHospedaje(rs.getString("idHospedaje"));
	            	Opiniones.setEstrellas(rs.getInt(1));
	            	Opiniones.setComentario(rs.getString("comentario"));
	            	
	            	
	               
	            }
	        } catch (Exception e) {
	            
	        } finally {
	            this.conn.close();          //cierra la conexion
	        }
	                  //devuelve el objeto creado
		// TODO Auto-generated method stub
		return Opiniones;
	}

	@Override
	public boolean save(Opiniones Opiniones) {
		// TODO Auto-generated method stub
		this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {/*
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO Opiniones (idHospedaje, estrellas, comentario) VALUES ('").append(Opiniones.getIdHospedaje());
                sql.append("', '").append(Opiniones.getEstrellas()).append("')");      //crear la cadena de conexion
                sql.append("', '").append(Opiniones.getComentario()).append("')"); 
                this.conn.execute(sql.toString());      //ejecuta la query*/
        	if("".equals(Opiniones.getIdHospedaje())){
        		StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO Opiniones (IDHOSPEDAJE, ESTRELLAS, COMENTARIO, IDHUESPED) VALUES ('").append(Opiniones.getIdHospedaje());
                sql.append("', '").append(Opiniones.getEstrellas());      //crear la cadena de conexion
                sql.append("', '").append(Opiniones.getComentario());
                sql.append("', '").append(Opiniones.getIdHuesped()).append("')"); 
                this.conn.execute(sql.toString());      //ejecuta la query     //ejecuta la query
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE Opiniones SET idHospedaje = ").append(Opiniones.getIdHospedaje());
                sql.append(", comentario = '").append(Opiniones.getComentario()).append(" WHERE idHospedaje = ").append(Opiniones.getIdHospedaje());      //crear la cadena de conexion
                sql.append(", estrellas = '").append(Opiniones.getEstrellas()).append(" WHERE idHospedaje = ").append(Opiniones.getIdHospedaje());      //crear la cadena de conexion
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
            sql.append("DELETE FROM OPINIONES WHERE IDOPINION = ").append(idHospedaje);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
	}

}
