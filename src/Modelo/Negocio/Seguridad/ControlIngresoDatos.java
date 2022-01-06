/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Negocio.Seguridad;

import Modelo.Dao.UsuarioHuespedDao;
import Modelo.Dao.UsuarioHuespedDaoImpl;
import Modelo.Dao.UsuariosDao;
import Modelo.Dao.UsuariosDaoImpl;
import Modelo.UsuarioHuesped;
import Modelo.Usuarios;

/**
 *
 * @author Nes Ch
 */
public class ControlIngresoDatos {
    UsuariosDao UsuariosDao = new UsuariosDaoImpl();
    Usuarios Usuarios = new Usuarios();
    
    public boolean existeUsuario(String idusuario){
        boolean band = false;
        band = UsuariosDao.search(idusuario);
        return band;
    }
    
    public boolean numCaracteres(String idusuario){
        boolean band = false;
        if(idusuario.length()<=10){
            band = true;
        }
        return band;
    }
    
}
