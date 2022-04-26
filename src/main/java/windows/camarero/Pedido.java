package windows.camarero;
import windows.administrator.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static windows.Window.pantalla;
import javax.swing.*;
import javax.swing.border.Border;

import static windows.Window.pantalla;

public class Pedido extends JFrame{
        static Font fuente=new Font("Arial", Font.ITALIC, 30);
        private static final ImageIcon imagenFondo = rutaDeImagen();
        public Pedido(){

            JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe

            // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
            window.setSize(pantalla); // indica tamaño de la ventana

            JPanel panel = pane();
            JPanel panel2 = pane2();
            JPanel fondo = crearPanelImagenFondo();
            panel.setOpaque(false);
            panel2.setOpaque(false);

            // Combobox mesa
            JLabel etiquetaMesa = mesa();
            JComboBox comboMesas = new JComboBox();
            rellenarComboMesas(comboMesas);
            //Combobox Camarero
            JLabel etiquetaCamarero = camarero();
            JComboBox comboCamarero = new JComboBox();
            rellenarComboCamarero(comboCamarero);
            //Combobox Producto
            JLabel etiquetaProducto = producto();
            JComboBox comboProducto = new JComboBox();
            rellenarComboCamarero(comboProducto);
            //Cantidad
            JLabel etiquetaLabel = cantidad();
            SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
            JSpinner numeroProductos = new JSpinner(model);
            //Botón añadir
            JButton botonAñadir = new JButton("Añadir");

            panel.add(etiquetaMesa);
            panel.add(comboMesas);
            panel.add(etiquetaCamarero);
            panel.add(comboCamarero);
            panel.add(etiquetaProducto);
            panel.add(comboProducto);
            panel.add(etiquetaLabel);
            panel.add(numeroProductos);
            panel.add(botonAñadir);

            //TABLA COMANDA
            Object[] columnas = {"Producto",
                    "Cantidad",
                    "Importe por unidad"};
            Object[][] datos = {{"","",""}};
            JTable tablaComanda = new JTable(datos , columnas);

            //PANEL TABLA COMANDA
            JScrollPane scrollPane = new JScrollPane(tablaComanda);
            tablaComanda.setFillsViewportHeight(true);

            panel2.add(scrollPane);
            window.add(panel);
            window.add(panel2);
            window.add(fondo);

            window.setVisible(true);
        }

    private static ImageIcon rutaDeImagen(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\pedido.jpg";
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
    private static JPanel pane() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 0, 5,5));
        panel.setBounds(50, 50, 600, 300);
        return panel;
    }

    private static JPanel pane2() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0, 5,5));
        panel.setBounds(50, 400, 600, 100);
        return panel;
    }
    private void rellenarComboMesas(JComboBox comboBox){
        comboBox.addItem("Mesa 1");
        comboBox.addItem("Mesa 2");
        comboBox.addItem("Mesa 3");
        comboBox.addItem("Mesa 4");
    }
    private void rellenarComboCamarero(JComboBox comboBox){
        comboBox.addItem("Camarero 1");
        comboBox.addItem("Camarero 2");
    }
    public static JLabel mesa(){
        JLabel nombre = new JLabel();
        nombre.setFont(fuente);
        nombre.setForeground(Color.BLACK);
        nombre.setText("Mesa");
        return nombre;
    }
    public static JLabel producto(){
        JLabel nombre = new JLabel();
        nombre.setFont(fuente);
        nombre.setForeground(Color.BLACK);
        nombre.setText("Producto");
        return nombre;
    }
    public static JLabel camarero(){
        JLabel nombre = new JLabel();
        nombre.setFont(fuente);
        nombre.setForeground(Color.black);
        nombre.setText("Camarero");
        return nombre;
    }
    public static JLabel cantidad(){
        JLabel nombre = new JLabel();
        nombre.setFont(fuente);
        nombre.setForeground(Color.black);
        nombre.setText("Cantidad");
        return nombre;
    }
}
