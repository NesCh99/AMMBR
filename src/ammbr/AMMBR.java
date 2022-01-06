/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ammbr;

import Modelo.CRUD.CRUDOpiniones;
import Modelo.CRUD.CRUDUsuarioHuesped;
import Modelo.CRUD.CRUDUsuarios;
import Modelo.Negocio.Distancia;
import Modelo.CategoriaHospedaje;
import Modelo.Dao.CategoriaHospedajeDao;
import Modelo.Dao.CategoriaHospedajeDaoImpl;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public class AMMBR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModuloUsuarioHuesped();
        ModuloOpiniones();
    }
    
    public static void ModuloUsuarioHuesped(){
        CRUDUsuarioHuesped usuariohuesped = new CRUDUsuarioHuesped();
        //usuariohuesped.nuevoUsuarioHuesped("Juan2099", "nestor", "chela", "neschp@gmail.com", "askjdgasdjb", "nesch", "0960175021", 3, 1, 22, "ecuador");
        //usuariohuesped.editarUsuarioHuesped("nestor99", "juan", "chela", "neschp@gmail.com", "20320", "nesch", "0960175021", 23);
        //usuariohuesped.eliminarUsuarioHuesped("nestor99");
    }
    
    public static void ModuloOpiniones(){
        CRUDOpiniones opinion = new CRUDOpiniones();
        //opinion.nuevaOpinion(5, "muy buen servicio", "HOT-004", 3);
        //opinion.editarOpinion(1, "Mal lugar", 3);
        //opinion.eliminarOpinion(4,0);
        
    }

}
