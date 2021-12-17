/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Factory;

/**
 *
 * @author Nes Ch
 */
public class FactoryConexionDB {
    
    public static String[] configMYSQL = {"ammbr", "root", ""};  //configrar copnexion: nombre bd, usr, clave
    public static ConexionDB open(){          //abrir bd mysql
        return new ConexionMySQL(configMYSQL);  //no hace falta break porque esta return
            
     }
}
