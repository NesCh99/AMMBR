
package Modelo.Dao;

import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import Modelo.UsuarioHuesped;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioHuespedDaoImpl implements UsuarioHuespedDao {
    ConexionDB conn;
    
    public UsuarioHuespedDaoImpl(){}

    @Override
    public List<UsuarioHuesped> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM UsuarioHuesped ");  //construye la cadena de consulta

        List<UsuarioHuesped> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                UsuarioHuesped UsuarioHuesped = new UsuarioHuesped(); 
                UsuarioHuesped.setIdUsuario(rs.getString("idUsuario"));
                UsuarioHuesped.setGenero(rs.getInt("genero"));
                UsuarioHuesped.setEdad(rs.getInt("edad"));
                UsuarioHuesped.setPais(rs.getString("pais"));
               
         
                list.add(UsuarioHuesped);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public UsuarioHuesped edit(String idUsuario) {
        this.conn = FactoryConexionDB.open();
        UsuarioHuesped UsuarioHuesped = new UsuarioHuesped();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM UsuarioHuesped WHERE idUsuario = ").append(idUsuario);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                UsuarioHuesped.setIdUsuario(rs.getString("idUsuario"));
                UsuarioHuesped.setGenero(rs.getInt("genero"));
                UsuarioHuesped.setEdad(rs.getInt("edad"));
                UsuarioHuesped.setPais(rs.getString("pais"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return UsuarioHuesped;             //devuelve el objeto creado
    }

    @Override
    public boolean save(UsuarioHuesped UsuarioHuesped) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
                if("".equals(UsuarioHuesped.getIdUsuario())){
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO UsuarioHuesped (idUsuario, genero, edad, pais) VALUES ('").append(UsuarioHuesped.getIdUsuario());
                sql.append("', '").append(UsuarioHuesped.getGenero());  
                sql.append("', '").append(UsuarioHuesped.getEdad());    
                sql.append("', '").append(UsuarioHuesped.getPais()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE UsuarioHuesped SET idUsuario = ").append(UsuarioHuesped.getIdUsuario());
                sql.append("', genero = '").append(UsuarioHuesped.getGenero());
                sql.append("', edad = '").append(UsuarioHuesped.getEdad());
                sql.append(", pais = '").append(UsuarioHuesped.getPais()).append(" WHERE idUsuario = ").append(UsuarioHuesped.getIdUsuario());      //crear la cadena de conexion
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
    public boolean delete(String idUsuario) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM UsuarioHuesped WHERE idUsuario = ").append(idUsuario);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
}
