/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.CategoriaHospedaje;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public interface CategoriaHospedajeDao {
    public List<CategoriaHospedaje> list();    //prototipo metodo listar
    public CategoriaHospedaje edit(String idCategoriaHospedaje);    //prototipo metodo editar
    public boolean save (CategoriaHospedaje CategoriaHospedaje);   //prototipo metodo guardar
    public boolean delete(String idCategoriaHospedaje); 
}
