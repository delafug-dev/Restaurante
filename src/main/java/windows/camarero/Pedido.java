package windows.camarero;
import bbdd.EmpleadoBD;
import bbdd.MesasBD;
import bbdd.Productobd;
import modelos.Mesa;
import modelos.ModeloEmpleado;
import modelos.ModeloPedido;
import modelos.Producto;
import bbdd.PedidoBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static windows.Window.pantalla;

public class Pedido extends JFrame{

    private static JComboBox comboMesas;
    private static JComboBox comboCamarero;
    private static JComboBox comboProducto;
    private static JTable tablaComanda;
    private static List<ModeloPedido> pedi = new ArrayList<>();
    private static SpinnerModel model;
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
            comboMesas = new JComboBox();
            rellenarComboMesas(comboMesas);
            //Combobox Camarero
            JLabel etiquetaCamarero = camarero();
            comboCamarero = new JComboBox();
            rellenarComboCamarero(comboCamarero);
            //Combobox Producto
            JLabel etiquetaProducto = producto();
            comboProducto = new JComboBox();
            rellenarComboProducto(comboProducto);
            //Cantidad
            JLabel etiquetaLabel = cantidad();
            model = new SpinnerNumberModel(1, 1, 100, 1);
            JSpinner numeroProductos = new JSpinner(model);
            //Botón añadir
            JButton botonAñadir = boton_añadir();
            JButton botonbuscar = boton_buscar();
            JButton botonborrar = boton_eliminar();

            panel.add(etiquetaMesa);
            panel.add(comboMesas);
            panel.add(etiquetaCamarero);
            panel.add(comboCamarero);
            panel.add(etiquetaProducto);
            panel.add(comboProducto);
            panel.add(etiquetaLabel);
            panel.add(numeroProductos);
            panel.add(botonAñadir);
            panel.add(botonbuscar);
            panel.add(botonborrar);

            //TABLA COMANDA

            Object[] columnas = {"Producto",
                    "Cantidad",
                    "Mesa"};
            Object[][] datos = {{"","",""}};
            tablaComanda = new JTable(new DefaultTableModel(datos,columnas));

            //PANEL TABLA COMANDA
            JScrollPane scrollPane = new JScrollPane(tablaComanda);
            tablaComanda.setFillsViewportHeight(true);

            panel2.add(scrollPane);
            window.add(panel);
            window.add(panel2);
            window.add(fondo);

            window.setVisible(true);
        }
    private static JButton  boton_añadir() {
        JButton boton = new JButton("Añadir");
        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModeloPedido ped = new ModeloPedido();
                ped.setMesa(Integer.parseInt((String.valueOf(comboMesas.getSelectedItem()))));
                ped.setCamarero(String.valueOf(comboCamarero.getSelectedItem()));
                ped.setProducto(String.valueOf(comboProducto.getSelectedItem()));
                ped.setCantidad(Integer.parseInt(String.valueOf(model.getValue())));
                PedidoBD.crearPedido(ped);
            }

        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }
    private static JButton boton_eliminar() {
        JButton boton = new JButton("Borrar");
        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModeloPedido pedido = new ModeloPedido();
                pedido.setMesa(Integer.parseInt(String.valueOf(comboMesas.getSelectedItem())));
                PedidoBD.eliminarPedidos(pedido);
            }
        });
        return boton;
    }

    private static JButton boton_buscar() {
        JButton boton = new JButton("Buscar");
        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer pedido = Integer.valueOf((String.valueOf(comboMesas.getSelectedItem())));
                List<ModeloPedido> pedi = PedidoBD.obtenerPormesa(pedido);
                int i = 1;
                int columna = 1;

                DefaultTableModel modelo = (DefaultTableModel) tablaComanda.getModel();
                modelo.setRowCount(0);

                if(pedi != null){
                    for(ModeloPedido mp: pedi){
                        modelo = (DefaultTableModel) tablaComanda.getModel();
                        modelo.addRow(new Object[]{mp.getProducto(), mp.getCantidad(), mp.getMesa()});
                }
                tablaComanda.repaint();
            }


            }
        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
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
        panel.setLayout(new GridLayout(6, 0, 5,5));
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
        List<Mesa> mesa = MesasBD.obtenerMesapedido();
        for(Mesa m : mesa){
            comboBox.addItem(m.getNum_mesa());
        }

    }
    private void rellenarComboProducto(JComboBox comboBox){
        List<Producto> producto = Productobd.obtenerProductopedido();
        for(Producto p : producto){
            comboBox.addItem(p.getDescripcion());
        }

    }
    private void rellenarComboCamarero(JComboBox comboBox){
        List<ModeloEmpleado> empleado = EmpleadoBD.obtenerEmpleadopedido();
        for(ModeloEmpleado m : empleado){
            comboBox.addItem(m.getNombre());
        }
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
