package bbdd;

import modelos.Mesa;
import modelos.ModeloEmpleado;
import modelos.ModeloPedido;
import modelos.Producto;
import windows.camarero.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static bbdd.Configuracion.cerrarConexion;
import static bbdd.Configuracion.conectarConBD;

public class PedidoBD extends Configuracion{
    public static void crearActualizarPedido(ModeloPedido p) {

        List<ModeloPedido> pedidoBD = obtenerPormesa(p.getMesa());
        for (ModeloPedido mp : pedidoBD) {
            if (pedidoBD.size() == 0) {
                crearPedido(mp);
            } else if (mp.getProducto() != null) {
                actualizarPedido(mp);
            }

        }
    }
    public static void crearPedido(ModeloPedido pedido){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into pedido ( id_mesa, id_camarero, id_producto, cantidad)" +
                    "values(?,?, ?,?)");

            insert.setInt(1, pedido.getMesa().getId());
            insert.setInt(2, pedido.getCamarero().getId());
            insert.setInt(3, pedido.getProducto().getId());
            insert.setInt(4, pedido.getCantidad());


            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }
    public static List<ModeloPedido> obtenerPormesa(Mesa mesa) {

        Connection con = conectarConBD();
        ModeloPedido num_mesa = null;
        List<ModeloPedido> lista_mesa = new ArrayList<>();

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM pedido where id_mesa = ?  ");
            query.setInt(1, mesa.getId());
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                Mesa m = MesasBD.obtenerPorId(rs.getInt("id_mesa"));
                ModeloEmpleado em =  EmpleadoBD.obtenerPorId(rs.getInt("id_camarero"));
                Producto p = Productobd.obtenerPorId(rs.getInt("id_producto"));
                num_mesa = new ModeloPedido( m ,em,p , rs.getInt("cantidad"));

                lista_mesa.add(num_mesa);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return lista_mesa;
    }

    public static void eliminarPedidos(ModeloPedido mesa){
        Connection con = conectarConBD();

        try {
            PreparedStatement delete = con.prepareStatement("delete from pedido where id_mesa = ? ");

            delete.setInt(1, mesa.getMesa().getId());

            //Ejecución del delete
            delete.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }
    public static void eliminarPedidosProducto(ModeloPedido producto){
        Connection con = conectarConBD();

        try {
            PreparedStatement delete = con.prepareStatement("delete from pedido where id_producto = ? and id_mesa = ?");

            delete.setInt(1, producto.getProducto().getId());
            delete.setInt(2, producto.getMesa().getId());

            //Ejecución del delete
            delete.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }
    public static void actualizarPedido(ModeloPedido productoMesa){
        Connection con = conectarConBD();
        try {
            PreparedStatement update = con.prepareStatement("update pedido " +
                    "set  id_camarero = ?, cantidad = ?" +
                    "where id_mesa = ? and id_producto = ?");

            update.setInt(1, productoMesa.getCamarero().getId());
            update.setInt(2, productoMesa.getCantidad());
            update.setInt(3, productoMesa.getMesa().getId());
            update.setInt(4, productoMesa.getProducto().getId());


            //Ejecución del update
            update.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }




}
