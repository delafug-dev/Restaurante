package windows.cocinero;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import static windows.Window.pantalla;

public class Window_Cocinero extends JFrame{

    private static final ImageIcon imagenFondo = rutaDeImagen();
    JPanel panelPrincipal = crearPanelImagenFondo();

    public Window_Cocinero(){

        // JPanenls
        JPanel window_cocinero = new JPanel(new BorderLayout());
        JPanel comanda = new JPanel(new GridLayout(0,1));

        // JButtons
        JButton comandasButton = new JButton("COMANDAS", icono_comanda());
        comandasButton.setOpaque(false);
        comanda.add(comandasButton);

        comanda.setPreferredSize(new Dimension(500,500));
        comanda.setBorder(BorderFactory.createEmptyBorder(200,250,200,250));
        window_cocinero.setSize(new Dimension(100,100));
        window_cocinero.setBorder(new EmptyBorder(100,100,100,100));
        comanda.setOpaque(false);
        window_cocinero.add(comanda);
        window_cocinero.setOpaque(false);
        panelPrincipal.add(window_cocinero, BorderLayout.CENTER);


        // Configuración Window_Cocinero
        setResizable(false);
        setContentPane(panelPrincipal);
        setSize(pantalla);
        setVisible(true);
    }

    private static ImageIcon rutaDeImagen(){
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\window_cocinero.jpg";
        ImageIcon imagenCocinero = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenCocinero.getImage()
                .getScaledInstance(1400,pantalla.height, Image.SCALE_SMOOTH);
        imagenCocinero.setImage(cambiar_tamayo);
        return imagenCocinero;
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

    private static ImageIcon icono_comanda(){

        String ruta = new File("").getAbsolutePath() + "\\imagenes\\icono_comanda.png";
        ImageIcon imagenComanda = new ImageIcon(ruta);
        Image cambiar_tamayo = imagenComanda.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        imagenComanda.setImage(cambiar_tamayo);

        return imagenComanda;
    }

}