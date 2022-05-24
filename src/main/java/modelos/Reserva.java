package modelos;

import java.util.Date;
import java.util.Objects;

public class Reserva {
    private int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private int num_comensales;
    private Date fecha;

    public Reserva() {
    }

    public Reserva(int id, String nombre, String apellidos, String telefono, int num_comensales, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.num_comensales = num_comensales;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNum_comensales() {
        return num_comensales;
    }

    public void setNum_comensales(int num_comensales) {
        this.num_comensales = num_comensales;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id == reserva.id && num_comensales == reserva.num_comensales && Objects.equals(nombre, reserva.nombre) && Objects.equals(apellidos, reserva.apellidos) && Objects.equals(telefono, reserva.telefono) && Objects.equals(fecha, reserva.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, telefono, num_comensales, fecha);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", num_comensales=" + num_comensales +
                ", fecha=" + fecha +
                '}';
    }
}
