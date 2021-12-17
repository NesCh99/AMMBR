
package Modelo.Dao;

import Modelo.UsuarioAdminHospedaje;
import java.util.List;

public interface UsuarioAdminHospedajeDao {
    public List<UsuarioAdminHospedaje> list();    //prototipo metodo listar
    public UsuarioAdminHospedaje edit(String idUsuario);    //prototipo metodo editar
    public boolean save (UsuarioAdminHospedaje UsuarioAdminHospedaje);   //prototipo metodo guardar
    public boolean delete(String idUsuario); 
}
