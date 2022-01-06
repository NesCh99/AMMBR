
package Modelo;


public class UsuarioHuesped {
    private long idHuesped;
    private String idUsuario;
    private Integer genero;
    private Integer edad;
    private String pais;

    public long getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(long idHuesped) {
        this.idHuesped = idHuesped;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }



}
