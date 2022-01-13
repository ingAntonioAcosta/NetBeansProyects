package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Infocab {

    //Atributos:
    private int claveI;
    private String nArchivo;
    private Date fechaI;
    private Date fechaF;
    private int horas;
    private int folioOficio;
    private String nombreProyecto;
    private String obsx;
    private int sede;

    //Constructores:
    public Infocab() {
    }

    public Infocab(int claveI, String nArchivo, Date fechaI, Date fechaF, int horas, int folioOficio, String nombreProyecto, String obsx, int sede) {
        this.claveI = claveI;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.horas = horas;
        this.folioOficio = folioOficio;
        this.nombreProyecto = nombreProyecto;
        this.obsx = obsx;
        this.sede = sede;
    }

    //Métodos:
    @Override
    public String toString() {
        return claveI + " " + nombreProyecto;
    }

    //Getters & Setters:
    public int getClaveI() {
        return claveI;
    }

    public void setClaveI(int claveI) {
        this.claveI = claveI;
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

    public int getFolioOficio() {
        return folioOficio;
    }

    public void setFolioOficio(int folioOficio) {
        this.folioOficio = folioOficio;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getObsx() {
        return obsx;
    }

    public void setObsx(String obsx) {
        this.obsx = obsx;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

}
