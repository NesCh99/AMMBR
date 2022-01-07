/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.Dao;


import Modelo.SitioHospedaje;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public interface SitioHospedajeDao {
    public List<SitioHospedaje> list();    //prototipo metodo listar
    public SitioHospedaje edit(String idSitioHospedaje);    //prototipo metodo editar
    public boolean save (SitioHospedaje SitioHospedaje);   //prototipo metodo guardar
    public boolean delete(String idSitioHospedaje); 
    public boolean search(String idSitioHospedaje);
    public List<SitioHospedaje> searchName(String nombre);
}
