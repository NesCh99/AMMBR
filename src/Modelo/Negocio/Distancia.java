/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Negocio;

/**
 *
 * @author Nes Ch
 */
public class Distancia {
    
    public double distanciaCoordenadas(double lat_pa, double long_pa, double lat_des, double long_des){
         double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(lat_des - lat_pa);  
        double dLng = Math.toRadians(long_des - long_pa);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat_pa)) * Math.cos(Math.toRadians(lat_des));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }
    
}
