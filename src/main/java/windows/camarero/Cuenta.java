package windows.camarero;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static windows.Window.pantalla;

public class Cuenta extends JFrame{

    private static final ImageIcon imagenFondo = rutaDeImagen();
    JPanel panelPrincipal = crearPanelImagenFondo();

    public Cuenta(){
        // JPANELS
        JPanel panelCuenta = new JPanel();
        panelCuenta.setLayout(new GridLayout(1,0));
        panelCuenta.setBounds(275,160,700,220);


        //TABLA COMANDA
        Object[] columnas = {"Número Mesa",
                "Pedido Finalizado"};
        Object[][] datos = {{"","",""}};
        JTable tablaCuenta = new JTable(datos , columnas);

        //PANEL TABLA COMANDA
        JScrollPane scrollPane = new JScrollPane(tablaCuenta);
        tablaCuenta.setFillsViewportHeight(true);

        JPanel panelFondo = crearPanelImagenFondo();

        panelCuenta.add(scrollPane);
        panelPrincipal.add(panelCuenta);
        panelPrincipal.add(panelFondo);

        // CONFIGURACION WINDOW_COMANDA
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(panelPrincipal);
        setSize(pantalla);
        setVisible(true);
    }

    private static ImageIcon rutaDeImagen(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\comandasCocinero.jpg";
        ImageIcon imagenCocinero = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenCocinero.getImage()
                .getScaledInstance(1400,pantalla.height, Image.SCALE_SMOOTH);
        imagenCocinero.setImage(cambiar_tamayo);
        return imagenCocinero;
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