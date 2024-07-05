import java.util.Scanner;

public class SumaMaxima {
    public static void main(String[] args) {
        int arr[] = menu();
        System.out.println("\nLa suma maxima del arreglo es: " + maxSuma(arr) + "\n");
    }
    
    public static int maxSuma (int []arr) {
        int sumaActual = arr[0];
        int sumaMaxima = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumaActual = max(sumaActual + arr[i], arr[i]);
            sumaMaxima = max(sumaActual, sumaMaxima);
        }
        return sumaMaxima;
    }

    public static int max(int prev, int next) {
        if (prev >= next) {
            return prev;
        } else {
            return next;
        }
    }

    // Para el menu
    public static int[] menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("Digite el tamano del arreglo que desea: ");
        opcion = scanner.nextInt();
        int arr[] = new int[opcion];
        for (int i = 0; i < opcion; i++) {
            System.out.println("Digite el elemento " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        return arr;
    }
}
