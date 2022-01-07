/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.HabitacionDao;
import Modelo.Dao.HabitacionDaoImpl;
import Modelo.Habitacion;
import Modelo.Negocio.Seguridad.ControlIngresoDatos;

/**
 *
 * @author Nes Ch
 */
public class CRUDHabitacion {

    HabitacionDao HabitacionDao = new HabitacionDaoImpl();
    Habitacion habitacion = new Habitacion();
    ControlIngresoDatos control = new ControlIngresoDatos();

    public void nuevaHabitacion(String idhabitacion, String categoriahabitacion, String idhospedaje, int numerocamas, String descripcion, double precio) {
        if (control.existeHabitacion(idhabitacion) == false) {
            habitacion.setIdHabitacion(idhabitacion.toUpperCase());
            habitacion.setCategoriaHabitacion(categoriahabitacion.toUpperCase());
            habitacion.setIdHospedaje(idhospedaje.toUpperCase());
            habitacion.setDescripcion(descripcion.toUpperCase());
            habitacion.setNumeroCamas(numerocamas);
            habitacion.setPrecio(precio);
            HabitacionDao.save(habitacion);
        }else{
            System.out.println("Id Habitacion ya existe");
        }

    }

    public void modificarHabitacion(String idhabitacion, String categoriahabitacion, String descripcion, int numerocamas, double precio) {
        habitacion.setIdHabitacion(idhabitacion.toUpperCase());
        habitacion.setCategoriaHabitacion(categoriahabitacion.toUpperCase());
        habitacion.setDescripcion(descripcion.toUpperCase());
        habitacion.setNumeroCamas(numerocamas);
        habitacion.setPrecio(precio);
        HabitacionDao.save(habitacion);
    }
    
    public void eliminarHabitacion(String idhabitacion){
        HabitacionDao.delete(idhabitacion.toUpperCase());
    }
}
