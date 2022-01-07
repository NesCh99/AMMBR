/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ammbr;


import Modelo.CRUD.*;
import Modelo.Negocio.Distancia;

import Modelo.Dao.SitioHospedajeDao;
import Modelo.Dao.SitioHospedajeDaoImpl;
import Modelo.Negocio.Seguridad.Encriptacion;
import Modelo.Negocio.Seguridad.Login;
import Modelo.Negocio.generaCodigoHospedaje;

/**
 *
 * @author Nes Ch
 */
public class AMMBR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ModuloUsuarios();
        //ModuloSitioHospedaje();
        //ModuloOpiniones();
        ModuloGeoLocalizacion();
    }
    
    public static void ModuloSitioHospedaje(){
        CRUDSitioHospedaje sitiohospedaje = new CRUDSitioHospedaje();
        CRUDHabitacion habitacion = new CRUDHabitacion();
        CRUDServiciosExtra servicio = new CRUDServiciosExtra();
        generaCodigoHospedaje generaCodigoHospedaje = new generaCodigoHospedaje();
        
        sitiohospedaje.guardarSitioHospedaje(generaCodigoHospedaje.codigoHospedaje(3),
                "HACIENDA",
                "-1.6529304",
                "-78.6398802",
                "HOTEL LAS 24HORAS",
                "9999999",
                "0983418927",
                "www.HOTEL.COM",
                "www.HotelFacebook.com",
                "www.whatsapp.com", 1, 0, 0, 0, 0, 1);
        
        /*sitiohospedaje.editarSitioHospedaje("HST-005",
                "HACIENDA CAMPO",
                "-1.6529304",
                "-78.6398802",
                "HOTEL LAS 24HORAS",
                "9999999",
                "0983418927",
                "www.HOTEL.COM",
                "www.HotelFacebook.com",
                "www.whatsapp.com", 1, 0, 0, 0, 0, 1);*/
        
        //sitiohospedaje.eliminarSitioHospedaje("HST-005");
        
        //habitacion.nuevaHabitacion("GRAN", "GRANDE", "HOS-001", 2, "habitacion grande para familias", 75.00);
        //habitacion.modificarHabitacion("gran", "grandota", "Habitacion grandota", 3, 100.00);
        //habitacion.eliminarHabitacion("GRAN");
        
        //servicio.nuevoServicioExtra("HOS-001", "agua caliente");
        //servicio.modificarServicioExtra(3, "wifi");
        //servicio.eliminarServicioExtra(3);
              
    }

    public static void ModuloUsuarios() {
        CRUDUsuarioHuesped usuariohuesped = new CRUDUsuarioHuesped();
        CRUDUsuarioAdminApp adminapp = new CRUDUsuarioAdminApp();
        CRUDUsuarioAdminHospedaje adminhosp = new CRUDUsuarioAdminHospedaje();
        
        //adminapp.nuevoUsuarioAdminApp("mishell", "mishell", "yerovi", "mishell@email.com", "1345", "12345678", "0912345787", 1);
        //adminapp.editarUsuarioAdminApp("mishell", "mishell", "yerovi", "mishellyerovi@email.com", "616515", "12345678", "0912345787");
        //adminapp.eliminarUsuarioAdminApp("mishell");
        
        //adminhosp.nuevoUsuarioAdminHospedaje("raul", "raul", "mendez", "raul@hotel.com", "asd84as6d4", "12345678", "0987456321", 2, "HOT-001");
        //adminhosp.editarUsuarioAdminHospedaje("raul", "jorge", "mendez", "jorge@hotel.com", "65sad1a6asdsad", "6542sdsda546", "0987456321");
        //adminhosp.eliminarUsuarioAdminHospedaje("raul");
        
        
        //usuariohuesped.nuevoUsuarioHuesped("javier", "javier", "saltos", "js@gmail.com", "12345", "espoch123", "0960175021", 1, 1, 45, "ecuador");
        //usuariohuesped.editarUsuarioHuesped("javier", "juan", "chela", "javier@gmail.com", "20320", "nesch6545", "0960175021", 23);
        //usuariohuesped.eliminarUsuarioHuesped("javier");
    }

    public static void ModuloOpiniones() {
        CRUDOpiniones opinion = new CRUDOpiniones();
        //opinion.nuevaOpinion(2, "pesimo servicio", "HST-005", 3);
        //opinion.editarOpinion(1, "Mal lugar", 3);
        //opinion.eliminarOpinion(4,0);

    }
    
    public static void ModuloGeoLocalizacion(){
        Distancia dist = new Distancia();
        SitioHospedajeDao sitio = new SitioHospedajeDaoImpl();
        System.out.println("----------------------Lista de Hoteles----------------------");
        dist.listDistancias(-1.6601365,-78.6808285);
        System.out.println("----------------------Hoteles en un rango de 5 km----------------------");
        dist.MenorCincoKMDistancia(-1.6601365,-78.6808285);
        System.out.println("----------------------Hotel más cercano----------------------");
        dist.MenorDistancia(-1.6601365,-78.6808285);
        System.out.println("----------------------Distancia al Hotel Montecarlo----------------------");
        System.out.println(dist.distanciaCoordenadas(-1.6601365,-78.6808285, -1.6720511, -78.6561736));
    }
    
    
}
