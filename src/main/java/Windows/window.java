package Windows;

import javax.swing.*;

public class window {

    public static void main(String[] args) {

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa

        window.setSize(1200, 800); // indicar tamaño de la ventana

        JButton empleado = new JButton("EMPLEADO");//creating instance of JButton
        empleado.setBounds(130,100,100, 40);//x axis, y axis, width, height from button

        JButton cliente = new JButton("CLIENTE");
        cliente.setBounds(160,100,100,40);

        window.add(empleado);//adding button in JFrame


        window.setVisible(true);// Se usa para que se vea
    }


}
