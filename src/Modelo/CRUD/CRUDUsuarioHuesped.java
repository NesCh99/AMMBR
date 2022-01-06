/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.UsuarioHuespedDao;
import Modelo.Dao.UsuarioHuespedDaoImpl;
import Modelo.Dao.UsuariosDao;
import Modelo.Dao.UsuariosDaoImpl;
import Modelo.Negocio.Seguridad.ControlIngresoDatos;
import Modelo.UsuarioHuesped;
import Modelo.Usuarios;

/**
 *
 * @author Nes Ch
 */
public class CRUDUsuarioHuesped {
    UsuariosDao UsuariosDao = new UsuariosDaoImpl();
    Usuarios Usuarios = new Usuarios();
    UsuarioHuespedDao UsuarioHuespedDao = new UsuarioHuespedDaoImpl();
    UsuarioHuesped UsuarioHuesped = new UsuarioHuesped();
    ControlIngresoDatos control = new ControlIngresoDatos();
    CRUDUsuarios CRUDUsuarios = new CRUDUsuarios();
    
    
    public void nuevoUsuarioHuesped(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular, int tipo, int genero, int edad, String pais){
            if(control.existeUsuario(idusuario)==false){
                if(control.numCaracteres(idusuario)==true){
                    CRUDUsuarios.nuevoUsuario(idusuario, nombre, apellido, email, foto, contraseña, celular, tipo);
                    UsuarioHuesped.setIdUsuario(idusuario.toUpperCase());
                    UsuarioHuesped.setEdad(edad);
                    UsuarioHuesped.setGenero(genero);
                    UsuarioHuesped.setPais(pais.toUpperCase());
                    UsuarioHuespedDao.save(UsuarioHuesped); 
                }else{
                    System.out.println("Ingrese un usuario menor a 10 caracteres");
                }
            }else{
                System.out.println("Usuario ya existe");
            }
                    
    }
    
    public void editarUsuarioHuesped(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular, int edad){
        CRUDUsuarios.editarUsuario(idusuario, nombre, apellido, email, foto, contraseña, celular);
        UsuarioHuesped.setIdUsuario(idusuario.toUpperCase());
        UsuarioHuesped.setEdad(edad);        
        UsuarioHuespedDao.save(UsuarioHuesped);
    }

    public void eliminarUsuarioHuesped(String idusuario){
        CRUDUsuarios.eliminarUsuario(idusuario);
        UsuarioHuespedDao.delete(idusuario.toUpperCase());
    }
    
}
