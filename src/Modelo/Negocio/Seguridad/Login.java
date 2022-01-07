/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Negocio.Seguridad;

import Modelo.Dao.UsuariosDao;
import Modelo.Dao.UsuariosDaoImpl;
import Modelo.Usuarios;

/**
 *
 * @author Nes Ch
 */
public class Login {
    Encriptacion decoding = new Encriptacion();
    UsuariosDao UsuariosDao = new UsuariosDaoImpl();
    Usuarios Usuarios = new Usuarios();
    
    public String iniciarSesion(String usuario, String contraseña){
        String key = "";
        String deContraseña = "";
        String band = "Usuario o Contraseña incorrecta";
        try{
           Usuarios = UsuariosDao.searchxUsuario(usuario.toUpperCase());
           deContraseña = decoding.decode(Usuarios.getNombre(), Usuarios.getContrasena());
           deContraseña = decoding.decode("JACINTO", "rdOEzzwZISA=");
           System.out.println(deContraseña);
        if(deContraseña.equals(contraseña) == true){           
           
           band = "Encontrado";
        } 
        }catch(Exception e){
            System.out.println("Algo anda mal");
        }
        
    
         return band;       
    
    }
}
