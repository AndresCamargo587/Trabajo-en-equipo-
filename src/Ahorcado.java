import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ahorcado extends JFrame {
    private String[] palabras = {"PERRO", "GATO", "LEÓN", "DELFÍN", "PAJARO",
            "ZORRO", "BALLENA", "JIRAFA", "PEZ GLOBO", "OSO"};

    private String palabraSecreta;
    private StringBuilder palabraAdivinada;
    private int intentosRestantes = 6;
    private JLabel lblPalabra;
    private JLabel lblIntentos;
    private JLabel lblMensaje;
    private JPanel panelLetras;

    public Ahorcado() {
        setTitle("Ahorcado");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        NuevoJuego();
        Interfaz();
    }

    private void NuevoJuego() {
        Random random = new Random();
        palabraSecreta = palabras[random.nextInt(palabras.length)];
        palabraAdivinada = new StringBuilder();

        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraAdivinada.append("_ ");
        }
    }

    private void Interfaz() {
        JPanel panelSuperior = new JPanel();
        JLabel titulo = new JLabel("AHORCADO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        panelSuperior.add(titulo);
        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3, 1));

        lblPalabra = new JLabel(palabraAdivinada.toString(), SwingConstants.CENTER);
        lblPalabra.setFont(new Font("Courier New", Font.BOLD, 24));

        lblIntentos = new JLabel("Tus intentos: " + intentosRestantes, SwingConstants.CENTER);
        lblIntentos.setFont(new Font("Arial", Font.BOLD, 16));

        lblMensaje = new JLabel("Adivina la palabra", SwingConstants.CENTER);

        panelCentral.add(lblPalabra);
        panelCentral.add(lblIntentos);
        panelCentral.add(lblMensaje);
        add(panelCentral, BorderLayout.CENTER);

        panelLetras = new JPanel();
        panelLetras.setLayout(new GridLayout(4, 7, 5, 5));

        for (char letra = 'A'; letra <= 'Z'; letra++) {
            JButton Letra = new JButton(String.valueOf(letra));
            Letra.addActionListener(new AccionLetra(letra));
            panelLetras.add(Letra);
        }

        add(panelLetras, BorderLayout.SOUTH);
    }


