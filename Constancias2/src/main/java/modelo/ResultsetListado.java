package modelo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class ResultsetListado {

    //Atributos:
    private String nombreProfesor;
    private String motivoConstancia;
    private String nombreEvento;

    private int folioConstancia;
    private String tipoConstancia;
    private String instanciaEvento;
    private String areaProfesor;
    private String adscrProfesor;
    private String emailProfesor;
    private int claveEvento;
    private int claveProfesor;
    private int credencial;
    private Date fechaE;

    //Constructores:
    public ResultsetListado() {
    }

    public ResultsetListado(String nombreProfesor, String motivoConstancia, String nombreEvento, int folioConstancia, String tipoConstancia, String instanciaEvento, String areaProfesor, String adscrProfesor, String emailProfesor, int claveEvento, int claveProfesor, int credencial, Date fechaE) {
        this.nombreProfesor = nombreProfesor;
        this.motivoConstancia = motivoConstancia;
        this.nombreEvento = nombreEvento;
        this.folioConstancia = folioConstancia;
        this.tipoConstancia = tipoConstancia;
        this.instanciaEvento = instanciaEvento;
        this.areaProfesor = areaProfesor;
        this.adscrProfesor = adscrProfesor;
        this.emailProfesor = emailProfesor;
        this.claveEvento = claveEvento;
        this.claveProfesor = claveProfesor;
        this.credencial = credencial;
        this.fechaE = fechaE;
    }



    //Métodos:
    //Getters & Setters:
    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getMotivoConstancia() {
        return motivoConstancia;
    }

    public void setMotivoConstancia(String motivoConstancia) {
        this.motivoConstancia = motivoConstancia;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getFolioConstancia() {
        return folioConstancia;
    }

    public void setFolioConstancia(int folioConstancia) {
        this.folioConstancia = folioConstancia;
    }

    public String getTipoConstancia() {
        return tipoConstancia;
    }

    public void setTipoConstancia(String tipoConstancia) {
        this.tipoConstancia = tipoConstancia;
    }

    public String getInstanciaEvento() {
        return instanciaEvento;
    }

    public void setInstanciaEvento(String instanciaEvento) {
        this.instanciaEvento = instanciaEvento;
    }

    public String getAreaProfesor() {
        return areaProfesor;
    }

    public void setAreaProfesor(String areaProfesor) {
        this.areaProfesor = areaProfesor;
    }

    public String getAdscrProfesor() {
        return adscrProfesor;
    }

    public void setAdscrProfesor(String adscrProfesor) {
        this.adscrProfesor = adscrProfesor;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }

    public int getClaveEvento() {
        return claveEvento;
    }

    public void setClaveEvento(int claveEvento) {
        this.claveEvento = claveEvento;
    }

    public int getClaveProfesor() {
        return claveProfesor;
    }

    public void setClaveProfesor(int claveProfesor) {
        this.claveProfesor = claveProfesor;
    }

    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
    }
     
}
