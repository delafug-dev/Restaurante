package Windows;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class window {

    public static void main(String[] args) {

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa

        window.setSize(1200, 800); // indica tamaño de la ventana

        window.setLayout(new GridLayout(0, 4)); // Indico el layout del panel pricipal de 4 columnas

        JButton boton_cliente, boton_camarero, boton_cocinero, boton_administrador;
        boton_cliente = crearBotonCliente();
        boton_camarero = crearBotonCamarero();
        boton_cocinero = crearBotonCocinero();
        boton_administrador = new JButton();
        boton_cliente.setPreferredSize(new Dimension(50,10));
        boton_camarero.setPreferredSize(new Dimension(50,10));
        boton_cocinero.setPreferredSize(new Dimension(50,10));
        boton_administrador.setPreferredSize(new Dimension(50,10));
        window.add(boton_cliente);
        window.add(boton_camarero);
        window.add(boton_cocinero);
        window.add(boton_administrador);

        window.setVisible(true);// Se usa para que se vea
    }

    private static JButton crearBotonCocinero(){
        JButton boton = new JButton("Cocinero");
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\cocina.jpg";
        ImageIcon imagenCocinero = new ImageIcon(ruta);
        boton.setIcon(imagenCocinero);
        Image cambiar_tamayo = imagenCocinero.getImage().getScaledInstance(500,800, Image.SCALE_SMOOTH);
        imagenCocinero.setImage(cambiar_tamayo);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        // hola
        return boton;
    }
    private static JButton crearBotonCliente(){
        JButton boton = new JButton("Cliente");
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\cliente.jpg";
        ImageIcon imagenCliente = new ImageIcon(ruta);
        boton.setIcon(imagenCliente);
        Image cambiar_tamayo = imagenCliente.getImage().getScaledInstance(35y0,800, Image.SCALE_SMOOTH);
        imagenCliente.setImage(cambiar_tamayo);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }
    private static JButton crearBotonCamarero(){
        JButton boton = new JButton("Camarero");
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\camarero.jpg";
        ImageIcon imagenCamarero = new ImageIcon(ruta);
        boton.setIcon(imagenCamarero);
        Image cambiar_tamayo = imagenCamarero.getImage().getScaledInstance(500,800, Image.SCALE_SMOOTH);
        imagenCamarero.setImage(cambiar_tamayo);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }

    private static JButton crearBotonAdministrador(){
        JButton boton = new JButton("Admnistrador");
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\cocina.jpg";
        ImageIcon imagenCocinero = new ImageIcon(ruta);
        boton.setIcon(imagenCocinero);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }


}
