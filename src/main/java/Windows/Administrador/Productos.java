package Windows.Administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Productos extends JFrame{
    private static Dimension pantalla = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.85), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85));
    private static final ImageIcon imagenFondo = new ImageIcon(rutaDeImagen());
    JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
    static Font fuente=new Font("Arial", Font.ITALIC, 30);

    public Productos() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
        window.setSize(pantalla); // indica tamaño de la ventana

        JPanel panel = panel1();
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setOpaque(false);

        JPanel panel2 = panel2();
        JPanel fondo = crearPanelImagenFondo();

        JButton boton_crear, boton_modificar, boton_eliminar, boton_buscar;
        boton_crear = boton_crear();
        boton_modificar = boton_modificar();
        boton_eliminar = boton_eliminar();
        boton_buscar = boton_buscar();
        JLabel etiquetaid = id();
        JTextField id = new JTextField();
        etiquetaid.setLabelFor(id);

        JLabel etiquetacodigo = codigo();
        JTextField codigo = new JTextField();
        etiquetacodigo.setLabelFor(codigo);

        JLabel etiquetadescripcion = descripcion();
        JTextField descripcion = new JTextField();
        etiquetadescripcion.setLabelFor(descripcion);

        JLabel etiquetaprecio = precio();
        JTextField precio = new JTextField();
        etiquetaprecio.setLabelFor(precio);

        panel.add(etiquetaid);
        panel.add(id);
        panel.add(etiquetacodigo);
        panel.add(codigo);
        panel.add(etiquetadescripcion);
        panel.add(descripcion);
        panel.add(etiquetaprecio);
        panel.add(precio);


       //Añado archivos en Panel de los botones.
        panel2.add(boton_crear);
        panel2.add(boton_buscar);
        panel2.add(boton_modificar);
        panel2.add(boton_eliminar);


        window.add(panel);
        window.add(panel2);
        window.add(fondo);
        window.setVisible(true);
    }
    private static JPanel panel1 (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2,15 ,15));
        panel.setBounds(270, 100, 700, 500);
        return panel;
    }
    private static JPanel panel2 (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4, 5 ,5 ));
        panel.setBounds(320, 600, 600, 70);
        return panel;
    }
    public static JLabel id(){
        JLabel id = new JLabel();
        id.setFont(fuente);
        id.setText("Id");
        return id;
    }
    public static JLabel codigo(){
        JLabel codigo = new JLabel();
        codigo.setFont(fuente);
        codigo.setText("Código");
        return codigo;
    }
    public static JLabel descripcion(){
        JLabel descripcion = new JLabel();
        descripcion.setFont(fuente);
        descripcion.setText("Descripción");
        return descripcion;
    }

    public static JLabel precio(){
        JLabel precio = new JLabel();
        precio.setFont(fuente);
        precio.setText("Precio");
        return precio;
    }


        private static JButton boton_crear() {

            JButton boton = new JButton("Crear");
            boton.setFocusPainted(false);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se ha pulsado el botón cocinero");
                }
            });
            // boton.addActionListener(new AccionAbrirMenuCocinero());
            return boton;
        }
    private static JButton boton_buscar() {

        JButton boton = new JButton("Buscar");
        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón cocinero");
            }
        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }
    private static JButton boton_eliminar() {

        JButton boton = new JButton("Eliminar");
        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón cocinero");
            }
        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }
    private static JButton boton_modificar() {

        JButton boton = new JButton("Modificar");
        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón cocinero");
            }
        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
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
        private static String rutaDeImagen () {
            String ruta = new File("").getAbsolutePath() + "\\imagenes\\producto.jpg";
            return ruta;
        }
    }


