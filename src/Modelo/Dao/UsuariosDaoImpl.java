
package Modelo.Dao;

import Modelo.Usuarios;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDaoImpl implements UsuariosDao {
    ConexionDB conn;
    
    public UsuariosDaoImpl(){}

    @Override
    public List<Usuarios> list() {
        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Usuario ");  //construye la cadena de consulta

        List<Usuarios> list = new ArrayList<>(); 
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                Usuarios Usuarios = new Usuarios(); 
                Usuarios.setIdUsuario(rs.getString("idUsuario"));
                Usuarios.setTipoUsuario(rs.getInt("tipoUsuario"));
                Usuarios.setNombre(rs.getString("nombre"));
                Usuarios.setApellido(rs.getString("apellido"));
                Usuarios.setEmail(rs.getString("email"));
                Usuarios.setContrasena(rs.getString("contrasena"));
                Usuarios.setCelular(rs.getString("celular"));
                Usuarios.setFoto(rs.getString("foto"));
         
                list.add(Usuarios);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }

    @Override
    public Usuarios edit(String idUsuario) {
        this.conn = FactoryConexionDB.open();
        Usuarios Usuarios = new Usuarios();
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM usuarios WHERE IDUSUARIO = '").append(idUsuario);   //cadena de consulta
        sql.append("'");
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                Usuarios.setIdUsuario(rs.getString("IDUSUARIO"));
                Usuarios.setTipoUsuario(rs.getInt("TIPOUSUARIO"));
                Usuarios.setNombre(rs.getString("NOMBRE"));
                Usuarios.setApellido(rs.getString("APELLIDO"));
                Usuarios.setEmail(rs.getString("EMAIL"));
                Usuarios.setContrasena(rs.getString("CONTRASEÑA"));
                Usuarios.setCelular(rs.getString("CELULAR"));
                Usuarios.setFoto(rs.getString("FOTO"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return Usuarios;             //devuelve el objeto creado
    }

    @Override
    public boolean save(Usuarios Usuarios) {
        this.conn = FactoryConexionDB.open();
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            boolean find = false;
                StringBuilder sqls = new StringBuilder();   //para crear la sentencia sql
            sqls.append("SELECT IDUSUARIO FROM usuarios WHERE IDUSUARIO = '").append(Usuarios.getIdUsuario());  //construye la cadena de consulta
            sqls.append("'");
            ResultSet rs = this.conn.query(sqls.toString());  //ejecuta la consulta
        
            find = rs.next();
            
                if(find==false){
                    
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO Usuarios (IDUSUARIO, TIPOUSUARIO, NOMBRE, APELLIDO, EMAIL, CONTRASENA, CELULAR, FOTO) VALUES ('").append(Usuarios.getIdUsuario());
                sql.append("', '").append(Usuarios.getTipoUsuario());  
                sql.append("', '").append(Usuarios.getNombre());  
                sql.append("', '").append(Usuarios.getApellido());  
                sql.append("', '").append(Usuarios.getEmail());  
                sql.append("', '").append(Usuarios.getContrasena());  
                sql.append("', '").append(Usuarios.getCelular());  
                sql.append("', '").append(Usuarios.getFoto()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            }else{
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                
                sql.append("UPDATE usuarios SET NOMBRE = '").append(Usuarios.getNombre());
                sql.append("', APELLIDO = '").append(Usuarios.getApellido());
                sql.append("', EMAIL = '").append(Usuarios.getEmail());
                sql.append("', CONTRASENA = '").append(Usuarios.getContrasena());
                sql.append("', CELULAR = '").append(Usuarios.getCelular());
                sql.append("', FOTO = '").append(Usuarios.getFoto()).append("' WHERE IDUSUARIO = '").append(Usuarios.getIdUsuario()); 
                sql.append("'");//crear la cadena de conexion
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
            sql.append("DELETE FROM usuarios WHERE IDUSUARIO = '").append(idUsuario);    //crea la sentencia de borrado
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
    public boolean search(String idUsuario) {
        boolean find = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexionDB.open();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT IDUSUARIO FROM usuarios WHERE IDUSUARIO = '").append(idUsuario);  //construye la cadena de consulta
        sql.append("'");            
        try{
            
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
        
            find = rs.next();
            
        } catch (SQLException e) {
            
        } finally {
           this.conn.close();      //cierra la conexion
        }        
        return find;                              //devuelve el valor de la bandera
    }
}
