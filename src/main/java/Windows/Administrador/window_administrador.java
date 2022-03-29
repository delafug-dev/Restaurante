package Windows.Administrador;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class window_administrador {
    public static void main(String[] args) throws IOException {


        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa

        window.setSize(1200, 800); // indicar tamaño de la ventana

        window.setLayout(new GridLayout(0, 3));

        JButton boton_empleado, boton_productos, boton_mesas;
        boton_empleado = new JButton();
        boton_productos = new JButton();
        boton_mesas = new JButton();
        boton_empleado.setPreferredSize(new Dimension(50,10));
        boton_productos.setPreferredSize(new Dimension(50,10));
        boton_mesas.setPreferredSize(new Dimension(50,10));
        window.add(boton_empleado);
        window.add(boton_productos);
        window.add(boton_mesas);


        window.setVisible(true);// Se usa para que se vea
    }

    private static JButton crearBotonEmpleado(){
        JButton boton = new JButton("Empleado");
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\empleado.jpg";
        ImageIcon imagenEmpleado = new ImageIcon(ruta);
        boton.setIcon(imagenEmpleado);
        Image cambiar_tamayoEmpleado = imagenEmpleado.getImage().getScaledInstance(400,800, Image.SCALE_SMOOTH);
        imagenEmpleado.setImage(cambiar_tamayoEmpleado);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }
    private static JButton crearBotonMesas(){
        JButton boton = new JButton("Mesas");
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\mesas.jpg";
        ImageIcon imagenMesas = new ImageIcon(ruta);
        boton.setIcon(imagenMesas);
        Image cambiar_tamayoMesas = imagenMesas.getImage().getScaledInstance(400,800, Image.SCALE_SMOOTH);
        imagenMesas.setImage(cambiar_tamayoMesas);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }
    private static JButton crearBotonProductos(){
        JButton boton = new JButton("Camarero");
        String ruta = new File("").getAbsolutePath()+"\\imagenes\\productos.jpg";
        ImageIcon imagenProducto = new ImageIcon(ruta);
        boton.setIcon(imagenProducto);
        Image cambiar_tamayoProducto = imagenProducto.getImage().getScaledInstance(400,800, Image.SCALE_SMOOTH);
        imagenProducto.setImage(cambiar_tamayoProducto);
        //boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
    }




}
