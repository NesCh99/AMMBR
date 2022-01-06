/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ammbr;

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
        CRUDUsuarioHuesped usuariohuesped = new CRUDUsuarioHuesped();
        usuariohuesped.nuevoUsuarioHuesped("nestor99", "nestor", "chela", "neschp@gmail.com", "askjdgasdjb", "nesch", "0960175021", 3, 1, 22, "ecuador");
    }

}
