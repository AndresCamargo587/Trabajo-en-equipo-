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
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        if (!boton.getText().equals("")) {
            return;
        }

        if (turnoX) {
            boton.setText("X");
            estado.setText("Turno de O");
        } else {
            boton.setText("O");
            estado.setText("Turno de X");
        }

        turnoX = !turnoX;

        if (hayGanador()) {
            estado.setText("Ganador: " + (turnoX ? "O" : "X") + "!");
            deshabilitarBotones();
        } else if (tableroLleno()) {
            estado.setText("Empate");
        }
    }

    private boolean hayGanador() {
        for (int i = 0; i < 3; i++) {
            if (!botones[i][0].getText().equals("") &&
                    botones[i][0].getText().equals(botones[i][1].getText()) &&
                    botones[i][1].getText().equals(botones[i][2].getText())) {
                return true;
            }
            if (!botones[0][i].getText().equals("") &&
                    botones[0][i].getText().equals(botones[1][i].getText()) &&
                    botones[1][i].getText().equals(botones[2][i].getText())) {
                return true;
            }
        }
        if (!botones[0][0].getText().equals("") &&
                botones[0][0].getText().equals(botones[1][1].getText()) &&
                botones[1][1].getText().equals(botones[2][2].getText())) {
            return true;
        }
        if (!botones[0][2].getText().equals("") &&
                botones[0][2].getText().equals(botones[1][1].getText()) &&
                botones[1][1].getText().equals(botones[2][0].getText())) {
            return true;
        }

        return false;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (botones[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void deshabilitarBotones() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setEnabled(false);
            }
        }
    }

    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setText("");
                botones[i][j].setEnabled(true);
            }
        }
        turnoX = true;
        estado.setText("Turno de X");
    }
}