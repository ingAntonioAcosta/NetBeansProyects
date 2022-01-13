package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Taller {
    //Atributos:

    private int claveTa;
    private String nombreTaller;
    private String marcoTaller;
    private String nArchivo;
    private Date fechaI;
    private String quees;
    private int folioOficio;
    private Date fechaF;
    private int horas;
    private int sede;
    private String obsx;

    //Constructores:
    public Taller() {
    }

    public Taller(int claveTa, String nombreTaller, String marcoTaller, String nArchivo, Date fechaI, String quees, int folioOficio, Date fechaF, int horas, int sede, String obsx) {
        this.claveTa = claveTa;
        this.nombreTaller = nombreTaller;
        this.marcoTaller = marcoTaller;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.quees = quees;
        this.folioOficio = folioOficio;
        this.fechaF = fechaF;
        this.horas = horas;
        this.sede = sede;
        this.obsx = obsx;
    }
    //Métodos:

    @Override
    public String toString() {
        return claveTa+" "+nombreTaller+" "+fechaI+" "+quees;
    }

    //Getters & Setters:
    public int getClaveTa() {
        return claveTa;
    }

    public void setClaveTa(int claveTa) {
        this.claveTa = claveTa;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getMarcoTaller() {
        return marcoTaller;
    }

    public void setMarcoTaller(String marcoTaller) {
        this.marcoTaller = marcoTaller;
    }

    public String getnArchivo() {
        return nArchivo;
    }

    public void setnArchivo(String nArchivo) {
        this.nArchivo = nArchivo;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
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

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public String getObsx() {
        return obsx;
    }

    public void setObsx(String obsx) {
        this.obsx = obsx;
    }

}
