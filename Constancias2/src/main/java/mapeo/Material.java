package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Material {

    //Atributos:
    private int claveM;
    private String nombreMaterial;
    private String nArchivo;
    private int folioOficio;
    private String obsx;
    private Date fechaI;
    private Date fechaF;
    private int sede;

    //Constructores:
    public Material() {
    }

    public Material(int claveM, String nombreMaterial, String nArchivo, int folioOficio, String obsx, Date fechaI, Date fechaF, int sede) {
        this.claveM = claveM;
        this.nombreMaterial = nombreMaterial;
        this.nArchivo = nArchivo;
        this.folioOficio = folioOficio;
        this.obsx = obsx;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.sede = sede;
    }

    //Métodos:
    @Override
    public String toString() {
        return "| claveM: " + claveM + " | nombreMaterial: " + nombreMaterial + " | obsx: " + obsx + " | fechaI: " + fechaI + " | fechaF: " + fechaF + " | sede: " + sede +" |";
    }

    //Getters & Setters:
    public int getClaveM() {
        return claveM;
    }

    public void setClaveM(int claveM) {
        this.claveM = claveM;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getnArchivo() {
        return nArchivo;
    }

    public void setnArchivo(String nArchivo) {
        this.nArchivo = nArchivo;
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
