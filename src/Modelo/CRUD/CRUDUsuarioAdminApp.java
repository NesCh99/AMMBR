/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.UsuarioAdminAppDao;
import Modelo.Dao.UsuarioAdminAppDaoImpl;
import Modelo.Dao.UsuariosDao;
import Modelo.Dao.UsuariosDaoImpl;
import Modelo.Negocio.Seguridad.ControlIngresoDatos;
import Modelo.UsuarioAdminApp;
import Modelo.Usuarios;

/**
 *
 * @author Carlos
 */
public class CRUDUsuarioAdminApp {
    UsuariosDao UsuariosDao = new UsuariosDaoImpl();
    Usuarios Usuarios = new Usuarios();
    UsuarioAdminAppDao UsuarioAdminAppDao = new UsuarioAdminAppDaoImpl();
    UsuarioAdminApp UsuarioAdminApp = new UsuarioAdminApp();
    ControlIngresoDatos control = new ControlIngresoDatos();
    CRUDUsuarios CRUDUsuarios = new CRUDUsuarios();
    
    
    public void nuevoUsuarioAdminApp(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular, int tipo){
            if(control.existeUsuario(idusuario)==false){
                if(control.numCaracteres(idusuario)==true){
                    CRUDUsuarios.nuevoUsuario(idusuario, nombre, apellido, email, foto, contraseña, celular, tipo);
                    UsuarioAdminApp.setIdUsuario(idusuario.toUpperCase());
                    UsuarioAdminAppDao.save(UsuarioAdminApp); 
                }else{
                    System.out.println("Ingrese un usuario menor a 10 caracteres");
                }
            }else{
                System.out.println("Usuario ya existe");
            }
                    
    }
    
    public void editarUsuarioAdminApp(String idusuario, String nombre, String apellido, String email, String foto, String contraseña, String celular){
        CRUDUsuarios.editarUsuario(idusuario, nombre, apellido, email, foto, contraseña, celular);      
        UsuarioAdminAppDao.save(UsuarioAdminApp);
    }

    public void eliminarUsuarioAdminApp(String idusuario){
        CRUDUsuarios.eliminarUsuario(idusuario);
        UsuarioAdminAppDao.delete(idusuario);
    }
     
}
