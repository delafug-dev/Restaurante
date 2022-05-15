package windows.camarero;

import bbdd.MesasBD;
import modelos.Mesa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static windows.Window.pantalla;

public class Aforo extends JFrame{
    static Font fuente=new Font("Arial", Font.ITALIC, 30);
    private static final ImageIcon imagenFondo = rutaDeImagen();
    public Aforo(){

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
        window.setSize(pantalla); // indica tamaño de la ventana

        JPanel panel2 = pane2();
        JPanel fondo = crearPanelImagenFondo();
        panel2.setOpaque(false);
        JPanel panelBoton = new JPanel();
        panelBoton.setBounds(520,420,225,180);
        panelBoton.setOpaque(false);
        JButton botonAñadir = aforoMesaOcupada();
        botonAñadir.setPreferredSize(new Dimension(250,100));
        panelBoton.add(botonAñadir);


        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner numeroProductos = new JSpinner(model);
        List<Mesa> mesa = MesasBD.obtenerMesapedido();


        //TABLA COMANDA
        Object[] columnas = {"Nº Mesa",
                "Ocupada"};
        Object[][] datos = {{mesa,""}};
        JTable tablaComanda = new JTable(datos , columnas);

        //PANEL TABLA COMANDA
        JScrollPane scrollPane = new JScrollPane(tablaComanda);
        tablaComanda.setFillsViewportHeight(true);

        window.add(panelBoton);
        panel2.add(scrollPane);
        window.add(panel2);
        window.add(fondo);

        window.setVisible(true);
    }

    private static ImageIcon rutaDeImagen(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\aforo.jpg";
        ImageIcon imagenMesa = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenMesa.getImage()
                .getScaledInstance(1300, pantalla.height, Image.SCALE_SMOOTH);
        imagenMesa.setImage(cambiar_tamayo);
        return imagenMesa;
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

    private static JPanel pane2() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0, 5,5));
        panel.setBounds(300, 300, 600, 100);
        return panel;
    }

    JButton aforoMesaOcupada (){
        JButton mesaOcupada = new JButton("Añadir Mesa");
        /** generarPDF.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }
         }); **/
        return mesaOcupada;
    }

    private JTable tablaComanda(){
        JTable tablaComanda = new JTable();

        return tablaComanda;
    }

    private void actualizarContenidoTabla(Mesa mesa){

        DefaultTableModel model = (DefaultTableModel) tablaComanda().getModel();
        model.setRowCount(0);
        List<Mesa> mesa2 = MesasBD.obtenerMesapedido();

        if(mesa != null){
            for (Mesa m : mesa2) {
                model = (DefaultTableModel) tablaComanda().getModel();
                model.addRow(new Object[]{mesa.getNum_mesa()});

            }
            tablaComanda().repaint();
        }

    }


}

