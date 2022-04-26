package windows.administrator;

import bbdd.Productobd;
import modelos.Producto;
import modelos.Tipoproducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Productos extends JFrame{
    private static final ImageIcon imagenFondo = new ImageIcon(rutaDeImagen());
    public static final Dimension pantalla = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.85), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85));
    JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
    static Font fuente=new Font("Arial", Font.ITALIC, 30);
    private static JTextField codigo;
    private static JTextField id;
    private static JTextField descripcion;
    private static JTextField preciotapa;
    private static JTextField preciomedia;
    private static JTextField precioentera;

    public Productos() {

        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
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
        id = new JTextField();
        etiquetaid.setLabelFor(id);

        JLabel etiquetacodigo = codigo();
        descripcion = new JTextField();
        etiquetacodigo.setLabelFor(codigo);

        JLabel etiquetadescripcion = descripcion();
        codigo = new JTextField();
        etiquetadescripcion.setLabelFor(descripcion);

        JLabel etiquetaprecio = precioTapa();
        preciotapa = new JTextField();
        etiquetaprecio.setLabelFor(preciotapa);

        JLabel etiquetapreciomedia = precioMedia();
        preciomedia = new JTextField();
        etiquetaprecio.setLabelFor(preciomedia);

        JLabel etiquetaentera = precioRacion();
        precioentera = new JTextField();
        etiquetaprecio.setLabelFor(precioentera);

        panel.add(etiquetaid);
        panel.add(id);
        panel.add(etiquetacodigo);
        panel.add(codigo);
        panel.add(etiquetadescripcion);
        panel.add(descripcion);
        panel.add(etiquetaprecio);
        panel.add(preciotapa);
        panel.add(etiquetapreciomedia);
        panel.add(preciomedia);
        panel.add(etiquetaentera);
        panel.add(precioentera);


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
        codigo.setText("Descripción");
        return codigo;
    }

    public static JLabel descripcion(){
        JLabel descripcion = new JLabel();
        descripcion.setFont(fuente);
        descripcion.setText("Tipo de Producto");
        return descripcion;
    }

    public static JLabel precioTapa(){
        JLabel precio = new JLabel();
        precio.setFont(fuente);
        precio.setText("Precio Tapa");
        return precio;
    }

    public static JLabel precioMedia(){
        JLabel precio = new JLabel();
        precio.setFont(fuente);
        precio.setText("Precio 1/2");
        return precio;
    }

    public static JLabel precioRacion(){
        JLabel precio = new JLabel();
        precio.setFont(fuente);
        precio.setText("Precio ración");
        return precio;
    }


    private static JButton boton_crear() {

            JButton boton = new JButton("Crear");
            boton.setFocusPainted(false);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Producto producto = new Producto();
                    producto.setId(Integer.parseInt(id.getText()));
                    producto.setDescripcion(codigo.getText());
                    producto.setTipoproducto(Tipoproducto.valueOf(descripcion.getText()));
                    producto.setPequenya(Double.parseDouble(preciotapa.getText()));
                    producto.setMedia(Double.parseDouble(preciomedia.getText()));
                    producto.setGrande(Double.parseDouble(precioentera.getText()));
                    Productobd.crearActualizarProducto(producto);
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
                System.out.println("Se ha pulsado el botón buscar");
                Integer idproducto = Integer.valueOf(id.getText());
                Productobd.obtenerPorId(idproducto);
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
                Producto producto = new Producto();
                producto.setId(Integer.parseInt(id.getText()));
                Productobd.eliminarProducto(producto);
            }
        });
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


