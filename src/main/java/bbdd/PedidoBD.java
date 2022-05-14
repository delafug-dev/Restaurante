package bbdd;

import modelos.ModeloPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static bbdd.Configuracion.cerrarConexion;
import static bbdd.Configuracion.conectarConBD;

public class PedidoBD extends Configuracion{
    public static void crearPedido(ModeloPedido pedido){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into pedido (id, mesa,camarero, producto, cantidad)" +
                    "values(?,?,?, ?,?)");

            insert.setInt(1, pedido.getId());
            insert.setString(2, pedido.getMesa());
            insert.setString(3, pedido.getCamarero());
            insert.setString(4, pedido.getProducto());
            insert.setInt(5, pedido.getCantidad());


            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }

}
