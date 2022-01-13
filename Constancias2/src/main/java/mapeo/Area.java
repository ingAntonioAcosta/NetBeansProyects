package mapeo;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class Area {

    //Atributos:
    private int area;
    private String areaDescr;

    //Constructores:
    public Area() {
    }

    public Area(int area, String areaDescr) {
        this.area = area;
        this.areaDescr = areaDescr;
    }

    //Métodos:
    //Getters & Setters:
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAreaDescr() {
        return areaDescr;
    }

    public void setAreaDescr(String areaDescr) {
        this.areaDescr = areaDescr;
    }

    @Override
    public String toString() {
        return area + " : " + areaDescr;
    }

}
