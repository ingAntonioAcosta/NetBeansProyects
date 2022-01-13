package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Conferencia {
    //Atributos:

    private int claveCo;
    private String nombreConf;
    private String marcoConf;
    private String nArchivo;
    private Date fechaI;
    private String quees;
    private int folioOficio;
    private String conj1;
    private int sede;

    //Constructores:
    public Conferencia() {
    }

    public Conferencia(int claveCo, String nombreConf, String marcoConf, String nArchivo, Date fechaI, String quees, int folioOficio, String conj1, int sede) {
        this.claveCo = claveCo;
        this.nombreConf = nombreConf;
        this.marcoConf = marcoConf;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.quees = quees;
        this.folioOficio = folioOficio;
        this.conj1 = conj1;
        this.sede = sede;
    }

    //Métodos:
    //Getters & Setters:

    public int getClaveCo() {
        return claveCo;
    }

    public void setClaveCo(int claveCo) {
        this.claveCo = claveCo;
    }

    public String getNombreConf() {
        return nombreConf;
    }

    public void setNombreConf(String nombreConf) {
        this.nombreConf = nombreConf;
    }

    public String getMarcoConf() {
        return marcoConf;
    }

    public void setMarcoConf(String marcoConf) {
        this.marcoConf = marcoConf;
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

    public String getConj1() {
        return conj1;
    }

    public void setConj1(String conj1) {
        this.conj1 = conj1;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        
        return claveCo+" / "+nombreConf+" / "+marcoConf+" / "+nArchivo+" / "+fechaI+" / "+quees+" / "+folioOficio+" / "+conj1+" / "+sede;
        
    }
        
}
