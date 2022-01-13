package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Visita {

    //Atributos:
    private int claveV;
    private String nombreVisita;
    private String complemento;
    private String nArchivo;
    private String quees;
    private int folioOficio;
    private Date fechaI;
    private Date fechaF;
    private int sede;

    //Constructores:
    public Visita() {
    }

    public Visita(int claveV, String nombreVisita, String complemento, String nArchivo, String quees, int folioOficio, Date fechaI, Date fechaF, int sede) {
        this.claveV = claveV;
        this.nombreVisita = nombreVisita;
        this.complemento = complemento;
        this.nArchivo = nArchivo;
        this.quees = quees;
        this.folioOficio = folioOficio;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.sede = sede;
    }

    //Métodos:
    @Override
    public String toString() {
        return claveV + " " + nombreVisita;
    }

    //Getters & Setters:
    public int getClaveV() {
        return claveV;
    }

    public void setClaveV(int claveV) {
        this.claveV = claveV;
    }

    public String getNombreVisita() {
        return nombreVisita;
    }

    public void setNombreVisita(String nombreVisita) {
        this.nombreVisita = nombreVisita;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getnArchivo() {
        return nArchivo;
    }

    public void setnArchivo(String nArchivo) {
        this.nArchivo = nArchivo;
    }

    public String getQuees() {
        return quees;
    }

    public void setQuees(String quees) {
        this.quees = quees;
    }

    public int getFolioOficio() {
        return folioOficio;
    }

    public void setFolioOficio(int folioOficio) {
        this.folioOficio = folioOficio;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

}
