
package Modelo.Dao;

import Modelo.Usuarios;
import Modelo.Factory.ConexionDB;
import Modelo.Factory.FactoryConexionDB;
import java.sql.ResultSet;
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
        sql.append("SELECT * FROM Usuarios WHERE idUsuario = ").append(idUsuario);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                Usuarios.setIdUsuario(rs.getString("idUsuario"));
                Usuarios.setTipoUsuario(rs.getInt("tipoUsuario"));
                Usuarios.setNombre(rs.getString("nombre"));
                Usuarios.setApellido(rs.getString("apellido"));
                Usuarios.setEmail(rs.getString("email"));
                Usuarios.setContrasena(rs.getString("contrasena"));
                Usuarios.setCelular(rs.getString("celular"));
                Usuarios.setFoto(rs.getString("foto"));
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
                if("".equals(Usuarios.getIdUsuario())){
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO Usuarios (idUsuario, tipoUsuario, nombre, apellido, email, contrasena, celular, foto) VALUES ('").append(Usuarios.getIdUsuario());
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
                sql.append("UPDATE Usuarios SET idUsuario = ").append(Usuarios.getIdUsuario());
                sql.append("', tipoUsuario = '").append(Usuarios.getTipoUsuario());
                sql.append("', nombre = '").append(Usuarios.getNombre());
                sql.append("', apellido = '").append(Usuarios.getApellido());
                sql.append("', email = '").append(Usuarios.getEmail());
                sql.append("', contrasena = '").append(Usuarios.getContrasena());
                sql.append("', celular = '").append(Usuarios.getCelular());
                sql.append(", foto = '").append(Usuarios.getFoto()).append(" WHERE idUsuario = ").append(Usuarios.getIdUsuario());      //crear la cadena de conexion
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
            sql.append("DELETE FROM Usuarios WHERE idUsuario = ").append(idUsuario);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
}
