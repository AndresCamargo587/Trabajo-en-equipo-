import javax.swing.*;
import java.awt.*;

public class InstruccionesParejasLocas extends JFrame {
    public InstruccionesParejasLocas() {
        setTitle("Instrucciones del Juego");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel titulo = new JLabel("Instrucciones del Juego de Memoria");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JTextArea instrucciones = new JTextArea();
        instrucciones.setText( "El tablero tiene 16 cartas con 8 parejas de letras. Haz clic en una carta para ver la letra que contiene.\n\n" +
                "2. Luego haz clic en otra carta.\n\n" +
                "3. Si las dos cartas tienen la misma letra, permanecerán visibles.\n\n" +
                "4. Si son diferentes, se voltearán de nuevo después de 1 segundo.\n\n" +
                "5. El objetivo es encontrar todas las parejas de letras.");
        instrucciones.setFont(new Font("Arial", Font.PLAIN, 14));
        instrucciones.setEditable(false);
        instrucciones.setLineWrap(true);
        instrucciones.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(instrucciones);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton Cerrar = new JButton("Cerrar");
        Cerrar.addActionListener(_ -> dispose());
        panel.add(Cerrar, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        InstruccionesParejasLocas instrucciones = new InstruccionesParejasLocas();
        instrucciones.setVisible(true);
    }
}