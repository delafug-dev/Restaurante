package windows.cliente;

import bbdd.Productobd;
import modelos.Producto;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

import static windows.Window.pantalla;

public class Cliente extends JFrame{

    private static final ImageIcon imagenFondo = rutaDeImagen();
    JPanel panelPrincipal = crearPanelImagenFondo();

    public  Cliente() {

        // Panel por pestañas
        JTabbedPane pestayas = new JTabbedPane();
        pestayas.setOpaque(false);

        //Obtenemos los productos
        List<Producto> listaProductos = Productobd.obtenerProductos();
        // Map<TipoProducto, List<Producto>> productosPorTipo = listaProductos.stream().collect(Collectors.groupingBy(Producto::getTipoProducto));


        panelPrincipal.add(pestayas);

        // CONFIGURACION CARTA
        setResizable(false);
        setContentPane(panelPrincipal);
        setSize(pantalla);
        setVisible(true);
    }


    private static ImageIcon rutaDeImagen(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\fondoCarta.jpg";
        ImageIcon imagenCarta = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenCarta.getImage()
                .getScaledInstance(1400,pantalla.height, Image.SCALE_SMOOTH);
        imagenCarta.setImage(cambiar_tamayo);
        return imagenCarta;
    }

    private static JPanel crearPanelImagenFondo(){
        JPanel panel = new JPanel(new BorderLayout()){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo.getImage(), 0, 0, null);
            }
        };
        return panel;
    }
}

