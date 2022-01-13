package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *  
 */

public class Concurso {
    //Atributos:
    
    private int claveCo;
    private String nombreConcurso;
    private String nArchivo;
    private Date fechaI;
    private Date fechaF;
    private int folioOficio; 
    private String obsx;
    private String conj1;
    private String marco;
    private int sede;
    private String quees;
        
    
    //Constructores:

    public Concurso(int claveCo, String nombreConcurso, String nArchivo, Date fechaI, Date fechaF, int folioOficio, String obsx, String conj1, String marco, int sede, String quees) {
        this.claveCo = claveCo;
        this.nombreConcurso = nombreConcurso;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.folioOficio = folioOficio;
        this.obsx = obsx;
        this.conj1 = conj1;
        this.marco = marco;
        this.sede = sede;
        this.quees = quees;
    }

    public Concurso() {
    }
    
    //Métodos:

    @Override
    public String toString() {
        return claveCo+" "+nombreConcurso;
    }

    //Getters & Setters:
    public int getClaveCo() {
        return claveCo;
    }

    public void setClaveCo(int claveCo) {
        this.claveCo = claveCo;
    }

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso) {
        this.nombreConcurso = nombreConcurso;
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

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public String getQuees() {
        return quees;
    }

    public void setQuees(String quees) {
        this.quees = quees;
    }
    
}