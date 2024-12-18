package Calculadora;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    public int suma(int n1, int n2) {
        return n1 + n2;
    }

    public int resta(int n1, int n2) {
        return n1 - n2;
    }

    public int multiplicacion(int n1, int n2) {
        return n1 * n2;
    }

    public int division(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return n1 / n2;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menú de la Calculadora ===");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = scanner.nextInt();

                if (opcion == 5) {
                    continuar = false;
                    System.out.println("Saliendo del programa. ¡Adiós!");
                    break;
                }

                System.out.print("Ingrese el primer número: ");
                int n1 = scanner.nextInt();
                System.out.print("Ingrese el segundo número: ");
                int n2 = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado de la suma: " + calculadora.suma(n1, n2));
                        break;
                    case 2:
                        System.out.println("Resultado de la resta: " + calculadora.resta(n1, n2));
                        break;
                    case 3:
                        System.out.println("Resultado de la multiplicación: " + calculadora.multiplicacion(n1, n2));
                        break;
                    case 4:
                        try {
                            System.out.println("Resultado de la división: " + calculadora.division(n1, n2));
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }

        scanner.close();
    }
}
