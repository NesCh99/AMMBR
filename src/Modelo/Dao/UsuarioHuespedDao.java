
package Modelo.Dao;

import Modelo.UsuarioHuesped;
import java.util.List;

public interface UsuarioHuespedDao {
    public List<UsuarioHuesped> list();    //prototipo metodo listar
    public UsuarioHuesped edit(String idUsuario);    //prototipo metodo editar
    public boolean save (UsuarioHuesped UsuarioHuesped);   //prototipo metodo guardar
    public boolean delete(String idUsuario); 
    public boolean search (String idUsuario);   //prototipo metodo buscar por codigo
}
