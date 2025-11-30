import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Triqui");
        System.out.println("2. Calculadora");
        System.out.println("3. Parejas locas");
        System.out.println("4. Ahorcado");
        System.out.print("Seleccione una opción: ");

        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                Triqui.();
                break;
            case 2:
                Calculadora.();
                break;
            case 3:
                Parejaslocas.();
                break;
            case 4:
                Ahorcado.();
        }
    }
}


