import bbdd.CuentaBD;
import modelos.CuentaPDF;
import utilidades.UtilidadesPDF;
import windows.Window;
import windows.camarero.Cuenta;

public class App {

    public static void main(String[] args) {

        // new Window();

        CuentaPDF cuenta = CuentaBD.generarObjetoCuenta(1);
        UtilidadesPDF.GenerarCuentaPDF(cuenta);
    }
}