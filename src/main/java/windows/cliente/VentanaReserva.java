package windows.cliente;

import bbdd.ReservaBD;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import modelos.Reserva;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import javax.swing.JOptionPane;

public class VentanaReserva {
    private static final ImageIcon imagenFondo = new ImageIcon(rutaDeImagen());
    public static final Dimension pantalla = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.85), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.85));
    JFrame window = new JFrame("Restaurante Paco");// creando instancia FJframe
    static Font fuente=new Font("Arial", Font.ITALIC, 30);


    private static JTextField nombre;
    private static JTextField apellidos;
    private static JTextField telefono;
    private static JTextField num_comensales;
    private static JDateChooser fecha;

    public VentanaReserva() {

        window.setSize(pantalla); // indica tamaño de la ventana

        JPanel panel = panel1();
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setOpaque(false);

        JPanel panel2 = panel2();
        JPanel fondo = crearPanelImagenFondo();

        JButton boton_enviar = boton_enviar();

        JLabel etiquetanombre = nombre();
        nombre = new JTextField();
        etiquetanombre.setLabelFor(nombre);
        etiquetanombre.setForeground(Color.BLACK);
        nombre.setDocument(new JTextFieldLimit(50));

        JLabel etiquetaapellidos = apellidos();
        apellidos = new JTextField();
        etiquetaapellidos.setLabelFor(apellidos);
        etiquetaapellidos.setForeground(Color.BLACK);
        apellidos.setDocument(new JTextFieldLimit(100));

        JLabel etiquetatelefono = telefono();
        telefono = new JTextField();
        etiquetatelefono.setLabelFor(telefono);
        etiquetatelefono.setForeground(Color.BLACK);
        telefono.setDocument(new JTextFieldLimit(9));

        JLabel etiquetacomensales = num_comensales();
        num_comensales = new JTextField();
        etiquetacomensales.setLabelFor(num_comensales);
        etiquetacomensales.setForeground(Color.BLACK);
        num_comensales.setDocument(new JTextFieldLimit(3));

        JLabel etiquetafecha = fecha();
        fecha = new JDateChooser();
        etiquetafecha.setLabelFor(fecha);
        etiquetafecha.setForeground(Color.BLACK);


        panel.add(etiquetanombre);
        panel.add(nombre);
        panel.add(etiquetaapellidos);
        panel.add(apellidos);
        panel.add(etiquetatelefono);
        panel.add(telefono);
        panel.add(etiquetacomensales);
        panel.add(num_comensales);
        panel.add(etiquetacomensales);
        panel.add(num_comensales);
        panel.add(etiquetafecha);
        panel.add(fecha);


        //Añado archivos en Panel de los botones.
        panel2.add(boton_enviar);

        window.add(panel);
        window.add(panel2);
        window.add(fondo);
        window.setVisible(true);
    }
    private static JPanel panel1 (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2,15 ,15));
        panel.setBounds(270, 100, 900, 500);
        return panel;
    }

    private static JPanel panel2 (){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4, 5 ,5 ));
        panel.setBounds(500, 600, 500, 70);
        return panel;
    }

    public static JLabel nombre(){
        JLabel nombre = new JLabel();
        nombre.setFont(fuente);
        nombre.setText("Nombre");
        return nombre;
    }

    public static JLabel apellidos(){
        JLabel apellidos = new JLabel();
        apellidos.setFont(fuente);
        apellidos.setText("Apellidos");
        return apellidos;
    }

    public static JLabel telefono(){
        JLabel telefono = new JLabel();
        telefono.setFont(fuente);
        telefono.setText("Teléfono");
        return telefono;
    }

    public static JLabel num_comensales(){
        JLabel num_comensales = new JLabel();
        num_comensales.setFont(fuente);
        num_comensales.setText("Número de comensales");
        return num_comensales;
    }

    public static JLabel fecha(){
        JLabel fecha = new JLabel();
        fecha.setFont(fuente);
        fecha.setText("Fecha de la reserva");
        return fecha;
    }


    private static JButton boton_enviar() {

        JButton boton = new JButton("Enviar");
        boton.setFocusPainted(false);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reserva reserva = new Reserva();
                reserva.setId(0);
                reserva.setNombre(nombre.getText());
                reserva.setApellidos(apellidos.getText());
                reserva.setTelefono(telefono.getText());
                reserva.setNum_comensales(Integer.parseInt(num_comensales.getText()));

                long fechamilisegundos = fecha.getDate().getTime(); // Castear la fecha de java a sql
                java.sql.Date sqldate = new Date(fechamilisegundos);

                reserva.setFecha(sqldate);
                ReservaBD.crearReserva(reserva);

                nombre.setText(null);
                apellidos.setText(null);
                telefono.setText(null);
                num_comensales.setText(null);
                fecha.setDate(null);

                ventanaexito.infoBox("Su reserva ha sido registrada", "Restaurante Paco");
            }

        });
        // boton.addActionListener(new AccionAbrirMenuCocinero());
        return boton;
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
    private static String rutaDeImagen () {
        String ruta = new File("").getAbsolutePath() + "\\imagenes\\reserva.jpg";
        return ruta;
    }
}

    class JTextFieldLimit extends PlainDocument {
    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}

    class ventanaexito {

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}