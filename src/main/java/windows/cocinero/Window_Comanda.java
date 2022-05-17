package windows.cocinero;

import bbdd.MesasBD;
import bbdd.PedidoBD;
import bbdd.Productobd;
import modelos.Mesa;
import modelos.ModeloPedido;
import modelos.Producto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import static windows.Window.pantalla;

public class Window_Comanda extends JFrame {

    private static JComboBox comboMesa;
    private static JComboBox comboProducto;
    private static JTable tablaComanda1;
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
        Object[][] datos = {{"",""}};
        tablaComanda1 = new JTable(new DefaultTableModel(datos,columnas));
        //PANEL TABLA COMANDA
        JScrollPane scrollPane = new JScrollPane(tablaComanda1);
        tablaComanda1.setFillsViewportHeight(true);

        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new GridLayout(1,0));
        panelTabla.setBounds(200,280,800,300);
        panelTabla.add(scrollPane);
        JPanel panelFondo =  crearPanelImagenFondo();

        // JCOMBO
        comboMesa = new JComboBox();
        comboProducto = new JComboBox();
        rellenarComboMesas(comboMesa);
        rellenarComboProducto(comboProducto);

        // JBUTTON
        JButton botonborrar = borrarProducto();
        JButton buscarComanda = buscarComanda();
        JButton addCantidad = addCantidad();
        JButton quitarCantidad = quitarCantidad();


        comandaPanel.add(comboMesa);
        comandaPanel.add(botonborrar);
        comandaPanel.add(buscarComanda);
        comandaPanel.add(comboProducto);

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

    private void rellenarComboMesas(JComboBox comboBox){
        List<Mesa> mesa = MesasBD.obtenerMesapedido();
        for(Mesa m : mesa){
            comboBox.addItem(m);
        }

    }
    private void rellenarComboProducto(JComboBox comboBox){
        List<Producto> producto = Productobd.obtenerProductos();
        for(Producto p : producto){
            comboBox.addItem(p);
        }

    }



    private static JButton buscarComanda (){
        JButton buscarComanda = new JButton("BUSCAR");
        buscarComanda.setForeground(Color.WHITE);
        buscarComanda.setBackground(Color.darkGray);
        Border line = new LineBorder(Color.WHITE);
        buscarComanda.setBorder(line);
        buscarComanda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mesa pedido = (Mesa) comboMesa.getSelectedItem();
                List<ModeloPedido> pedi = PedidoBD.obtenerPormesa(pedido);


                DefaultTableModel modelo = (DefaultTableModel) tablaComanda1.getModel();
                modelo.setRowCount(0);

                if(pedi != null){
                    for(ModeloPedido mp: pedi){
                        modelo = (DefaultTableModel) tablaComanda1.getModel();
                        modelo.addRow(new Object[]{mp.getProducto(), mp.getCantidad(), mp.getMesa()});
                    }
                    tablaComanda1.repaint();
                }


            }
        });

        return buscarComanda;
    }
    private static JButton borrarProducto (){
        JButton borrar = new JButton("BORRAR");
        borrar.setForeground(Color.WHITE);
        borrar.setBackground(Color.darkGray);
        Border line = new LineBorder(Color.WHITE);
        borrar.setBorder(line);
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModeloPedido pedido = new ModeloPedido();
                pedido.setProducto((Producto) comboProducto.getSelectedItem());
                pedido.setMesa((Mesa) comboMesa.getSelectedItem());
                PedidoBD.eliminarPedidosProducto(pedido);
            }
        });

        return borrar;
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
