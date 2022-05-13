package bbdd;

import modelos.Libre;
import modelos.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesasBD extends Configuracion{


    public static Mesa obtenerPorId(Integer id) {

        Connection con = conectarConBD();
        Mesa mesa = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM mesa where id = ?  ");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                mesa = new Mesa(rs.getInt("id"), rs.getInt("num_mesa"), rs.getInt("num_comensales"));
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return mesa;
    }

    public static List<Mesa> obtenerMesapedido() {

        Connection con = conectarConBD();
        Mesa mesa = null;
        List<Mesa> mesapedido = new ArrayList<>();

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM mesa");
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                mesa = new Mesa(rs.getInt("id"), rs.getInt("num_mesa"), rs.getInt("num_comensales"));
                mesapedido.add(mesa);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return mesapedido;
    }

    public static List<Mesa> obtenerProductos() {

        Connection con = conectarConBD();
        List<Mesa> mesas = new ArrayList<>();

        try {
            PreparedStatement query = con.prepareStatement("SELECT num_mesa, num_comensales FROM mesa ");
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                Mesa mesa = new Mesa(rs.getInt("id"), rs.getInt("num_mesa"),rs.getInt("num_comensales"));

            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return mesas;
    }


    public static void crearActualizarProducto(Mesa mesa){


        Mesa mesaBD = obtenerPorId(mesa.getId());

        if(mesaBD != null){
            actualizarProducto(mesa);
        }else{
            crearProducto(mesa);
        }
    }


    public static void crearProducto(Mesa mesa){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into mesa (id, num_mesa,num_comensales)" +
                    "values(?,?,?)");

            insert.setInt(1, mesa.getId());
            insert.setInt(2,mesa.getNum_mesa());
            insert.setInt(3, mesa.getNum_comensales());
            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


    public static void actualizarProducto(Mesa mesa){
        Connection con = conectarConBD();

        try {
            PreparedStatement update = con.prepareStatement("update mesa " +
                    "set num_mesa = ? , num_comensales = ? " +
                    "where id = ? ");

            update.setInt(1,mesa.getNum_mesa());
            update.setInt(2, mesa.getNum_comensales());
            update.setInt(3, mesa.getId());


            //Ejecución del update
            update.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


    public static void eliminarProducto(Mesa mesa){
        Connection con = conectarConBD();

        try {
            PreparedStatement delete = con.prepareStatement("delete from mesa where id = ? ");

            delete.setInt(1, mesa.getId());

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

