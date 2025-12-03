import javax.swing.*;

public class Parejaslocas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DesarrolloParejasLocas juego = new DesarrolloParejasLocas();
            juego.setVisible(true);

            InstruccionesParejasLocas instrucciones = new InstruccionesParejasLocas();
            instrucciones.setVisible(true);
        });
    }
}