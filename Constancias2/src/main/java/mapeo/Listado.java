package mapeo;

import java.sql.Date;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Listado {

    //Atributos:
    private int numero;
    private Date fecha;
    private String desc;

    //Constructores:
    public Listado() {
    }

    public Listado(int numero, Date fecha, String desc) {
        this.numero = numero;
        this.fecha = fecha;
        this.desc = desc;
    }

    //Métodos:
    //Getters & Setters:

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return numero + " {" + fecha + " / " + desc+"}";
    }
    
}
