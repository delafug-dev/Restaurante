package windows.cocinero;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

import static windows.Window.pantalla;

public class Window_Comanda extends JFrame {

    private static final ImageIcon imagenFondo = rutaDeImagen();
    JPanel panelPrincipal = crearPanelImagenFondo();

    public Window_Comanda (){

        // JPANELS
        JPanel comandaPanel = new JPanel();
        comandaPanel.setLayout(new GridLayout(1,0));
        comandaPanel.setBounds(350,160,500,50);

        //TABLA COMANDA
        Object[] columnas = {"Producto",
                "Cantidad"};
        Object[][] datos = {{"","",""}};
        JTable tablaComanda = new JTable(datos , columnas);

        //PANEL TABLA COMANDA
        JScrollPane scrollPane = new JScrollPane(tablaComanda);
        tablaComanda.setFillsViewportHeight(true);

        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new GridLayout(1,0));
        panelTabla.setBounds(200,280,800,300);
        panelTabla.add(scrollPane);
        JPanel panelFondo =  crearPanelImagenFondo();

        // JCOMBO
        JComboBox comboMesa = new JComboBox();
        JLabel etiquetaComboMesa = new JLabel("MESA");
        etiquetaComboMesa.setOpaque(false);
        rellenarComboMesa(comboMesa);

        // JBUTTON
        JButton buscarComanda = buscarComanda();
        JButton addCantidad = addCantidad();
        JButton quitarCantidad = quitarCantidad();


        comandaPanel.add(etiquetaComboMesa);
        comandaPanel.add(comboMesa);
        comandaPanel.add(buscarComanda);

        panelPrincipal.add(comandaPanel);
        panelPrincipal.add(panelTabla);
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

    private void rellenarComboMesa (JComboBox comboBox){
        comboBox.addItem("Mesa 1");
        comboBox.addItem("Mesa 2");
        comboBox.addItem("Mesa 3");
        comboBox.addItem("Mesa 4");
        comboBox.addItem("Mesa 5");
        comboBox.addItem("Mesa 6");
        comboBox.addItem("Mesa 7");
        comboBox.addItem("Mesa 8");
    }

    private static JButton buscarComanda (){
        JButton buscarComanda = new JButton("BUSCAR");
        buscarComanda.setForeground(Color.WHITE);
        buscarComanda.setBackground(Color.darkGray);
        Border line = new LineBorder(Color.WHITE);
        buscarComanda.setBorder(line);

        return buscarComanda;
    }

    private static JButton addCantidad (){
        JButton addCantidad = new JButton("+");

        return addCantidad;
    }
    private static JButton quitarCantidad (){
        JButton quitarCantidad = new JButton("-");

        return quitarCantidad;
    }

}
