package seguridad;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Parra
 */
public class Interfaz {

    public static ArrayList interfaz = new ArrayList<JFrame>();

    public Interfaz() {
    }

    public static ArrayList getInterfaz() {
        return interfaz;
    }

    public static void setInterfaz(ArrayList interfaz) {
        Interfaz.interfaz = interfaz;
    }

    public static JFrame getInterfaz(int index) {
        return (JFrame) interfaz.get(index);
    }

}
