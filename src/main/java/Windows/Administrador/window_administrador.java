package Windows.Administrador;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class window_administrador {
    public static void main(String[] args) throws IOException {


        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa

        window.setSize(1200, 800); // indicar tamaño de la ventana

        window.setLayout(new BorderLayout(0,3));

        JButton boton_empleado, boton_productos, boton_mesas;
        boton_empleado = crearBotonEmpleado();
        boton_productos = crearBotonProductos();
        boton_mesas = crearBotonMesas();

        window.add(boton_empleado, BorderLayout.EAST);
        window.add(boton_productos, BorderLayout.CENTER);
        window.add(boton_mesas, BorderLayout.WEST);


        window.setVisible(true);// Se usa para que se vea
    }

    private static JButton crearBotonEmpleado(){
        JButton boton = new JButton();
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\empleado.jpg";
        ImageIcon imagenEmpleado = new ImageIcon(ruta);
        boton.setIcon(imagenEmpleado);
        Image cambiar_tamayoEmpleado = imagenEmpleado.getImage().getScaledInstance(400,800, Image.SCALE_SMOOTH);
        imagenEmpleado.setImage(cambiar_tamayoEmpleado);
        //boton.addActionListener(new AccionAbrirMenuCocinero());

        return boton;
    }
    private static JButton crearBotonMesas(){
        JButton boton = new JButton();

        String ruta = new File("").getAbsolutePath()+"\\imagenes\\mesa.jpg";
        ImageIcon imagenMesas = new ImageIcon(ruta);
        boton.setIcon(imagenMesas);
        Image cambiar_tamayoMesas = imagenMesas.getImage().getScaledInstance(200,700, Image.SCALE_SMOOTH);
        imagenMesas.setImage(cambiar_tamayoMesas);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }
    private static JButton crearBotonProductos(){
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\cocina.jpg";
        ImageIcon imagenProducto = new ImageIcon(ruta);
        Image cambiar_tamayoProducto = imagenProducto.getImage().getScaledInstance(400,800, Image.SCALE_SMOOTH);
        imagenProducto.setImage(cambiar_tamayoProducto);

        JButton boton = new JButton("Producto",imagenProducto);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.CENTER);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }




}
