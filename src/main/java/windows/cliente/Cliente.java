package windows.cliente;

import bbdd.Productobd;
import modelos.Producto;
import modelos.Tipoproducto;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static windows.Window.pantalla;

public class Cliente extends JFrame{

    private static final ImageIcon imagenFondo = rutaDeImagen();
    JPanel panelPrincipal = crearPanelImagenFondo();

    public  Cliente() {

        // Panel por pestañas
        JTabbedPane pestayas = new JTabbedPane();

        //Obtenemos los productos
        List<Producto> listaProductos = Productobd.obtenerProductos();
        Map<Tipoproducto, List<Producto>> productosPorTipo = listaProductos.stream().collect(Collectors.groupingBy(Producto::getTipoproducto));

        for (Tipoproducto tipoProducto : productosPorTipo.keySet()) {
            JPanel panelpestana = new JPanel();
            panelpestana.setLayout(new BorderLayout());
            JPanel panelProductos = new JPanel(new GridLayout(0, 4));
            panelProductos.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 300));
            panelProductos.setOpaque(false);
            JLabel producto = new JLabel("Producto");
            JLabel pequeyo = new JLabel("Pequeño");
            JLabel mediano = new JLabel("Mediano");
            JLabel grande = new JLabel("Grande");
            panelProductos.add(producto);
            panelProductos.add(pequeyo);
            panelProductos.add(mediano);
            panelProductos.add(grande);

            for (Producto p : productosPorTipo.get(tipoProducto)) {
                JLabel nombreProducto = new JLabel(p.getDescripcion());
                nombreProducto.setForeground(Color.BLACK);
                nombreProducto.setFont(new Font("Comic Sans", Font.PLAIN, 24));
                JLabel precioPequenya = new JLabel(p.getPequenya() + "€");
                JLabel precioMedia = new JLabel(p.getMedia() + "€");
                JLabel precioGrande = new JLabel(p.getGrande() + "€");
                precioPequenya.setForeground(Color.BLACK);
                precioPequenya.setFont(new Font("Comic Sans", Font.PLAIN, 24));
                precioMedia.setForeground(Color.BLACK);
                precioMedia.setFont(new Font("Comic Sans", Font.PLAIN, 24));
                precioGrande.setForeground(Color.BLACK);
                precioGrande.setFont(new Font("Comic Sans", Font.PLAIN, 24));
                panelProductos.add(nombreProducto);
                panelProductos.add(precioPequenya);
                panelProductos.add(precioMedia);
                panelProductos.add(precioGrande);
            }
            panelpestana.add(panelProductos,BorderLayout.CENTER);
            pestayas.add(tipoProducto.toString(),panelpestana);

        }
        panelPrincipal.add(pestayas);
        panelPrincipal.setOpaque(false);

        // CONFIGURACION CARTA
        setResizable(false);
        setContentPane(panelPrincipal);
        setSize(pantalla);
        setVisible(true);
    }
    private static ImageIcon rutaDeImagen () {
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\fondoCarta.jpg";
        ImageIcon imagenCarta = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenCarta.getImage()
                .getScaledInstance(1400, pantalla.height, Image.SCALE_SMOOTH);
        imagenCarta.setImage(cambiar_tamayo);
        return imagenCarta;
    }

    public static JPanel crearPanelImagenFondo () {
        JPanel panel = new JPanel(new BorderLayout()) {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo.getImage(), 0, 0, null);
            }
        };
        return panel;
    }
}