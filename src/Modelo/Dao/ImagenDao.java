package Modelo.Dao;

import java.util.List;

import Modelo.Imagen;

public interface ImagenDao {
	public List<Imagen> list();
	
	public Imagen edit(String idHospedaje);
	public boolean save(Imagen Imagen);
	public boolean delete(String idHospedaje);
	

}





 