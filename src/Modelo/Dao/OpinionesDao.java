package Modelo.Dao;

import java.util.List;

import Modelo.Opiniones;



public interface OpinionesDao {
public List<Opiniones> list();
	
	public Opiniones edit(int idOpinion);
	public boolean save(Opiniones Opiniones);
	public boolean delete(int idOpinion, int idHuesped);

}
