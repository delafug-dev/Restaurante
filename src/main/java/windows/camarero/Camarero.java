package windows.camarero;

import windows.administrator.Empleado;
import windows.administrator.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static windows.Window.pantalla;


public class Camarero  extends JFrame {

        private static final ImageIcon imagenFondo = rutaDeImagen();

        public Camarero(){

            JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe

            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
            window.setSize(pantalla); // indica tamaño de la ventana

            JPanel panel = pane();
            JPanel panel2 = pane2();
            JPanel panel12 = pane3();
            JPanel fondo = crearPanelImagenFondo();

            JButton boton_empleado, boton_productos, boton_mesas;
            boton_empleado = crearBotonAforo();
            boton_productos = crearBotonPedidos();
            boton_mesas = crearBotonCuenta();
            panel.add(boton_empleado);
            panel2.add(boton_productos);
            panel12.add(boton_mesas);
            window.add(panel);
            window.add(panel2);
            window.add(panel12);
            window.add(fondo);

            window.setVisible(true);
        }
        private static ImageIcon rutaDeImagen(){
            String ruta = new File("").getAbsolutePath() + "\\imagenes\\camarerofondo.jpg";
            ImageIcon imagenMesa = new ImageIcon(ruta);
            Image cambiar_tamayo = imagenMesa.getImage()
                    .getScaledInstance(1400, pantalla.height, Image.SCALE_SMOOTH);
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

        private static JPanel pane (){
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 0));
            panel.setBounds(100, 320, 400, 100);
            return panel;
        }

        private static JPanel pane2 (){
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 0));
            panel.setBounds(100, 200, 400, 100);
            return panel;
        }

        private static JPanel pane3 (){
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 0));
            panel.setBounds(100, 440, 400, 100);
            return panel;
        }

        private static JButton crearBotonAforo() {

            JButton boton = new JButton("Aforo");
            String ruta = new File("").getAbsolutePath() + "\\imagenes\\aforo.png";
            ImageIcon imagenEmpleado = new ImageIcon(ruta);
            Image cambiar_tamayo = imagenEmpleado.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            imagenEmpleado.setImage(cambiar_tamayo);
            boton.setIcon(imagenEmpleado);

            boton.setFocusPainted(false);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se ha pulsado el botón cocinero");
                }
            });
            // boton.addActionListener(new AccionAbrirMenuCocinero());
            boton.addActionListener(new accionEmpleado());
            return boton;
        }

        private static JButton crearBotonPedidos() {

            JButton boton = new JButton("Pedidos");
            String ruta = new File("").getAbsolutePath() + "\\imagenes\\pedido.png";
            ImageIcon imagenMesa = new ImageIcon(ruta);
            Image cambiar_tamayo = imagenMesa.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            imagenMesa.setImage(cambiar_tamayo);
            boton.setIcon(imagenMesa);

            boton.setFocusPainted(false);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se ha pulsado el botón cocinero");
                }
            });
            return boton;
        }

        private static JButton crearBotonCuenta() {

            JButton boton = new JButton("Cuenta");
            String ruta = new File("").getAbsolutePath() + "\\imagenes\\factura.png";
            ImageIcon imagenProducto = new ImageIcon(ruta);
            Image cambiar_tamayo = imagenProducto.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            imagenProducto.setImage(cambiar_tamayo);
            boton.setIcon(imagenProducto);

            boton.setFocusPainted(false);
            boton.addActionListener(new accionProductos());
            return boton;
        }

        static class accionProductos implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                new Productos();
            }
        }
        static class accionEmpleado implements ActionListener {
            public void actionPerformed(ActionEvent ae) {

                new Empleado();
            }
        }

    }
