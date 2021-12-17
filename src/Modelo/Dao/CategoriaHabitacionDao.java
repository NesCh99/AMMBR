/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.CategoriaHabitacion;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public interface CategoriaHabitacionDao {
    public List<CategoriaHabitacion> list();    //prototipo metodo listar
    public CategoriaHabitacion edit(String idCategoriaHabitacion);    //prototipo metodo editar
    public boolean save (CategoriaHabitacion CategoriaHabitacion);   //prototipo metodo guardar
    public boolean delete(String idCategoriaHabitacion);
}
