package modelos;

import java.util.Objects;

public class Producto {
    private int id;
    private String descripcion;
    private int tipo;
    private Tipoproducto tipoproducto;

    public Producto(int id, String descripcion, int tipo, Tipoproducto tipoproducto) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.tipoproducto = tipoproducto;
    }
    public Producto( String descripcion, int tipo, Tipoproducto tipoproducto) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.tipoproducto = tipoproducto;
    }

    public Producto() {
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && tipo == producto.tipo && Objects.equals(descripcion, producto.descripcion) && tipoproducto == producto.tipoproducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, tipo, tipoproducto);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", tipo=" + tipo +
                ", tipoproducto=" + tipoproducto +
                '}';
    }
}
