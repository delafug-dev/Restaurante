package bbdd;

import modelos.CuentaPDF;
import modelos.TotalesComanda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static bbdd.Configuracion.cerrarConexion;
import static bbdd.Configuracion.conectarConBD;

public class CuentaBD {

    public static CuentaPDF generarObjetoCuenta(int idComanda) {

        Connection con = conectarConBD();
        CuentaPDF cuenta = new CuentaPDF();
        List<TotalesComanda> totalesComanda = new ArrayList<>();

        try {
            PreparedStatement query = con.prepareStatement("select * from pedido where  mesa = ? ");
            query.setInt(1,idComanda);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                if(cuenta.getNum_mesa() == null){
                    cuenta.setNum_mesa(rs.getString("num_mesa"));
                }
                if(cuenta.getNombre_camarero() == null){
                    cuenta.setNombre_camarero(rs.getString("camarero"));
                }

                TotalesComanda t = new TotalesComanda();
                t.setNombre_producto(rs.getString("nombre_producto"));
                t.setCantidad_pedida(rs.getInt("cantidad_pedida"));
                t.setPrecio_total(rs.getDouble("total"));
                totalesComanda.add(t);
            }

            cuenta.setTotalesComandas(totalesComanda);
            cuenta.setTotalCuenta(cuenta.getTotalesComandas().stream().mapToDouble(TotalesComanda::getPrecio_total).sum());


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return cuenta;
    }

}
