package modelos;

import java.util.Objects;

public class Mesa {
    private int id;
    private int num_mesa;
    private Libre libre;

    public Mesa(int id, int num_mesa, Libre libre) {
        this.id = id;
        this.num_mesa = num_mesa;
        this.libre = libre;
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

    public Libre getLibre() {
        return libre;
    }

    public void setLibre(Libre libre) {
        this.libre = libre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return id == mesa.id && num_mesa == mesa.num_mesa && libre == mesa.libre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num_mesa, libre);
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", num_mesa=" + num_mesa +
                ", libre=" + libre +
                '}';
    }
}
