/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ventanas.CifradoCesar;
import ventanas.DescifradoCesar;
import ventanas.Menu;
import ventanas.Opciones;

/**
 *
 * @author Oriana
 */
public class Main {

    public static void main(String args[]) {
        Menu main = new Menu();
        main.setVisible(true);

        Opciones opciones = new Opciones();
        CifradoCesar cifradoCesar = new CifradoCesar();
        DescifradoCesar descifradoCesar = new DescifradoCesar();
        

        Interfaz.getInterfaz().add(0, main);
        Interfaz.getInterfaz().add(1, opciones);
        Interfaz.getInterfaz().add(2, cifradoCesar);
        Interfaz.getInterfaz().add(3, descifradoCesar);
        
    }
}
