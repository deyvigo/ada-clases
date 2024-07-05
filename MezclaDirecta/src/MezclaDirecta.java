import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import utils.Stack;
import utils.Vector;

public class MezclaDirecta {
  public static void main(String[] args) {
    menu();
  }

  public static void menu () {
    int opcion;
    Vector vector = new Vector();
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("1. Agregar un numero al array: \n2. Ordenar por metodo de Mezcla Directa.\n3. Salir");
      opcion = scanner.nextInt();
      switch (opcion) {
        case 1:
          System.out.println("Ingresar el numero: ");
          vector.add(scanner.nextInt());
          System.out.println("Arreglo: " + Arrays.toString(vector.getArray()));
          break;
        case 2:
          order(vector.getArray());
          break;
      }
    } while (opcion == 1 || opcion == 2);
    scanner.close();
  }

  public static void order (int[] arr) {
    // Colores para la terminal
    String RESET = "\u001B[0m";
    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";

    int i = 1;
    int index = 1;
    System.out.println();
    while (i < arr.length) {
      System.out.println(RED + "Pasada: " + index + RESET);
      System.out.println("Array: " + Arrays.toString(arr));
      List<int []> dividedGroup = divider(arr, i);
      System.out.println(GREEN + "Particiones: (" + i + ")" + RESET);
      System.out.println(Arrays.toString(dividedGroup.get(0)));
      System.out.println(Arrays.toString(dividedGroup.get(1)));
      arr = joiner(dividedGroup.get(0), dividedGroup.get(1), i);
      System.out.println("Fusion:" + Arrays.toString(arr));
      index++;
      i *= 2;
    }
    System.out.println();
  }

  public static int roundDivision (int number, int divisor) {
    int result = number / divisor;
    if (number % divisor != 0) {
      result++;
    }
    return result;
  }

  public static List<int []> divider (int[] arr, int spacedBy) {
    int index = 0;
    Vector arr1 = new Vector();
    Vector arr2 = new Vector();
    int size = arr.length;
    
    while (index < size) {
      for (int i = 0; i < spacedBy; i++) {
        if (index >= size) {
          break;
        }
        arr1.add(arr[index]);
        index++;
      }
      index += spacedBy;
    }

    index = spacedBy;
    while (index < size) {
      for (int i = 0; i < spacedBy; i++) {
        if (index >= size) {
          break;
        }
        arr2.add(arr[index]);
        index++;
      }
      index += spacedBy;
    }

    return List.of(arr1.getArray(), arr2.getArray());
  }

  public static int[] joiner (int[] first, int[] second, int each) {
    int totalSize = first.length + second.length;
    int iArr1 = 0, iArr2 = 0, index = 0;
    int[] joinedArray = new int [totalSize];
    int iter = roundDivision(Math.max(first.length, second.length), each);
    for (int i = 0; i < iter; i++) {
      iArr1 = i * each;
      iArr2 = i * each;
      Stack stack1 = new Stack();
      Stack stack2 = new Stack();
      Stack aux = new Stack();

      for (int j = iArr1; j < i*each + each; j++) {
        if (j >= first.length) {
          break;
        }
        aux.push(first[j]);
      }
      while (!aux.isEmpty()) {
        stack1.push(aux.pop().getDato());
      }
      aux = new Stack();
      for (int j = iArr2; j < i*each + each; j++) {
        if (j >= second.length) {
          break;
        }
        aux.push(second[j]);
      }
      while (!aux.isEmpty()) {
        stack2.push(aux.pop().getDato());
      }

      while (!stack1.isEmpty() || !stack2.isEmpty()) {
        if (stack1.peek() < stack2.peek()) {
          joinedArray[index] = stack1.pop().getDato();
          index++;
        } else {
          joinedArray[index] = stack2.pop().getDato();
          index++;
        }
      }
    }

    return joinedArray;
  }
}
