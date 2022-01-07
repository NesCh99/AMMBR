/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Negocio;

import Modelo.Dao.SitioHospedajeDao;
import Modelo.Dao.SitioHospedajeDaoImpl;
import Modelo.SitioHospedaje;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/**
 *
 * @author Nes Ch
 */
public class Distancia {

    //Creación de la lista para todas las distancias
    List<Double> dis = new ArrayList<>();

    // Imprimir Lista de todas las distancias 
    public void listDistancias(double lat_pa, double long_pa) {
        SitioHospedajeDao sitioDao = new SitioHospedajeDaoImpl(); //atributo cuentabancoDAo es de tipo cuentabancoDao e inicia como nuevo cuentabancodaoimpl
        List<SitioHospedaje> list = sitioDao.list();

        for (SitioHospedaje SitioHospedaje : list) {
            double lat_des = Double.parseDouble(SitioHospedaje.getLatitud());
            double long_des = Double.parseDouble(SitioHospedaje.getLongitud());
            double distancia = distanciaCoordenadas(lat_pa, long_pa, lat_des, long_des);
            System.out.println(SitioHospedaje.getNombre() + ": " + distancia + "KM");
        }
    }

    /*Este método devuelve un tipo numérico double 
      con la distancia en kilómetros entre dos puntos 
      de coordenadas terrestres(Latitud y Longitud)*/
    public double distanciaCoordenadas(double lat_pa, double long_pa, double lat_des, double long_des) {
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


    public void MenorCincoKMDistancia(double lat_pa, double long_pa) {
        SitioHospedajeDao sitioDao = new SitioHospedajeDaoImpl(); //atributo cuentabancoDAo es de tipo cuentabancoDao e inicia como nuevo cuentabancodaoimpl
        List<SitioHospedaje> list = sitioDao.list();

        for (SitioHospedaje SitioHospedaje : list) {
            double lat_des = Double.parseDouble(SitioHospedaje.getLatitud());
            double long_des = Double.parseDouble(SitioHospedaje.getLongitud());
            if (distanciaCoordenadas(lat_pa, long_pa, lat_des, long_des)<=5) {
                System.out.println(SitioHospedaje.getNombre());
            }

        }
    }
    
    public void MenorDistancia(double lat_pa, double long_pa) {
        SitioHospedajeDao sitioDao = new SitioHospedajeDaoImpl(); //atributo cuentabancoDAo es de tipo cuentabancoDao e inicia como nuevo cuentabancodaoimpl
        List<SitioHospedaje> list = sitioDao.list();
        int size = list.size();
        int k=0;
        double array[] = new double [size];
        double menor;
        for (SitioHospedaje SitioHospedaje : list) {
            double lat_des = Double.parseDouble(SitioHospedaje.getLatitud());
            double long_des = Double.parseDouble(SitioHospedaje.getLongitud());
            array[k]=distanciaCoordenadas(lat_pa, long_pa, lat_des, long_des);
            k=k+1;
        }
        menor = array[0];
        int menorIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]<menor) {
                menor = array[i];
                menorIndex = i;
            }
        }
        
        System.out.println(list.get(menorIndex).getNombre() + " " + menor + " KM ");
    }


}
