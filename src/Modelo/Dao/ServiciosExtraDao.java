package Modelo.Dao;

import java.util.List;

import Modelo.ServiciosExtra;

public interface ServiciosExtraDao {
	public List<ServiciosExtra> list();

	public ServiciosExtra edit(String idHospedaje);
	public boolean save(ServiciosExtra ServiciosExtra);
	public boolean delete(String idHospedaje);

}


/*
 * public List<ServiciosExtra> list();    //prototipo metodo listar
  
	
	public ServiciosExtra edit(String idHospedaje);
	public boolean save(ServiciosExtra ServiciosExtra);
	public boolean delete(String idHospedaje);
 * 
 * 
 * 
 * */