/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Negocio.Seguridad;


import Modelo.Dao.HabitacionDao;
import Modelo.Dao.HabitacionDaoImpl;
import Modelo.Dao.SitioHospedajeDao;
import Modelo.Dao.SitioHospedajeDaoImpl;
import Modelo.Dao.UsuarioHuespedDao;
import Modelo.Dao.UsuarioHuespedDaoImpl;
import Modelo.Dao.UsuariosDao;
import Modelo.Dao.UsuariosDaoImpl;
import Modelo.SitioHospedaje;
import Modelo.UsuarioHuesped;
import Modelo.Usuarios;

/**
 *
 * @author Nes Ch
 */
public class ControlIngresoDatos {
    UsuariosDao UsuariosDao = new UsuariosDaoImpl();
    Usuarios Usuarios = new Usuarios();
    SitioHospedajeDao SitioHospedajeDao = new SitioHospedajeDaoImpl();
    HabitacionDao HabitacionDao = new HabitacionDaoImpl();
    
    
    public boolean existeUsuario(String idusuario){
        boolean band = false;
        band = UsuariosDao.search(idusuario);
        return band;
    }
    
        

  public boolean existeSitioHospedaje(String idHospedaje) {
        boolean band = false;
        band = SitioHospedajeDao.search(idHospedaje);
        return band;
    }
  
  public boolean existeHabitacion(String idHabitacion) {
        boolean band = false;
        band = HabitacionDao.search(idHabitacion);
        return band;
    }

    
    public boolean MayorEdad(int edad){
        boolean band = false;
        if(edad>=18){
            band = true;
        }
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
