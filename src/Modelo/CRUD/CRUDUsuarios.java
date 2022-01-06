/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.UsuariosDao;
import Modelo.Dao.UsuariosDaoImpl;
import Modelo.Negocio.Seguridad.ControlIngresoDatos;
import Modelo.Negocio.Seguridad.Encriptacion;
import Modelo.Usuarios;

/**
 *
 * @author Nes Ch
 */
public class CRUDUsuarios {
    UsuariosDao UsuariosDao = new UsuariosDaoImpl();
    Usuarios Usuarios = new Usuarios();
    Encriptacion encriptacion = new Encriptacion();
        
    
    public void nuevoUsuario(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular, int tipo){
                Usuarios.setIdUsuario(idusuario.toUpperCase());
                Usuarios.setNombre(nombre.toUpperCase());
                Usuarios.setApellido(apellido.toUpperCase());
                Usuarios.setEmail(email.toLowerCase());                
                Usuarios.setContrasena(encriptacion.encode(nombre, contraseña));
                Usuarios.setCelular(celular);
                Usuarios.setFoto(foto);
                Usuarios.setTipoUsuario(tipo);
                UsuariosDao.save(Usuarios);
        
    }
    
    public void editarUsuario(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular){
        Usuarios.setIdUsuario(idusuario.toUpperCase());
        Usuarios.setNombre(nombre.toUpperCase());
        Usuarios.setApellido(apellido.toUpperCase());
        Usuarios.setEmail(email.toLowerCase());
        Usuarios.setContrasena(encriptacion.encode(nombre, contraseña));
        Usuarios.setCelular(celular);
        Usuarios.setFoto(foto);        
        UsuariosDao.save(Usuarios);
    }
    
    public void eliminarUsuario(String idusuario){
        Usuarios.setIdUsuario(idusuario.toUpperCase());
        UsuariosDao.delete(idusuario.toUpperCase());
    }
    
    public void buscarUsuarioxIdUsuario(String idUsuario){
        UsuariosDao.search(idUsuario);
    }
}
