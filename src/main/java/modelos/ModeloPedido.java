package modelos;

import java.util.Objects;

public class ModeloPedido {
    private int id;
    private String mesa;
    private int camarero;
    private String producto;
    private int cantidad;

    public ModeloPedido(int id, String mesa, int camarero, String producto, int cantidad) {
        this.id = id;
        this.mesa = mesa;
        this.camarero = camarero;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ModeloPedido() {
    }

    public ModeloPedido(String mesa) {
        this.mesa = mesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public int getCamarero() {
        return camarero;
    }

    public void setCamarero(int camarero) {
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
        ModeloPedido pedido = (ModeloPedido) o;
        return id == pedido.id && camarero == pedido.camarero && cantidad == pedido.cantidad && Objects.equals(mesa, pedido.mesa) && Objects.equals(producto, pedido.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mesa, camarero, producto, cantidad);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", mesa='" + mesa + '\'' +
                ", camarero=" + camarero +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
