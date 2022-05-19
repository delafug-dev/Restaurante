package modelos;
import java.util.Objects;

public class TotalesComanda {

    private String nombre_producto;
    private Integer cantidad_pedida;
    private Double precio_total;
    private Double precio;

    public TotalesComanda() {
    }

    public TotalesComanda(String nombre_producto, Integer cantidad_pedida, Double precio_total, Double precio) {
        this.nombre_producto = nombre_producto;
        this.cantidad_pedida = cantidad_pedida;
        this.precio_total = precio_total;
        this.precio = precio;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Integer getCantidad_pedida() {
        return cantidad_pedida;
    }

    public void setCantidad_pedida(Integer cantidad_pedida) {
        this.cantidad_pedida = cantidad_pedida;
    }

    public Double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Double precio_total) {
        this.precio_total = precio_total;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalesComanda that = (TotalesComanda) o;
        return Objects.equals(nombre_producto, that.nombre_producto) && Objects.equals(cantidad_pedida, that.cantidad_pedida) && Objects.equals(precio_total, that.precio_total) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre_producto, cantidad_pedida, precio_total, precio);
    }

    @Override
    public String toString() {
        return "TotalesComanda{" +
                "nombre_producto='" + nombre_producto + '\'' +
                ", cantidad_pedida=" + cantidad_pedida +
                ", precio_total=" + precio_total +
                ", precio=" + precio +
                '}';
    }
}
