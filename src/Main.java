import java.util.Scanner;
import javax.swing.*;
public class Main {
    static Scanner leer = new Scanner(System.in);
    static String name;

    public static void main(String[] args) {
        System.out.println("Bienvenido, a continuación ingrese su nombre");
        Scanner leer = new Scanner(System.in);
        name = leer.nextLine();
        int opcion;

        do {
            System.out.println(name + ", ingrese el numero del juego que desea lanzar. \n" +
                    "1. Triqui.\n" +
                    "2. Calculadora.\n" +
                    "3. Parejas locas.\n" +
                    "4. Ahorcado.\n" +
                    "0. Salir del menú.");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    new Triqui();
                    break;
                case 2:
                    new Calculadora();
                    break;
                case 3:
                    System.out.println("Cargando...");
                    SwingUtilities.invokeLater(() -> {
                        InstruccionesParejasLocas instrucciones = new InstruccionesParejasLocas();
                        instrucciones.setVisible(true);
                        DesarrolloParejasLocas juego = new DesarrolloParejasLocas();
                        juego.setVisible(true);
                    });
                    break;
                case 4:
                    new Ahorcado();
                    break;
                case 5:
                    return;
            }
        } while (opcion != 0);
    }
}





