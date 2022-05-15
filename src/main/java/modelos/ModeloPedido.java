package modelos;

import java.util.Objects;

public class ModeloPedido {
    private int id;
    private int mesa;
    private String camarero;
    private String producto;
    private int cantidad;

    public ModeloPedido(int id, int mesa, String camarero, String producto, int cantidad) {
        this.id = id;
        this.mesa = mesa;
        this.camarero = camarero;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ModeloPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getCamarero() {
        return camarero;
    }

    public void setCamarero(String camarero) {
        this.camarero = camarero;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloPedido that = (ModeloPedido) o;
        return id == that.id && mesa == that.mesa && cantidad == that.cantidad && Objects.equals(camarero, that.camarero) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mesa, camarero, producto, cantidad);
    }

    @Override
    public String toString() {
        return "ModeloPedido{" +
                "id=" + id +
                ", mesa=" + mesa +
                ", camarero='" + camarero + '\'' +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
