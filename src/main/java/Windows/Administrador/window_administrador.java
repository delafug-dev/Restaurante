package Windows.Administrador;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class window_administrador {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa

        window.setSize(1200, 800); // indicar tamaño de la ventana
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(500, 350, 200, 50);
        JPanel panel2 = new JPanel();

        panel2.setLayout(new GridLayout(1,0));

        panel2.setBounds(500, 300, 200, 50);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.cyan);
        //panel.add(Box.createRigidArea(new Dimension(0, 500)));
        JButton boton_empleado, boton_productos, boton_mesas;
        boton_empleado = new JButton("Empleado");
        boton_productos = new JButton("Producto");
        boton_mesas = new JButton("Mesas");
        panel.add(boton_empleado);
        panel2.add(boton_productos);
        panel2.add(boton_mesas);

        window.add(panel);
        window.add(panel2);
        window.add(panel3);
        window.setVisible(true);

    }
}
