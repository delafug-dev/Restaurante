package modelos;

import java.util.Objects;

public class TipoTamañoProducto {
    private int id;
    private double pequenya;
    private double media;
    private double grande;

    public TipoTamañoProducto(int id, double pequenya, double media, double grande) {
        this.id = id;
        this.pequenya = pequenya;
        this.media = media;
        this.grande = grande;
    }

    public TipoTamañoProducto(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPequenya() {
        return pequenya;
    }

    public void setPequenya(double pequenya) {
        this.pequenya = pequenya;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getGrande() {
        return grande;
    }

    public void setGrande(double grande) {
        this.grande = grande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTamañoProducto that = (TipoTamañoProducto) o;
        return id == that.id && Double.compare(that.pequenya, pequenya) == 0 && Double.compare(that.media, media) == 0 && Double.compare(that.grande, grande) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pequenya, media, grande);
    }

    @Override
    public String toString() {
        return "TipoTamañoProducto{" +
                "id=" + id +
                ", pequenya=" + pequenya +
                ", media=" + media +
                ", grande=" + grande +
                '}';
    }
}
