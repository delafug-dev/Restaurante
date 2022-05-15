package windows.camarero;

import windows.administrator.Empleado;
import windows.administrator.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static windows.Window.pantalla;

public class Aforo extends JFrame{
    static Font fuente=new Font("Arial", Font.ITALIC, 30);
    private static final ImageIcon imagenFondo = rutaDeImagen();
    public Aforo(){

        JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sirve para cuando se cierre la ventana se finalice el programa
        window.setSize(pantalla); // indica tamaño de la ventana

        JPanel panel2 = pane2();
        JPanel fondo = crearPanelImagenFondo();
        panel2.setOpaque(false);


        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner numeroProductos = new JSpinner(model);


        //TABLA COMANDA
        Object[] columnas = {"Nº Mesa",
                "Libre"};
        Object[][] datos = {{"",""}};
        JTable tablaComanda = new JTable(datos , columnas);

        //PANEL TABLA COMANDA
        JScrollPane scrollPane = new JScrollPane(tablaComanda);
        tablaComanda.setFillsViewportHeight(true);

        panel2.add(scrollPane);
        window.add(panel2);
        window.add(fondo);

        window.setVisible(true);
    }

    private static ImageIcon rutaDeImagen(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\aforo.jpg";
        ImageIcon imagenMesa = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenMesa.getImage()
                .getScaledInstance(1300, pantalla.height, Image.SCALE_SMOOTH);
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

    private static JPanel pane2() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0, 5,5));
        panel.setBounds(300, 300, 600, 100);
        return panel;
    }

}

