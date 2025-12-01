import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Triqui extends JFrame implements ActionListener {
    private JButton[][] botones = new JButton[3][3];
    private boolean turnoX = true; // true = X, false = O
    private JLabel estado;
    private JButton reiniciar;

    public Triqui() {
        setTitle("Triqui");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel tablero = new JPanel();
        tablero.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton("");
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                botones[i][j].addActionListener(this);
                tablero.add(botones[i][j]);
            }
        }

        estado = new JLabel("Turno de X", SwingConstants.CENTER);
        estado.setFont(new Font("Arial", Font.BOLD, 20));

        reiniciar = new JButton("Reiniciar");
        reiniciar.setFont(new Font("Arial", Font.PLAIN, 18));
        reiniciar.addActionListener(e -> reiniciarJuego());

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.add(reiniciar, BorderLayout.CENTER);

        add(estado, BorderLayout.NORTH);
        add(tablero, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

