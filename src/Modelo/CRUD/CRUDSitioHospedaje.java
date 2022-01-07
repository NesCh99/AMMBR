/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.SitioHospedajeDaoImpl;
import Modelo.Dao.SitioHospedajeDao;
import Modelo.Negocio.Seguridad.ControlIngresoDatos;
import Modelo.SitioHospedaje;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class CRUDSitioHospedaje {

    SitioHospedajeDao SitioHospedajeDao = new SitioHospedajeDaoImpl();
    SitioHospedaje sitioHospedaje = new SitioHospedaje();
    ControlIngresoDatos control = new ControlIngresoDatos();

    public void guardarSitioHospedaje(String idHospedaje,
            String nombre,
            String latitud,
            String longitud,
            String descripcion,
            String telefono,
            String celular,
            String sitioWebURL,
            String fanPageURL,
            String whatsappURL,
            int pagoEfectivo,
            int pagoElectronico,
            int pagoTarjeta,
            int cat_Hotel,
            int cat_Hostal,
            int cat_Hosteria) {

        if (control.existeSitioHospedaje(idHospedaje) == false) {
            sitioHospedaje.setIdHospedaje(idHospedaje.toUpperCase());
            sitioHospedaje.setNombre(nombre.toUpperCase());
            sitioHospedaje.setLatitud(latitud);
            sitioHospedaje.setLongitud(longitud);
            sitioHospedaje.setDescripcion(descripcion.toUpperCase());
            sitioHospedaje.setTelefono(telefono);
            sitioHospedaje.setCelular(celular);
            sitioHospedaje.setSitioWebURL(sitioWebURL.toLowerCase());
            sitioHospedaje.setFanPageURL(fanPageURL.toLowerCase());
            sitioHospedaje.setWhatsappURL(whatsappURL.toLowerCase());
            sitioHospedaje.setPagoEfectivo(pagoEfectivo);
            sitioHospedaje.setPagoElectronico(pagoElectronico);
            sitioHospedaje.setPagoTarjeta(pagoTarjeta);
            sitioHospedaje.setCat_Hotel(cat_Hotel);
            sitioHospedaje.setCat_Hostal(cat_Hostal);
            sitioHospedaje.setCat_Hosteria(cat_Hosteria);
            SitioHospedajeDao.save(sitioHospedaje);
        } else {
            System.out.println("El hotel ya esta registrado");

        }
    }

    public void editarSitioHospedaje(String idHospedaje,
            String nombre,
            String latitud,
            String longitud,
            String descripcion,
            String telefono,
            String celular,
            String sitioWebURL,
            String fanPageURL,
            String whatsappURL,
            int pagoEfectivo,
            int pagoElectronico,
            int pagoTarjeta,
            int cat_Hotel,
            int cat_Hostal,
            int cat_Hosteria) {
        sitioHospedaje.setIdHospedaje(idHospedaje.toUpperCase());
        sitioHospedaje.setNombre(nombre.toUpperCase());
        sitioHospedaje.setLatitud(latitud);
        sitioHospedaje.setLongitud(longitud);
        sitioHospedaje.setDescripcion(descripcion.toUpperCase());
        sitioHospedaje.setTelefono(telefono);
        sitioHospedaje.setCelular(celular);
        sitioHospedaje.setSitioWebURL(sitioWebURL.toLowerCase());
        sitioHospedaje.setFanPageURL(fanPageURL.toLowerCase());
        sitioHospedaje.setWhatsappURL(whatsappURL.toLowerCase());
        sitioHospedaje.setPagoEfectivo(pagoEfectivo);
        sitioHospedaje.setPagoElectronico(pagoElectronico);
        sitioHospedaje.setPagoTarjeta(pagoTarjeta);
        sitioHospedaje.setCat_Hotel(cat_Hotel);
        sitioHospedaje.setCat_Hostal(cat_Hostal);
        sitioHospedaje.setCat_Hosteria(cat_Hosteria);
        SitioHospedajeDao.save(sitioHospedaje);

    }

    public void eliminarSitioHospedaje(String idHospedaje) {
        SitioHospedajeDao.delete(idHospedaje);

    }

    public void listarSitioHospedaje() {
        List<SitioHospedaje> list = SitioHospedajeDao.list();
        System.out.println("--- LISTADO DE SITIOS DE HOSPEDAJE ---");
        for (SitioHospedaje SitioHospedaje : list) {
            System.out.println("ID: " + SitioHospedaje.getIdHospedaje() + " "
                    + "NOMBRE: " + SitioHospedaje.getNombre() + " "
                    + "CELULAR: " + SitioHospedaje.getTelefono() + " "
                    + "LATITUD: " + SitioHospedaje.getLatitud() + " "
                    + "LONGITUD: " + SitioHospedaje.getLongitud());
        };
    }

    public void listarNombre(String nombre) {
         List<SitioHospedaje> list = SitioHospedajeDao.searchName(nombre);
        System.out.println("--- LISTADO DE SITIOS DE HOSPEDAJE ---");
        for (SitioHospedaje SitioHospedaje : list) {
            System.out.println("ID: " + SitioHospedaje.getIdHospedaje() + " "
                    + "NOMBRE: " + SitioHospedaje.getNombre() + " "
                    + "CELULAR: " + SitioHospedaje.getTelefono() + " "
                    + "LATITUD: " + SitioHospedaje.getLatitud() + " "
                    + "LONGITUD: " + SitioHospedaje.getLongitud());
        };

    }

}
