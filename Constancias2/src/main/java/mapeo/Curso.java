package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Curso {
    //Atributos:

    private int claveC;
    private String nombreCurso;
    private String nArchivo;
    private Date fechaI;
    private Date fechaF;
    private int horas;
    private int folioOficio;
    private String obsx;
    private String turno;
    private int sede;

    //Constructores:
    public Curso(int claveC, String nombreCurso, String nArchivo, Date fechaI, Date fechaF, int horas, int folioOficio, String obsx, String turno, int sede) {
        this.claveC = claveC;
        this.nombreCurso = nombreCurso;
        this.nArchivo = nArchivo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.horas = horas;
        this.folioOficio = folioOficio;
        this.obsx = obsx;
        this.turno = turno;
        this.sede = sede;
    }

    //Métodos:
    //Getters & Setters:
    public Curso() {
    }

    public int getClaveC() {
        return claveC;
    }

    public void setClaveC(int claveC) {
        this.claveC = claveC;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return claveC + " | " + nombreCurso + " | " + fechaI + " | " + fechaF + " | " + horas + " | " + turno + " | " + sede;
    }

}
