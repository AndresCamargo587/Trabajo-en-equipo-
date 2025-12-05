import javax.swing.*;

public class LanzadorAhorcado {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ahorcado juego = new Ahorcado();
            juego.setVisible(true);
        });
    }
}