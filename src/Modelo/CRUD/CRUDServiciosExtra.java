/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.ServiciosExtraDao;
import Modelo.Dao.ServiciosExtraDaoImpl;
import Modelo.ServiciosExtra;

/**
 *
 * @author Nes Ch
 */
public class CRUDServiciosExtra {
    ServiciosExtraDao ServiciosExtraDao = new ServiciosExtraDaoImpl();
    ServiciosExtra servicios = new ServiciosExtra();
    public void nuevoServicioExtra(String idhospedaje, String descripcion){
        servicios.setIdHospedaje(idhospedaje.toUpperCase());
        servicios.setDescripcion(descripcion.toUpperCase());
        ServiciosExtraDao.save(servicios);
    }
    
    public void eliminarServicioExtra(int idservicioextra){
        ServiciosExtraDao.delete(idservicioextra);
    }
    
    public void modificarServicioExtra(int idservicioextra, String descripcion){
        servicios.setIdServiciosExtra(idservicioextra);
        servicios.setDescripcion(descripcion.toUpperCase());
        ServiciosExtraDao.save(servicios);
    }
}
