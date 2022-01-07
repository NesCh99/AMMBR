/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.Dao;

import Modelo.Habitacion;
import java.util.List;

/**
 *
 * @author Nes Ch
 */
public interface HabitacionDao {
    public List<Habitacion> list();    //prototipo metodo listar
    public Habitacion edit(String idHabitacion);    //prototipo metodo editar
    public boolean save (Habitacion Habitacion);   //prototipo metodo guardar
    public boolean delete(String idHabitacion); 
    public boolean search(String idHabitacion);
}
