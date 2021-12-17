package Modelo.Dao;

import java.util.List;

import Modelo.Opiniones;



public interface OpinionesDao {
public List<Opiniones> list();
	
	public Opiniones edit(String idHospedaje);
	public boolean save(Opiniones Opiniones);
	public boolean delete(String idHospedaje);

}
