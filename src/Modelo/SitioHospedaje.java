/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Nes Ch
 */
public class SitioHospedaje {
    private String idHospedaje;
    private String idCategoriaHospedaje;
    private String nombre;
    private Long latitud;
    private Long longitud;
    private String descripcion;
    private String telefono;
    private String celular;
    private String sitioWebURL;
    private String fanPageURL;
    private String whatsappURL;
    private int pagoEfectivo;
    private int pagoElectronico;
    private int pagoTarjeta;

    public String getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(String idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public String getIdCategoriaHospedaje() {
        return idCategoriaHospedaje;
    }

    public void setIdCategoriaHospedaje(String idCategoriaHospedaje) {
        this.idCategoriaHospedaje = idCategoriaHospedaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getLatitud() {
        return latitud;
    }

    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSitioWebURL() {
        return sitioWebURL;
    }

    public void setSitioWebURL(String sitioWebURL) {
        this.sitioWebURL = sitioWebURL;
    }

    public String getFanPageURL() {
        return fanPageURL;
    }

    public void setFanPageURL(String fanPageURL) {
        this.fanPageURL = fanPageURL;
    }

    public String getWhatsappURL() {
        return whatsappURL;
    }

    public void setWhatsappURL(String whatsappURL) {
        this.whatsappURL = whatsappURL;
    }

    public int getPagoEfectivo() {
        return pagoEfectivo;
    }

    public void setPagoEfectivo(int pagoEfectivo) {
        this.pagoEfectivo = pagoEfectivo;
    }

    public int getPagoElectronico() {
        return pagoElectronico;
    }

    public void setPagoElectronico(int pagoElectronico) {
        this.pagoElectronico = pagoElectronico;
    }

    public int getPagoTarjeta() {
        return pagoTarjeta;
    }

    public void setPagoTarjeta(int pagoTarjeta) {
        this.pagoTarjeta = pagoTarjeta;
    }
    
    
}
