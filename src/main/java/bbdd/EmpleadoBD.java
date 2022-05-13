package bbdd;

import modelos.ModeloEmpleado;
import windows.administrator.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoBD extends Configuracion {

    public static ModeloEmpleado obtenerPorId(Integer id) {

        Connection con = conectarConBD();
        ModeloEmpleado empleado = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM empleado where id = ?  ");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                empleado = new ModeloEmpleado(rs.getInt("id"), rs.getString("codigo_empleado"), rs.getString("nombre"), rs.getString("apellidos"));
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return empleado;
    }

    public static List<ModeloEmpleado> obtenerEmpleadopedido() {

        Connection con = conectarConBD();
        ModeloEmpleado empleado = null;
        List<ModeloEmpleado> empl = new ArrayList<>();

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM empleado  ");
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                empleado = new ModeloEmpleado(rs.getInt("id"), rs.getString("codigo_empleado"), rs.getString("nombre"), rs.getString("apellidos"));
                empl.add(empleado);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return empl;
    }



    public static void crearActualizarEmpleado(ModeloEmpleado empleado){

        ModeloEmpleado empBaseDatos = obtenerPorId(empleado.getId());

        if(empBaseDatos != null){
            actualizarEmpleado(empleado);
        }else{
            crearEmpleado(empleado);
        }
    }


    public static void crearEmpleado(ModeloEmpleado empleado){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into empleado (id, codigo_empleado, nombre, apellidos)" +
                    "values(?,?,?,?)");

            insert.setInt(1, empleado.getId());
            insert.setString(2,empleado.getCodigoEmpleado());
            insert.setString(3,empleado.getNombre());
            insert.setString(4, empleado.getApellidos());

            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


    public static void actualizarEmpleado(ModeloEmpleado empleado){
        Connection con = conectarConBD();

        try {
            PreparedStatement update = con.prepareStatement("update empleado " +
                    "set codigo_empleado = ? , nombre = ? , apellidos = ?" +
                    "where id = ? ");

            update.setString(1,empleado.getCodigoEmpleado());
            update.setString(2,empleado.getNombre());
            update.setString(3, empleado.getApellidos());
            update.setInt(4, empleado.getId());


            //Ejecución del update
            update.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


    public static void eliminarEmpleado(ModeloEmpleado empleado){
        Connection con = conectarConBD();

        try {
            PreparedStatement delete = con.prepareStatement("delete from empleado where id = ? ");

            delete.setInt(1, empleado.getId());

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