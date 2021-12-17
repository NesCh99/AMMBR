/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Nes Ch
 */
public class Habitacion {
    public String idHabitacion;
    public String idCategoriaHabitacion;
    public String idHospedaje;
    public int numeroCamas ;
    public String descripcion;
    public double precio;

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getIdCategoriaHabitacion() {
        return idCategoriaHabitacion;
    }

    public void setIdCategoriaHabitacion(String idCategoriaHabitacion) {
        this.idCategoriaHabitacion = idCategoriaHabitacion;
    }

    public String getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(String idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
