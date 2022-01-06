
package Modelo.Dao;

import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import Modelo.UsuarioAdminHospedaje;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAdminHospedajeDaoImpl implements UsuarioAdminHospedajeDao {
    ConexionDB conn;
    
    public UsuarioAdminHospedajeDaoImpl(){}

    @Override
    public List<UsuarioAdminHospedaje> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM usuarioadminhospedaje ");  //construye la cadena de consulta

        List<UsuarioAdminHospedaje> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                UsuarioAdminHospedaje UsuarioAdminHospedaje = new UsuarioAdminHospedaje(); 
                UsuarioAdminHospedaje.setIdUsuario(rs.getString("IDUSUARIO"));
                UsuarioAdminHospedaje.setIdHospedaje(rs.getString("IDHOSPEDAJE"));
               
         
                list.add(UsuarioAdminHospedaje);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public UsuarioAdminHospedaje edit(String idUsuario) {
        this.conn = FactoryConexionDB.open();
        UsuarioAdminHospedaje UsuarioAdminHospedaje = new UsuarioAdminHospedaje();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM usuarioadminhospedaje WHERE IDUSUARIO = '").append(idUsuario);   //cadena de consulta
        sql.append("'");
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                UsuarioAdminHospedaje.setIdUsuario(rs.getString("IDUSUARIO"));
                UsuarioAdminHospedaje.setIdHospedaje(rs.getString("IDHOSPEDAJE"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return UsuarioAdminHospedaje;             //devuelve el objeto creado
    }

    @Override
    public boolean save(UsuarioAdminHospedaje UsuarioAdminHospedaje) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            boolean find = false;
                StringBuilder sqls = new StringBuilder();   //para crear la sentencia sql
                sqls.append("SELECT IDUSUARIO FROM usuarioadminhospedaje WHERE IDUSUARIO = '").append(UsuarioAdminHospedaje.getIdUsuario());  //construye la cadena de consulta
                sqls.append("'");
                ResultSet rs = this.conn.query(sqls.toString());  //ejecuta la consulta
        
            find = rs.next();
            
                if(find==false){
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO usuarioadminhospedaje (IDUSUARIO, IDHOSPEDAJE) VALUES ('").append(UsuarioAdminHospedaje.getIdUsuario());   
                sql.append("', '").append(UsuarioAdminHospedaje.getIdHospedaje()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE usuarioadminhospedaje SET IDUSUARIO = '").append(UsuarioAdminHospedaje.getIdUsuario());
                sql.append("', IDHOSPEDAJE = '").append(UsuarioAdminHospedaje.getIdHospedaje()).append("' WHERE IDUSUARIO = '").append(UsuarioAdminHospedaje.getIdUsuario());      //crear la cadena de conexion
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
    public boolean delete(String idUsuario) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM usuarioadminhospedaje WHERE IDUSUARIO = '").append(idUsuario);    //crea la sentencia de borrado
            sql.append("'");
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
    
}
