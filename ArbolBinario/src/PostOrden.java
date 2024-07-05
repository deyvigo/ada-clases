import java.util.Scanner;

import src.ArbolBinario;
import src.Nodo;

public class PostOrden {

  public static void main(String[] args) {
    ArbolBinario ab = new ArbolBinario();
    ab.addNodo(new Nodo(4));
    ab.addNodo(new Nodo(2));
    ab.addNodo(new Nodo(5));
    ab.addNodo(new Nodo(1));
    ab.addNodo(new Nodo(3));
    ab.addNodo(new Nodo(6));

    ab.mostrarPostOrden();
    ab.mostrarPreOrden();
    ab.mostrarInOrder();
    // menu(ab);
  }

  public static void menu (ArbolBinario ab) {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
      System.out.println("1. Agregar nodo al arbol binario. \n2. Mostrar arbol en postorden.");
      opcion = scanner.nextInt();
      switch (opcion) {
        case 1:
          System.out.println("Digite el valor del nodo: ");
          ab.addNodo(new Nodo(scanner.nextInt()));
          break;
        case 2:
          ab.mostrarPostOrden();
          break;
      }
    } while (opcion == 1 || opcion == 2);
    scanner.close();
  }
    
}
