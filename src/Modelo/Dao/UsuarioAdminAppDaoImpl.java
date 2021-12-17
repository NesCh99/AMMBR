
package Modelo.Dao;

import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import Modelo.UsuarioAdminApp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAdminAppDaoImpl implements UsuarioAdminAppDao {
        ConexionDB conn;
    
    public UsuarioAdminAppDaoImpl(){}

    @Override
    public List<UsuarioAdminApp> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM UsuarioAdminApp ");  //construye la cadena de consulta

        List<UsuarioAdminApp> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                UsuarioAdminApp UsuarioAdminApp = new UsuarioAdminApp(); 
                UsuarioAdminApp.setIdUsuario(rs.getString("idUsuario"));
  
                list.add(UsuarioAdminApp);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public UsuarioAdminApp edit(String idUsuario) {
        this.conn = FactoryConexionDB.open();
        UsuarioAdminApp UsuarioAdminApp = new UsuarioAdminApp();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM UsuarioAdminApp WHERE idUsuario = ").append(idUsuario);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                UsuarioAdminApp.setIdUsuario(rs.getString("idUsuario"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return UsuarioAdminApp;             //devuelve el objeto creado
    }

    @Override
    public boolean save(UsuarioAdminApp UsuarioAdminApp) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
                if("".equals(UsuarioAdminApp.getIdUsuario())){
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO UsuarioAdminApp (idUsuario) VALUES ('").append(UsuarioAdminApp.getIdUsuario()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE UsuarioAdminApp SET idUsuario = ").append(UsuarioAdminApp.getIdUsuario()).append(" WHERE idUsuario = ").append(UsuarioAdminApp.getIdUsuario());
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
            sql.append("DELETE FROM UsuarioAdminApp WHERE idUsuario = ").append(idUsuario);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
}
