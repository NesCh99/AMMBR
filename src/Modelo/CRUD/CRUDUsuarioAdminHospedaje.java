/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.UsuarioAdminHospedajeDao;
import Modelo.Dao.UsuarioAdminHospedajeDaoImpl;
import Modelo.Dao.UsuariosDao;
import Modelo.Dao.UsuariosDaoImpl;
import Modelo.Negocio.Seguridad.ControlIngresoDatos;
import Modelo.UsuarioAdminHospedaje;
import Modelo.Usuarios;

/**
 *
 * @author Carlos
 */
public class CRUDUsuarioAdminHospedaje {
    UsuariosDao UsuariosDao = new UsuariosDaoImpl();
    Usuarios Usuarios = new Usuarios();
    UsuarioAdminHospedajeDao UsuarioAdminHospedajeDao = new UsuarioAdminHospedajeDaoImpl();
    UsuarioAdminHospedaje UsuarioAdminHospedaje = new UsuarioAdminHospedaje();
    ControlIngresoDatos control = new ControlIngresoDatos();
    CRUDUsuarios CRUDUsuarios = new CRUDUsuarios();
    
    
    public void nuevoUsuarioAdminHospedaje(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular, int tipo, String idhospedaje){
            if(control.existeUsuario(idusuario)==false){
                if(control.numCaracteres(idusuario)==true){
                    CRUDUsuarios.nuevoUsuario(idusuario, nombre, apellido, email, foto, contraseña, celular, tipo);
                    UsuarioAdminHospedaje.setIdUsuario(idusuario.toUpperCase());
                    UsuarioAdminHospedaje.setIdHospedaje(idhospedaje);
                    UsuarioAdminHospedajeDao.save(UsuarioAdminHospedaje); 
                }else{
                    System.out.println("Ingrese un usuario menor a 10 caracteres");
                }
            }else{
                System.out.println("Usuario ya existe");
            }
                    
    }
    
    public void editarUsuarioAdminHospedaje(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular){
        CRUDUsuarios.editarUsuario(idusuario, nombre, apellido, email, foto, contraseña, celular);       
        UsuarioAdminHospedajeDao.save(UsuarioAdminHospedaje);
    }

    public void eliminarUsuarioAdminHospedaje(String idusuario){
        CRUDUsuarios.eliminarUsuario(idusuario);
        UsuarioAdminHospedajeDao.delete(idusuario);
    }
}
