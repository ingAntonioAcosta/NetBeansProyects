

package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *  
 */

public class Seminario {
    //Atributos:

    private int claveS; 
    private String nArchivo; 
    private Date fechaI;
    private Date fechaF;
    private int horas;
    private int folioOficio; 
    private String nombreSeminario;
    private String obsx;
    private int sede;
    
    //Constructores:

    public Seminario(int claveS, String nArchivo, Date fechaI, Date fechaF, int horas, int folioOficio, String nombreSeminario, String obsx, int sede) {
        this.claveS = claveS;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.horas = horas;
        this.folioOficio = folioOficio;
        this.nombreSeminario = nombreSeminario;
        this.obsx = obsx;
        this.sede = sede;
    }
    
    public Seminario() {
    }

    //Métodos:

    @Override
    public String toString() {
        return claveS+" "+nombreSeminario;
    }
    
   

        

    //Getters & Setters:

    public int getClaveS() {
        return claveS;
    }

    public void setClaveS(int claveS) {
        this.claveS = claveS;
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

    public String getNombreSeminario() {
        return nombreSeminario;
    }

    public void setNombreSeminario(String nombreSeminario) {
        this.nombreSeminario = nombreSeminario;
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
