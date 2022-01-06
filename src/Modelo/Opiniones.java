package Modelo;

public class Opiniones {
	private String idHospedaje;
        private long idOpinion;
	private int estrellas;
        private int idHuesped;
	private String comentario;
	
	public String getIdHospedaje() {
		return idHospedaje;
	}
	public void setIdHospedaje(String idHospedaje) {
		this.idHospedaje = idHospedaje;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

        public int getIdHuesped() {
            return idHuesped;
        }

        public void setIdHuesped(int idHuesped) {
            this.idHuesped = idHuesped;
        }

    public long getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(long idOpinion) {
        this.idOpinion = idOpinion;
    }
	

}
