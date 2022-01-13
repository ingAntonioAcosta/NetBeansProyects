package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Evento {
    //Atributos:

    private int claveEv;
    private String nombreEv;
    private String conj1;
    private String marco;
    private String nArchivo;
    private Date fechaI;
    private Date fechaF;
    private int horas;
    private int folioOficio;
    private String quees;
    private String llevado;
    private int sede;
    private String obsx;
    
    private String sedeDesc;

    //Constructores:

    public Evento(int claveEv, String nombreEv, String conj1, String marco, String nArchivo, Date fechaI, Date fechaF, int horas, int folioOficio, String quees, String llevado, int sede, String obsx, String sedeDesc) {
        this.claveEv = claveEv;
        this.nombreEv = nombreEv;
        this.conj1 = conj1;
        this.marco = marco;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.horas = horas;
        this.folioOficio = folioOficio;
        this.quees = quees;
        this.llevado = llevado;
        this.sede = sede;
        this.obsx = obsx;
        this.sedeDesc = sedeDesc;
    }


    public Evento() {
    }

    //Métodos:
    @Override
    public String toString() {
        return "| nombre: " + nombreEv + " | marco: " + marco + " | fechaI: " + fechaI + " | fechaF: " + fechaF + " | horas: " + horas + " | quees: " + quees + " | sede: " + sede + '|';
    }

    //Getters & Setters:
    public int getClaveEv() {
        return claveEv;
    }

    public void setClaveEv(int claveEv) {
        this.claveEv = claveEv;
    }

    public String getNombreEv() {
        return nombreEv;
    }

    public void setNombreEv(String nombreEv) {
        this.nombreEv = nombreEv;
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

    public String getQuees() {
        return quees;
    }

    public void setQuees(String quees) {
        this.quees = quees;
    }

    public String getLlevado() {
        return llevado;
    }

    public void setLlevado(String llevado) {
        this.llevado = llevado;
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

    public String getSedeDesc() {
        return sedeDesc;
    }

    public void setSedeDesc(String sedeDesc) {
        this.sedeDesc = sedeDesc;
    }
    


}
