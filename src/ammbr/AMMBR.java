/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ammbr;

import Modelo.CRUD.CRUDUsuarioAdminApp;
import Modelo.CRUD.CRUDUsuarioAdminHospedaje;
import Modelo.CRUD.CRUDUsuarios;
import Modelo.Negocio.Distancia;
import Modelo.CategoriaHospedaje;
import Modelo.Dao.CategoriaHospedajeDao;
import Modelo.Dao.CategoriaHospedajeDaoImpl;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class AMMBR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModuloUsuarioAdminApp();
    }

     public static void ModuloUsuarioAdminApp() {
       CRUDUsuarioAdminApp usuarioadminapp = new CRUDUsuarioAdminApp();
       usuarioadminapp.nuevoUsuarioAdminApp("carlos01", "carlos", "vilema", "carlos1@gmail.com", "bdbdbdbd", "0000", "0979864042",1);
        //usuarioadminapp.editarUsuarioAdminApp("carlos01", "carlos", "vilema", "carlos1@gmail.com", "bdbdbdbd", "0000", "0979864042");
        //usuarioadminapp.eliminarUsuarioAdminApp("carlos01");
    }
    public static void ModuloUsuarioAdminHospedaje() {
       CRUDUsuarioAdminHospedaje usuarioadminhospedaje= new CRUDUsuarioAdminHospedaje();
       //usuarioadminhospedaje.nuevoUsuarioAdminHospedaje("pepe01", "pepe", "garcia", "pepe1@gmail.com", "bdbdbdbd", "0000", "0978841555",1,"HOTEL004");
       //usuarioadminhospedaje.editarUsuarioAdminHospedaje("pepe01", "pepe", "garcia", "pepe1@gmail.com", "bdbdbdbd", "0000", "0978841555");
       //usuarioadminhospedaje.eliminarUsuarioAdminHospedaje("pepe01");
    }

}