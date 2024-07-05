import java.util.Scanner;

public class CuadradoMagico {

  public static void main(String[] args) {
    System.out.println("Digite un numero impar y positivo: ");
    Scanner scanner = new Scanner(System.in);
    int lado = scanner.nextInt();
    scanner.close();

    int[][] cuadrado = new int[lado][lado];
    int rango = (int)Math.pow(lado, 2);

    distribuirNumeros(cuadrado, rango, lado);
    mostrarCuadradoMagico(cuadrado, lado);
    mostrarSumas(cuadrado, lado);
  }

  public static void mostrarSumas (int[][] cuadrado, int lado) {
    // Sumas
    int sumaDiagPrincipal = 0;
    for (int i = 0; i < lado; i++) {
      for (int j = 0; j < lado; j++) {
        if (i == j) {
          sumaDiagPrincipal += cuadrado[i][j];
        }
      }
    }
    
    System.out.println("Suma de la diagonal principal:   " + sumaDiagPrincipal);

    int sumaDiagSecundaria = 0;
    Tracker track = new Tracker(lado - 1, 0, lado - 1);
    for (int i = 0; i < lado; i++) {
      sumaDiagSecundaria += cuadrado[track.getX()][track.getY()];
      track.moverUnoArriba();
      track.moverUnoDerecha();
    }

    System.out.println("Suma de la diagonal secundaria:  " + sumaDiagSecundaria);

    System.out.print("Suma de las lineas horizontales: ");
    int sumaHorizontal;
    for (int i = 0; i < lado; i++) {
      sumaHorizontal = 0;
      for (int j = 0; j < lado; j++) {
        sumaHorizontal += cuadrado[i][j];
      }
      System.out.printf("%4d", sumaHorizontal);
    }
    System.out.println();

    System.out.print("Suma de las lineas verticales:   ");
    int sumaVertical;
    for (int i = 0; i < lado; i++) {
      sumaVertical = 0;
      for (int j = 0; j < lado; j++) {
        sumaVertical += cuadrado[j][i];
      }
      System.out.printf("%4d", sumaVertical);
    }
    System.out.println();
  }

  public static void mostrarCuadradoMagico (int[][] cuadrado, int lado) {
    System.out.println("Cuadrado magico de orden " + lado + ": ");
    System.out.println();
    for (int i = 0; i < lado; i++) {
      for (int j = 0; j < lado; j++) {
        System.out.printf("%4d", cuadrado[i][j]);
      }
      System.out.println(); // Salto de linea
    }
    System.out.println();
  }

  public static void distribuirNumeros (int[][] cuadrado, int rango, int lado) {
    int tmp = 1;
    Tracker tracker = new Tracker((lado - 1) / 2 + 1, (lado - 1) / 2, lado -1);

    do {
      cuadrado[tracker.getX()][tracker.getY()] = tmp;

      if (tmp % lado == 0) {
        tracker.moverUnoAbajo();
        tracker.moverUnoAbajo();
      } else {
        tracker.moverUnoAbajo();
        tracker.moverUnoDerecha();
      }

      tmp++;
    } while (tmp <= rango);
  } 
}
