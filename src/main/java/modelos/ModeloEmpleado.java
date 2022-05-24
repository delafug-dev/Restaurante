package modelos;

import java.util.Objects;

public class ModeloEmpleado {
    private int id;
    private String codigoEmpleado;
    private String nombre;
    private String apellidos;

    public ModeloEmpleado() {
    }

    public ModeloEmpleado(int id, String codigoEmpleado, String nombre, String apellidos) {
        this.id = id;
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloEmpleado that = (ModeloEmpleado) o;
        return id == that.id && Objects.equals(codigoEmpleado, that.codigoEmpleado) && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoEmpleado, nombre, apellidos);
    }

    @Override
    public String toString() {
        return nombre;
    }

}
