package mapeo;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Profesor {
    //Atributos:

    private int claveNE;
    private String rfc;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String titulo;
    private int categoria;
    private String sexo;
    private String email;
    private int area;
    private int adscr;
    private String ingreso;
    private String estatus;
    private int marca;

    //Constructores:
    public Profesor() {
    }

    public Profesor(int claveNE, String rfc, String nombre, String apellidoP, String apellidoM, String titulo, int categoria, String sexo, String email, int area, int adscr, String ingreso, String estatus, int marca) {
        this.claveNE = claveNE;
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.titulo = titulo;
        this.categoria = categoria;
        this.sexo = sexo;
        this.email = email;
        this.area = area;
        this.adscr = adscr;
        this.ingreso = ingreso;
        this.estatus = estatus;
        this.marca = marca;
    }

    //Métodos:
    //Getters & Setters:
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getAdscr() {
        return adscr;
    }

    public void setAdscr(int adscr) {
        this.adscr = adscr;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return claveNE + " " + apellidoP 
                + " " + apellidoM + " " + nombre + " " 
                +" area: "+ area+" ads: " +adscr;
    }
}
