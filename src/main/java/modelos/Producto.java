package modelos;

import java.util.Objects;

public class Producto {
    private int id;
    private String descripcion;
    private int tamayo;
    private Tipoproducto tipoproducto;
    private double pequenya;
    private double media;
    private double grande;

    public Producto(int id, String descripcion, int tamayo, Tipoproducto tipoproducto, double pequenya, double media, double grande) {
        this.id = id;
        this.descripcion = descripcion;
        this.tamayo = tamayo;
        this.tipoproducto = tipoproducto;
        this.pequenya = pequenya;
        this.media = media;
        this.grande = grande;
    }
    public Producto(String descripcion, int tamayo, Tipoproducto tipoproducto, double pequenya, double media, double grande) {
        this.descripcion = descripcion;
        this.tamayo = tamayo;
        this.tipoproducto = tipoproducto;
        this.pequenya = pequenya;
        this.media = media;
        this.grande = grande;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", tamayo=" + tamayo +
                ", tipoproducto=" + tipoproducto +
                ", pequenya=" + pequenya +
                ", media=" + media +
                ", grande=" + grande +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && tamayo == producto.tamayo && Double.compare(producto.pequenya, pequenya) == 0 && Double.compare(producto.media, media) == 0 && Double.compare(producto.grande, grande) == 0 && Objects.equals(descripcion, producto.descripcion) && tipoproducto == producto.tipoproducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, tamayo, tipoproducto, pequenya, media, grande);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTamayo() {
        return tamayo;
    }

    public void setTamayo(int tamayo) {
        this.tamayo = tamayo;
    }

    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
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
}
