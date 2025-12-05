import javax.swing.*;
import java.awt.*;

public class InstruccionesAhorcado extends JFrame {
    public InstruccionesAhorcado() {
        setTitle("Instrucciones del Ahorcado");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("INSTRUCCIONES", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo, BorderLayout.NORTH);

        JTextArea instrucciones = new JTextArea();
        instrucciones.setText("JUEGO DEL AHORCADO\n\n" +
                "Adivina la palabra secreta antes de\n" +
                "quedarte sin intentos.\n\n" +
                "1. Se muestra una palabra con guiones.\n" +
                "2. Presiona las letras que crees que están.\n" +
                "3. Si la letra está, aparece en su posición.\n" +
                "4. Si no está, pierdes un intento.\n" +
                "5. Tienes 6 intentos.\n\n");

        instrucciones.setFont(new Font("Arial", Font.PLAIN, 16));
        instrucciones.setEditable(false);
        instrucciones.setLineWrap(true);
        instrucciones.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(instrucciones);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar, BorderLayout.SOUTH);

        add(panel);
    }
}