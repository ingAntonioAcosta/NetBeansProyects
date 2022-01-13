package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Constancia {
    //Atributos:

    private String tipo;
    private int claveC;
    private int claveNE;
    private int folio;
    private String realizada;
    private Date fechaE;
    private String tipoP;
    private String enlace;
    private Date entregado;
    private String reposicion;
    private String entrega;

    private String nombreProfesor;
    private String nombreEvento;
    private int listado = 0;

    //Constructores:
    public Constancia() {
    }

    public Constancia(String tipo, int claveC, int claveNE, int folio, String realizada, Date fechaE, String tipoP, String enlace, Date entregado, String reposicion, String entrega, String nombreProfesor, String nombreEvento, int listado) {
        this.tipo = tipo;
        this.claveC = claveC;
        this.claveNE = claveNE;
        this.folio = folio;
        this.realizada = realizada;
        this.fechaE = fechaE;
        this.tipoP = tipoP;
        this.enlace = enlace;
        this.entregado = entregado;
        this.reposicion = reposicion;
        this.entrega = entrega;
        this.nombreProfesor = nombreProfesor;
        this.nombreEvento = nombreEvento;
        this.listado = listado;
    }

    //Métodos:
    //Getters & Setters:
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getClaveC() {
        return claveC;
    }

    public void setClaveC(int claveC) {
        this.claveC = claveC;
    }

    public int getClaveNE() {
        return claveNE;
    }

    public void setClaveNE(int claveNE) {
        this.claveNE = claveNE;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getRealizada() {
        return realizada;
    }

    public void setRealizada(String realizada) {
        this.realizada = realizada;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Date getEntregado() {
        return entregado;
    }

    public void setEntregado(Date entregado) {
        this.entregado = entregado;
    }

    public String getReposicion() {
        return reposicion;
    }

    public void setReposicion(String reposicion) {
        this.reposicion = reposicion;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getListado() {
        return listado;
    }

    public void setListado(int listado) {
        this.listado = listado;
    }

    @Override
    public String toString() {
        return folio + " {"
                + "  -  " + claveNE + ":" + nombreProfesor
                + tipo + ":" + claveC
                + "  -  " + tipoP + " " + nombreEvento
                + "  -  " + fechaE + "}";
    }

}
