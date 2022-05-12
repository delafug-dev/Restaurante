package windows.administrator;

import bbdd.MesasBD;
import bbdd.Productobd;
import modelos.Mesa;
import modelos.Producto;
import modelos.Tipoproducto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static windows.Window.pantalla;

public class Mesas extends JFrame {

    private static final ImageIcon imagenFondo = getRutaImagenFondo();
    private static final Font fuente = new Font("Arial", Font.ITALIC | Font.BOLD, 45);

    JPanel panelPrincipal = crearPanelImagenFondo();
    private static JTextField fieldId;
    private static JTextField fieldNumMesa;
    private static JTextField fieldNumComensales;

    public Mesas(){
        JPanel panelSuperior = new JPanel(new BorderLayout());
        JPanel formulario = new JPanel(new GridLayout(0, 1));
        JPanel botones = new JPanel(new GridLayout(1, 4,10,10));

        // BOTONES
        JButton crear = new JButton("CREAR");
        crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mesa mesa = new Mesa();
                mesa.setId(Integer.parseInt(fieldId.getText()));
                mesa.setNum_mesa(Integer.parseInt(fieldNumMesa.getText()));
                mesa.setNum_comensales(Integer.parseInt(fieldNumComensales.getText()));
                MesasBD.crearActualizarProducto(mesa);
            }

        });

        JButton buscar = new JButton("BUSCAR");
        JButton modificar = new JButton("MODIFICAR");
        JButton eliminar = new JButton("ELIMINAR");
        eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mesa mesa = new Mesa();
                mesa.setId(Integer.parseInt(fieldId.getText()));
                MesasBD.eliminarProducto(mesa);
            }
        });

        botones.add(crear);
        botones.add(buscar);
        botones.add(eliminar);

        formulario.setOpaque(false);
        formulario.setLayout(new GridLayout(0, 2,10 ,20));
        formulario.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));

        JLabel etiquetaId = id();
        fieldId = new JTextField();
        etiquetaId.setLabelFor(fieldId);

        JLabel etiquetaNumMesa = num_mesa();
        fieldNumMesa = new JTextField();
        etiquetaNumMesa.setLabelFor(fieldNumMesa);

        JLabel etiquetaNumComensales = num_comensales();
        fieldNumComensales = new JTextField();
        etiquetaNumComensales.setLabelFor(fieldNumComensales);

        formulario.add(id());
        formulario.add(fieldId);
        formulario.add(num_mesa());
        formulario.add(fieldNumMesa);
        formulario.add(num_comensales());
        formulario.add(fieldNumComensales);


        botones.setPreferredSize(new Dimension(100,100));
        botones.setOpaque(false);
        botones.setBorder(BorderFactory.createEmptyBorder(0,15,25,15));

        panelSuperior.setSize(new Dimension(700, 700));
        panelSuperior.setBorder(new EmptyBorder(100,100,100,100));
        panelSuperior.setOpaque(false);
        panelSuperior.add(formulario);

        panelPrincipal.add(panelSuperior, BorderLayout.CENTER);
        panelPrincipal.add(botones, BorderLayout.SOUTH);

        // CONFIGURACIÓN DEL PANEL
        setContentPane(panelPrincipal);
        setBackground(Color.DARK_GRAY);
        pack();
        setSize(pantalla);
        setResizable(false);
        setVisible(true);
    }

    private JPanel crearPanelImagenFondo(){
        JPanel panel = new JPanel(new BorderLayout()){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo.getImage(), 0, 0, null);
            }
        };
        return panel;
    }

    private static ImageIcon getRutaImagenFondo(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\mesas.jpg";
        ImageIcon imagenMesa = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenMesa.getImage()
                .getScaledInstance(1400, pantalla.height, Image.SCALE_SMOOTH);
        imagenMesa.setImage(cambiar_tamayo);
        return imagenMesa;
    }

    public static JLabel id(){
        JLabel id = new JLabel();
        id.setFont(fuente);
        id.setText("ID");
        id.setForeground(Color.WHITE);
        return id;
    }
    public static JLabel num_mesa(){
        JLabel num_mesa = new JLabel();
        num_mesa.setFont(fuente);
        num_mesa.setText("Nº MESA");
        num_mesa.setForeground(Color.WHITE);
        return num_mesa;
    }
    public static JLabel num_comensales(){
        JLabel num_comensales = new JLabel();
        num_comensales.setFont(fuente);
        num_comensales.setText("Nº Comensales");

        num_comensales.setForeground(Color.WHITE);
        return num_comensales;
    }
}
