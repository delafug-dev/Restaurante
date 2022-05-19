package windows.camarero;

import bbdd.EmpleadoBD;
import bbdd.MesasBD;
import bbdd.PedidoBD;
import bbdd.Productobd;
import modelos.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static windows.Window.pantalla;

public class Aforo extends JFrame{

    private static JButton botonAñadir;
    private static JButton botonBuscar;
    private static JComboBox comboMesa;
    private static JComboBox comboLibre;
    private static JTable tablaComanda;

    static Font fuente=new Font("Arial", Font.ITALIC, 30);
    private static final ImageIcon imagenFondo = rutaDeImagen();
    public Aforo(){

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
        window.setSize(pantalla); // indica tamaño de la ventana

        JPanel panel2 = pane2();
        JPanel fondo = crearPanelImagenFondo();
        panel2.setOpaque(false);

        //Panel botones
        JPanel panelBoton = new JPanel();
        panelBoton.setBounds(390,420,225,200);
        panelBoton.setOpaque(false);
        botonAñadir = aforoMesaOcupada();
        botonBuscar = aforoBuscar();
        botonAñadir.setPreferredSize(new Dimension(150,50));
        botonBuscar.setPreferredSize(new Dimension(150,50));
        panelBoton.add(botonAñadir);
        //panelBoton.add(botonBuscar);

        //Panel Combobox
        JPanel panelCombobox = new JPanel();
        panelCombobox.setBounds(570, 420, 225, 200);
        panelCombobox.setOpaque(false);
        comboMesa = new JComboBox<>();
        comboLibre = new JComboBox();
        comboLibre.setPreferredSize(new Dimension(150,50));
        comboMesa.setPreferredSize(new Dimension(150, 50));
        rellenarComboMesas(comboMesa);
        rellenarComboProducto(comboLibre);
        panelCombobox.add(comboLibre);
        panelCombobox.add(comboMesa);




        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner numeroProductos = new JSpinner(model);
        List<Mesa> mesa = MesasBD.obtenerMesapedido();


        //TABLA COMANDA
        Object[] columnas = {"Nº Mesa",
                "Libre"};
        Object[][] datos = {{"",""}};
        tablaComanda = new JTable(new DefaultTableModel(datos,columnas));

        //PANEL TABLA COMANDA
        JScrollPane scrollPane = new JScrollPane(tablaComanda);
        tablaComanda.setFillsViewportHeight(true);

        window.add(panelBoton);
        window.add(panelCombobox);
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
        JButton mesaOcupada = new JButton("Buscar");
        mesaOcupada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mesa mesa = new Mesa();
                mesa.setNum_mesa((Integer) comboMesa.getSelectedItem());
                mesa.setLibre(Libre.valueOf((String) comboLibre.getSelectedItem()));
                MesasBD.actualizarMesa(mesa);
                List<Mesa> mesa1 = MesasBD.obtenerProductos();


                DefaultTableModel modelo = (DefaultTableModel) tablaComanda.getModel();
                modelo.setRowCount(0);

                if(mesa1 != null){
                    for(Mesa m: mesa1){
                        modelo = (DefaultTableModel) tablaComanda.getModel();
                        modelo.addRow(new Object[]{m.getNum_mesa(), m.getLibre()});
                    }
                    tablaComanda.repaint();
                }
            }

        });
        return mesaOcupada;
    }
    JButton aforoBuscar(){

        JButton mesaBusqueda = new JButton("Buscar");
        mesaBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Mesa> mesa = MesasBD.obtenerProductos();


                DefaultTableModel modelo = (DefaultTableModel) tablaComanda.getModel();
                modelo.setRowCount(0);

                if(mesa != null){
                    for(Mesa m: mesa){
                        modelo = (DefaultTableModel) tablaComanda.getModel();
                        modelo.addRow(new Object[]{m.getNum_mesa(), m.getLibre()});
                    }
                    tablaComanda.repaint();
                }


            }
        });
        return mesaBusqueda;
    }


    private void rellenarComboMesas(JComboBox comboBox){
        List<Mesa> mesa = MesasBD.obtenerMesapedido();
        for(Mesa m : mesa){
            comboBox.addItem(m.getNum_mesa());

        }

    }
    private void rellenarComboProducto(JComboBox comboBox){

        comboBox.addItem("Si");
        comboBox.addItem("No");

    }



}

