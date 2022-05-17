package modelos;

import java.util.Objects;

public class ModeloPedido {
    private int id;
    private Mesa mesa;
    private ModeloEmpleado camarero;
    private Producto producto;
    private int cantidad;

    public ModeloPedido( Mesa mesa, ModeloEmpleado camarero, Producto producto, int cantidad) {
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

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ModeloEmpleado getCamarero() {
        return camarero;
    }

    public void setCamarero(ModeloEmpleado camarero) {
        this.camarero = camarero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ModeloPedido{" +
                "id=" + id +
                ", mesa=" + mesa +
                ", camarero=" + camarero +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
