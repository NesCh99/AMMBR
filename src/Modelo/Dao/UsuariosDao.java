/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Usuarios;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface UsuariosDao {
    public List<Usuarios> list();    //prototipo metodo listar
    public Usuarios edit(String idUsuario);    //prototipo metodo editar
    public boolean save (Usuarios Usuarios);   //prototipo metodo guardar
    public Usuarios search (String idUsuario);   //prototipo metodo buscar por codigo
    public boolean delete(String idUsuario); 
}
