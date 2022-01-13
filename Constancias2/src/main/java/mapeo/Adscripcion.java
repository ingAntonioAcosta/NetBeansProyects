package mapeo;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Adscripcion {

    //Atributos:
    private int adscr;
    private String adscrDescr;

    //Constructores:
    public Adscripcion() {
    }

    public Adscripcion(int adscr, String adscrDescr) {
        this.adscr = adscr;
        this.adscrDescr = adscrDescr;
    }

    
    //Métodos:
    @Override
    public String toString() {
        return adscr + " " + adscrDescr;
    }

    //Getters & Setters:
    public int getAdscr() {
        return adscr;
    }

    public void setAdscr(int adscr) {
        this.adscr = adscr;
    }

    public String getAdscrDescr() {
        return adscrDescr;
    }

    public void setAdscrDescr(String adscrDescr) {
        this.adscrDescr = adscrDescr;
    }

}
