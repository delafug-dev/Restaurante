package modelos;

import java.util.Objects;

public class Mesa {
    private int id;
    private int num_mesa;
    private int num_comensales;

    public Mesa(int id, int num_mesa, int num_comensales) {
        this.id = id;
        this.num_mesa = num_mesa;
        this.num_comensales = num_comensales;
    }

    public Mesa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public int getNum_comensales() {
        return num_comensales;
    }

    public void setNum_comensales(int num_comensales) {
        this.num_comensales = num_comensales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return id == mesa.id && num_mesa == mesa.num_mesa && num_comensales == mesa.num_comensales;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num_mesa, num_comensales);
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", num_mesa=" + num_mesa +
                ", num_comensales=" + num_comensales +
                '}';
    }
}
