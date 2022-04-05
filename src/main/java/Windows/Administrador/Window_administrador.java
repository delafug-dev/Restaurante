package Windows.Administrador;

import Windows.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Window_administrador extends JFrame {
    private static Dimension pantalla = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.85), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85));
    private static final ImageIcon imagenFondo = new ImageIcon(rutaDeImagen());

    public Window_administrador(){

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
        window.setSize(pantalla); // indica tamaño de la ventana

        JPanel panel = pane();
        JPanel panel2 = pane2();
        JPanel panel12 = pane3();
        JPanel fondo = crearPanelImagenFondo();

        JButton boton_empleado, boton_productos, boton_mesas;
        boton_empleado = crearBotonEmpleado();
        boton_productos = crearBotonProducto();
        boton_mesas = crearBotonMesa();
        panel.add(boton_empleado);
        panel2.add(boton_productos);
        panel12.add(boton_mesas);
        window.add(panel);
        window.add(panel2);
        window.add(panel12);
        window.add(fondo);

        window.setVisible(true);
    }
    private static String rutaDeImagen(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\administrador.jpg";
        return ruta;
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
        panel.setBounds(450, 320, 400, 100);
    return panel;
    }

    private static JPanel pane2 (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(450, 200, 400, 100);
        return panel;
    }

    private static JPanel pane3 (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(450, 440, 400, 100);
        return panel;
    }

        private static JButton crearBotonEmpleado() {

            JButton boton = new JButton("Empleado");
            String ruta = new File("").getAbsolutePath() + "\\imagenes\\empleado.png";
            ImageIcon imagenEmpleado = new ImageIcon(ruta);
            Image cambiar_tamayo = imagenEmpleado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imagenEmpleado.setImage(cambiar_tamayo);
            boton.setIcon(imagenEmpleado);

            boton.setFocusPainted(false);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se ha pulsado el botón cocinero");
                }
            });
            // boton.addActionListener(new AccionAbrirMenuCocinero());
            return boton;
        }

    private static JButton crearBotonMesa() {

        JButton boton = new JButton("Mesas");
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\mesa.png";
        ImageIcon imagenMesa = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenMesa.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagenMesa.setImage(cambiar_tamayo);
        boton.setIcon(imagenMesa);

        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón cocinero");
            }
        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }

    private static JButton crearBotonProducto() {

        JButton boton = new JButton("Productos");
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\producto.png";
        ImageIcon imagenProducto = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenProducto.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        imagenProducto.setImage(cambiar_tamayo);
        boton.setIcon(imagenProducto);

        boton.setFocusPainted(false);
        boton.addActionListener(new Window_administrador.accionProductos());
        return boton;
    }

    static class accionProductos implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            new Productos();
        }
    }



}
