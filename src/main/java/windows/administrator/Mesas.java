package windows.administrator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static windows.Window.pantalla;

public class Mesas extends JFrame {

    private static final ImageIcon imagenFondo = getRutaImagenFondo();

    JPanel panelPrincipal = crearPanelImagenFondo();

    public Mesas(){
        JPanel panelSuperior = new JPanel(new BorderLayout());
        JPanel formulario = new JPanel(new GridLayout(0, 1));
        JPanel botones = new JPanel();

        // BOTONES
        JButton crear = new JButton("CREAR");
        JButton buscar = new JButton("BUSCAR");
        JButton modificar = new JButton("MODIFICAR");
        JButton eliminar = new JButton("ELIMINAR");

        botones.add(crear);
        botones.add(buscar);
        botones.add(modificar);
        botones.add(eliminar);

        formulario.setOpaque(false);
        formulario.setSize(new Dimension(300, 300));
        formulario.add(Box.createRigidArea(new Dimension(5, 0)));
        formulario.setBorder(BorderFactory.createLineBorder(Color.red, 3));

        botones.setBounds(100,100,500,200);
        botones.setOpaque(false);

        panelSuperior.setSize(new Dimension(700, 700));
        panelSuperior.setBorder(new EmptyBorder(100,100,100,100));
        panelSuperior.setOpaque(false);
        panelSuperior.add(formulario, BorderLayout.CENTER);

        panelPrincipal.add(panelSuperior, BorderLayout.CENTER);
        panelPrincipal.add(botones, BorderLayout.SOUTH);


        // CONFIGURACIÓN DEL PANEL
        setContentPane(panelPrincipal);
        setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null); // POSICION CENTRADA
        pack();
        setSize(pantalla);
        setResizable(false);
        setVisible(true);
    }

    private JPanel crearPanelImagenFondo(){
        JPanel panel = new JPanel(new BorderLayout()){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo.getImage(), 0, 0, null);
            }

        };
        return panel;
    }

    private static ImageIcon getRutaImagenFondo(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\mesas.jpg";
        ImageIcon imagenMesa = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenMesa.getImage()
                .getScaledInstance(1400,
                        pantalla.height,
                        Image.SCALE_SMOOTH);
        imagenMesa.setImage(cambiar_tamayo);
        return imagenMesa;
    }

    private List<JButton> botonesFormularios (){
        List<JButton> botonesLista = new ArrayList<>();

        // CREAR
        JButton crear = new JButton("CREAR");

        // BUSCAR
        JButton buscar = new JButton("BUSCAR");


        JButton modificar = new JButton("MODIFICAR");
        JButton eliminar = new JButton("ELIMINAR");

        botonesLista.add(crear);
        botonesLista.add(buscar);
        botonesLista.add(modificar);
        botonesLista.add(eliminar);
        return botonesLista;
    }

}
