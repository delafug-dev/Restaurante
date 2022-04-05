package windows;

import windows.administrator.Window_Administrator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Window extends JFrame {

    public static final Dimension pantalla = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.85), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85));

    public Window() {

        // Guía layouts (hacer la ventana que cambie de tamaño)
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa

        window.setResizable(false);

        window.setSize(pantalla); // indica tamaño de la ventana
        setLocationRelativeTo(null);
        window.setLayout(new GridLayout(0, 4)); // Indico el layout del panel pricipal de 4 columnas

        // window.setPreferredSize(new Dimension(1366,768));

        JButton boton_cliente, boton_camarero, boton_cocinero, boton_administrador;
        boton_cliente = crearBotonCliente();
        boton_camarero = crearBotonCamarero();
        boton_cocinero = crearBotonCocinero();
        boton_administrador = crearBotonAdministrador();
        boton_cliente.setPreferredSize(new Dimension(300, 100));
        boton_camarero.setPreferredSize(new Dimension(300, 300));
        boton_cocinero.setPreferredSize(new Dimension(300, 300));
        boton_administrador.setPreferredSize(new Dimension(300, 300));
        window.add(boton_cliente);
        window.add(boton_camarero);
        window.add(boton_cocinero);
        window.add(boton_administrador);

        window.setVisible(true);// Se usa para que se vea
    }

    private static JButton crearBotonCocinero() {

        Font fuente = new Font("Arial", Font.ITALIC, 30);
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\cocina.jpg";
        ImageIcon imagenCocinero = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenCocinero.getImage().getScaledInstance(500, pantalla.height, Image.SCALE_SMOOTH);
        imagenCocinero.setImage(cambiar_tamayo);
        JButton boton = new JButton("Cocinero", imagenCocinero);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setBorder(new EmptyBorder(0, 20, 80, 20));
        boton.setFont(fuente);
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.BLACK);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón cocinero");
            }
        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }

    private static JButton crearBotonCliente() {
        // Border empty = BorderFactory.createEmptyBorder();
        Font fuente = new Font("Arial", Font.ITALIC, 30);
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\cliente.jpg";
        ImageIcon imagenCliente = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenCliente.getImage().getScaledInstance(400, pantalla.height, Image.SCALE_SMOOTH);
        imagenCliente.setImage(cambiar_tamayo);
        JButton boton = new JButton("Cliente", imagenCliente);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setBorder(new EmptyBorder(0, 20, 80, 20));
        boton.setFont(fuente);
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.BLACK);
        // boton.setBorder(empty);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón cliente");
            }
        });
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }

    private static JButton crearBotonCamarero() {
        Font fuente = new Font("Arial", Font.ITALIC, 30);
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\camarero.jpg";
        ImageIcon imagenCamarero = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenCamarero.getImage().getScaledInstance(500, pantalla.height, Image.SCALE_SMOOTH);
        imagenCamarero.setImage(cambiar_tamayo);
        JButton boton = new JButton("Camarero", imagenCamarero);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setBorder(new EmptyBorder(0, 20, 80, 20));
        boton.setFont(fuente);
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.BLACK);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón camarero");
            }
        });
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }

    private static JButton crearBotonAdministrador() {
        Font fuente = new Font("Arial", Font.ITALIC, 30);
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\admin.jpg";
        ImageIcon imagenAdmin = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenAdmin.getImage().getScaledInstance(500, pantalla.height, Image.SCALE_SMOOTH);
        imagenAdmin.setImage(cambiar_tamayo);
        JButton boton = new JButton("Administrador", imagenAdmin);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setBorder(new EmptyBorder(0, 20, 80, 20));
        boton.setFont(fuente);
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.BLACK);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha pulsado el botón admin");
            }
        });
        boton.addActionListener(new accion_administrador());
        return boton;
    }

    static class accion_administrador implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            new Window_Administrator();
        }
    }

}
