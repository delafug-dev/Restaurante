package utilidades;

import javax.swing.*;
import java.awt.*;

public class UtilidadesFormulario {

    public static Object obtenerTextoComponente(JPanel formulario , String nombre){
        Object valor = "";

        for(Component c: formulario.getComponents()){
            if(c instanceof JTextField){
                JTextField input = (JTextField) c;
                if(input.getName().equals(nombre)) {
                    valor = input.getText();
                }
            }else if(c instanceof JComboBox){
                JComboBox comboBox = (JComboBox) c;
                if(comboBox.getName().equals(nombre)) {
                    valor = comboBox.getModel().getSelectedItem();
                }
            }

        }

        return  valor;
    }

    public static void ponerValorComponente(JPanel formulario , String nombreComponente, Object valor){

        for(Component c: formulario.getComponents()){
            if(c instanceof JTextField){
                JTextField input = (JTextField) c;
                if(input.getName().equals(nombreComponente)) {
                    input.setText(valor.toString());
                }
            }else if(c instanceof JComboBox){
                JComboBox comboBox = (JComboBox) c;
                if(comboBox.getName().equals(nombreComponente)) {
                    comboBox.getModel().setSelectedItem(valor);
                }
            }
        }
    }




}

