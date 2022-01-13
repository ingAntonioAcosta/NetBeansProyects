package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *  
 */

public class Asesoria {
    //Atributos:

    private int claveAs;
    private String nombreAsesoria;
    private String conj1;
    private String marco;
    private String nArchivo;
    private Date fechaI;
    private Date fechaF;
    private int horas;
    private int folioOficio; 
    private String obsx;
    private int sede;

    //Constructores:

    public Asesoria(int claveAs, String nombreAsesoria, String conj1, String marco, String nArchivo, Date fechaI, Date fechaF, int horas, int folioOficio, String obsx, int sede) {
        this.claveAs = claveAs;
        this.nombreAsesoria = nombreAsesoria;
        this.conj1 = conj1;
        this.marco = marco;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.horas = horas;
        this.folioOficio = folioOficio;
        this.obsx = obsx;
        this.sede = sede;
    }
    
    public Asesoria() {
    }

    //Métodos:

    @Override
    public String toString() {
        return claveAs+" "+nombreAsesoria;
    }


    //Getters & Setters:

    public int getClaveAs() {
        return claveAs;
    }

    public void setClaveAs(int claveAs) {
        this.claveAs = claveAs;
    }

    public String getNombreAsesoria() {
        return nombreAsesoria;
    }

    public void setNombreAsesoria(String nombreAsesoria) {
        this.nombreAsesoria = nombreAsesoria;
    }

    public String getConj1() {
        return conj1;
    }

    public void setConj1(String conj1) {
        this.conj1 = conj1;
    }

    public String getMarco() {
        return marco;
    }

    public void setMarco(String marco) {
        this.marco = marco;
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
