package windows.camarero;

import modelos.Reserva;
import windows.administrator.Empleado;
import windows.administrator.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Camarero  extends JFrame {
    public static final Dimension pantalla = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.85), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85));




    private static final ImageIcon imagenFondo = rutaDeImagen();

    public Camarero() {

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe

        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
        window.setSize(pantalla); // indica tamaño de la ventana

        JPanel panel = pane();
        JPanel panel2 = pane2();
        JPanel panel12 = pane3();
        JPanel panel122 = pane4();
        JPanel fondo = crearPanelImagenFondo();

        JButton boton_empleado, boton_productos, boton_mesas, boton_reserva;
        boton_empleado = crearBotonAforo();
        boton_productos = crearBotonPedidos();
        boton_mesas = crearBotonCuenta();
        boton_reserva = crearBotonReserva();
        panel.add(boton_empleado);
        panel2.add(boton_productos);
        panel12.add(boton_mesas);
        panel122.add(boton_reserva);
        window.add(panel);
        window.add(panel2);
        window.add(panel12);
        window.add(panel122);
        window.add(fondo);

        window.setVisible(true);
    }

    private static ImageIcon rutaDeImagen() {
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\camarerofondo.jpg";
        ImageIcon imagenMesa = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenMesa.getImage()
                .getScaledInstance(1400, pantalla.height, Image.SCALE_SMOOTH);
        imagenMesa.setImage(cambiar_tamayo);
        return imagenMesa;
    }

    private static JPanel crearPanelImagenFondo() {
        JPanel panel = new JPanel(new BorderLayout()) {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo.getImage(), 0, 0, null);
            }
        };
        return panel;
    }

    private static JPanel pane2() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(100, 160, 400, 100);
        return panel;
    }

    private static JPanel pane() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(100, 280, 400, 100);
        return panel;
    }

    private static JPanel pane3() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(100, 400, 400, 100);
        return panel;
    }

    private static JPanel pane4() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(100, 520, 400, 100);
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
        boton.addActionListener(new accionAforo());
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
        boton.addActionListener(new accionAforo.accionPedido());
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
        boton.addActionListener(new accionCuenta());
        return boton;
    }

    private static JButton crearBotonReserva() {

        JButton boton = new JButton("Reservas");
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\reserva.png";
        ImageIcon imagenReserva = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenReserva.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        imagenReserva.setImage(cambiar_tamayo);
        boton.setIcon(imagenReserva);

        boton.setFocusPainted(false);
        boton.addActionListener(new accionReserva());
        return boton;
    }

    static class accionCuenta implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            new Cuenta();
        }
    }


    static class accionAforo implements ActionListener {
        public void actionPerformed(ActionEvent ae) {

            new Aforo();
        }

        static class accionPedido implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                new Pedido();
            }

        }
    }

    static class accionReserva implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            new AdministradorReservas();
        }
    }
}

