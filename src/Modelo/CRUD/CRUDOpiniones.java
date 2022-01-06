/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CRUD;

import Modelo.Dao.OpinionesDao;
import Modelo.Dao.OpinionesDaoImpl;
import Modelo.Opiniones;

/**
 *
 * @author Nes Ch
 */
public class CRUDOpiniones {
    
    OpinionesDao OpinionesDao = new OpinionesDaoImpl();
    Opiniones Opiniones = new Opiniones();
    
    public void nuevaOpinion(int estrellas, String comentario, String idhospedaje, int idhuesped){
        Opiniones.setEstrellas(estrellas);
        Opiniones.setComentario(comentario.toUpperCase());        
        Opiniones.setIdHospedaje(idhospedaje.toUpperCase());
        Opiniones.setIdHuesped(idhuesped);
        OpinionesDao.save(Opiniones);  
    }
    
    public void editarOpinion(int estrellas, String comentario, int idopinion){
        Opiniones.setIdOpinion(idopinion);        
        Opiniones.setEstrellas(estrellas);
        Opiniones.setComentario(comentario.toUpperCase());
        OpinionesDao.save(Opiniones);
    }
    
    public void eliminarOpinion(int idOpinion, int idHuesped){
        OpinionesDao.delete(idOpinion, idHuesped);
    }
    
}
