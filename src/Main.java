import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        while(true) {

        System.out.println("Menu");
        System.out.println("1. Triqui");
        System.out.println("2. Calculadora");
        System.out.println("3. Parejas locas");
        System.out.println("4. Ahorcado");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                new Triqui();
                break;
            case 2:
                new Calculadora();
                break;
            case 3:
                new Parejaslocas();
                break;
            case 4:
                new Ahorcado();
                break;
            case 5:
                return;
        }
    }
} }


