/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.UsuarioAdminApp;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface UsuarioAdminAppDao {
    public List<UsuarioAdminApp> list();    //prototipo metodo listar
    public UsuarioAdminApp edit(String idUsuario);    //prototipo metodo editar
    public boolean save (UsuarioAdminApp UsuarioAdminApp);   //prototipo metodo guardar
    public boolean delete(String idUsuario); 
}
