package bbdd;
import modelos.Libre;
import modelos.Mesa;
import modelos.Producto;
import modelos.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaBD extends Configuracion{

    public static void crearReserva(Reserva reserva){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into reserva (nombre, apellidos, telefono, num_comensales, fecha)" +
                    "values(?,?,?,?,?)");

            insert.setString(1, reserva.getNombre());
            insert.setString(2,reserva.getApellidos());
            insert.setString(3, reserva.getTelefono());
            insert.setInt(4, reserva.getNum_comensales());
            insert.setDate(5, (Date) reserva.getFecha());
            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }

    public static List<Reserva> obtenerReservas() {

        Connection con = conectarConBD();
        List<Reserva> ListaReservas = new ArrayList<>();

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM reserva ");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva( rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"), rs.getInt("num_comensales"), rs.getDate("fecha"));
                ListaReservas.add(reserva);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return ListaReservas;
    }

    public static void actualizarReserva(Reserva reserva){
        Connection con = conectarConBD();
        try {
            PreparedStatement update = con.prepareStatement("update reserva " +
                    "set nombre = ? , apellidos = ?, telefono = ?, num_comensales = ?, fecha = ? " +
                    "where id = ? ");

            update.setString(1, reserva.getNombre());
            update.setString(2, reserva.getApellidos());
            update.setString(3, reserva.getTelefono());
            update.setInt(4, reserva.getNum_comensales());
            update.setDate(5, (Date) reserva.getFecha());
            update.setInt(6, reserva.getId());

            //Ejecución del update
            update.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }

    public static void eliminarReserva(Reserva reserva){
        Connection con = conectarConBD();

        try {
            PreparedStatement delete = con.prepareStatement("delete from reserva where id = ? ");

            delete.setInt(1, reserva.getId());

            //Ejecución del delete
            delete.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


}

