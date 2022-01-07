package Modelo.Dao;

import java.util.List;

import Modelo.ServiciosExtra;

public interface ServiciosExtraDao {
	public List<ServiciosExtra> list();
	public ServiciosExtra edit(int idServicioExtra);
	public boolean save(ServiciosExtra ServiciosExtra);
	public boolean delete(int idServicioExtra);
}
