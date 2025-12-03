import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DesarrolloParejasLocas extends JFrame {
    private final JPanel panelPrincipal;
    private final JButton[] botones;
    private final String[] letras;
    private int primerBoton = -1;
    private int segundoBoton = -1;
    private int paresEncontrados = 0;

    public DesarrolloParejasLocas() {
        setTitle("Parejas Locas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 4, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panelPrincipal);

        botones = new JButton[16];
        letras = generarLetras();

        for (int i = 0; i < 16; i++) {
            botones[i] = new JButton("?");
            botones[i].setFont(new Font("Arial", Font.BOLD, 25));
            botones[i].addActionListener(new BotonListener(i));
            panelPrincipal.add(botones[i]);
        }
    }
    private String[] generarLetras() {
        String[] letrasTemp = {"X", "X", "J", "J", "C", "C", "N", "N",
                "E", "E", "L", "L", "Z", "Z", "I", "I"};

        for (int i = 0; i < letrasTemp.length; i++) {
            int posicionAleatoria = (int) (Math.random() * letrasTemp.length);
            String temp = letrasTemp[i];
            letrasTemp[i] = letrasTemp[posicionAleatoria];
            letrasTemp[posicionAleatoria] = temp;
        }

        return letrasTemp;
    }
    private class BotonListener implements ActionListener {
        private final int indice;

        public BotonListener(int indice) {
            this.indice = indice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (botones[indice].getText().equals(letras[indice])) {
                return;
            }

            if (primerBoton != -1 && segundoBoton != -1) {
                return;
            }

            botones[indice].setText(letras[indice]);
            botones[indice].setEnabled(false);

            if (primerBoton == -1) {
                primerBoton = indice;
            } else {
                segundoBoton = indice;

                if (letras[primerBoton].equals(letras[segundoBoton])) {
                    paresEncontrados++;

                    if (paresEncontrados == 8) {
                        JOptionPane.showMessageDialog(null,
                                "¡Felicidades! Has encontrado todas las parejas.");
                    }

                    primerBoton = -1;
                    segundoBoton = -1;
                } else {
                    Timer timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            botones[primerBoton].setText("?");
                            botones[segundoBoton].setText("?");
                            botones[primerBoton].setEnabled(true);
                            botones[segundoBoton].setEnabled(true);

                            primerBoton = -1;
                            segundoBoton = -1;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }
}


