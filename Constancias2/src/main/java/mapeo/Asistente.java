package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Asistente {

    //Atributos:
    private int folio;
    private Date fechaE;
    private Date entregado;
    private String reposicion;
    private String entrega;
    private String email;
    private int claveNE;
    private String rfc;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String tipoP;

    //Constructores:
    public Asistente() {
    }

    public Asistente(int folio, Date fechaE, Date entregado, String reposicion, String entrega, String email, int claveNE, String rfc, String nombre, String apellidoP, String apellidoM, String tipoP) {
        this.folio = folio;
        this.fechaE = fechaE;
        this.entregado = entregado;
        this.reposicion = reposicion;
        this.entrega = entrega;
        this.email = email;
        this.claveNE = claveNE;
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoP = tipoP;
    }

    //Métodos:
    //Getters & Setters:
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClaveNE() {
        return claveNE;
    }

    public void setClaveNE(int claveNE) {
        this.claveNE = claveNE;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

}
