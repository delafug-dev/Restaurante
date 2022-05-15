package windows.camarero;

import bbdd.MesasBD;
import modelos.Mesa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import static windows.Window.pantalla;

public class Cuenta extends JFrame{

    private static final Font fuente = new Font("Arial", Font.ITALIC | Font.BOLD, 45);

    private static final ImageIcon imagenFondo = rutaDeImagen();
    JPanel panelPrincipal = crearPanelImagenFondo();

    public Cuenta(){
        // JPANELS
        JPanel panelParaBotonPDF = new JPanel();
        panelParaBotonPDF.setBounds(300,350,800,180);
        panelParaBotonPDF.setOpaque(false);
        JLabel mesaLabel = mesaLabel();
        JComboBox mesas = rellenarComboMesas();
        mesas.setPreferredSize(new Dimension(250,100));
        JButton pdfCuenta = crearBotonPDF();
        pdfCuenta.setPreferredSize(new Dimension(250,100));
        panelParaBotonPDF.add(mesaLabel);
        panelParaBotonPDF.add(mesas);
        panelParaBotonPDF.add(pdfCuenta);



        JPanel panelFondo = crearPanelImagenFondo();

        panelPrincipal.add(panelParaBotonPDF);
        panelPrincipal.add(panelFondo);

        // CONFIGURACION WINDOW_COMANDA
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

    private static JButton crearBotonPDF (){
        JButton generarPDF = new JButton("CUENTA TOTAL");
        /** generarPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        }); **/
        return generarPDF;
    }

    private JComboBox rellenarComboMesas(){
        JComboBox comboBox = new JComboBox<>();
        List<Mesa> mesa = MesasBD.obtenerMesapedido();
        for(Mesa m : mesa){
            comboBox.addItem(m.getNum_mesa());
        }
        return comboBox;
    }

    public static JLabel mesaLabel(){
        JLabel id = new JLabel();
        id.setFont(fuente);
        id.setText("MESA");
        id.setForeground(Color.WHITE);
        return id;
    }

}
