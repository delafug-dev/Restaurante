package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
public class Configuracion {


        private static final String url = "jdbc:mariadb://34.134.230.192:3306/BBDDPedroAdrianMiguel";
        private static final String usuario = "alumno_safa_daw";
        private static final String password = "daw2122";


        static Connection conectarConBD() {
            Connection conexion;
            try {
                conexion = DriverManager.getConnection(url, usuario, password);
            } catch (Exception e) {
                System.out.println("Error en la conexión:" + e.toString());
                return null;
            }
            return conexion;
        }


        static void cerrarConexion(Connection con) {
            try {
                // Cerramos conexiones
                if (con !=null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error cerrando conexiones: "
                        + e.toString());
            }
        }

    }

