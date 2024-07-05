import java.util.Scanner;

import src.Data;

public class Compare {
  public static void main(String[] args) {
    int opcion = 0;
    int quantityNumbers = 0;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("Elige el tamano del arreglo que deseas ordenar: \n1. 1 000\n2. 10 000\n3. 90 000\n4. 100 000\n5. 200 000\n6. 300 000\n7. 500 000");
      opcion = scanner.nextInt();
      System.out.println("------------------------------------------------");
      switch (opcion) {
        case 1:
          quantityNumbers = 1000;
          break;
        case 2:
          quantityNumbers = 10000;
          break;
        case 3:
          quantityNumbers = 90000;
          break;
        case 4:
          quantityNumbers = 100000;
          break;
        case 5:
          quantityNumbers = 200000;
          break;
        case 6:
          quantityNumbers = 300000;
          break;
        case 7:
          quantityNumbers = 500000;
          break;
      }
      System.out.println("Longitud del arreglo a ordenar: " + Data.getArray(quantityNumbers).length);
      printStatsHeapSort(quantityNumbers); // ordena el arreglo con el metodo HeapSort y muestra el tiempo y el numero de intercambios realizados
      printStatsBubbleSort(quantityNumbers); // ordena el arreglo con el metodo BubbleSort y muestra el tiempo y el numero de intercambios realizados
      System.out.println("------------------------------------------------");
    } while (opcion > 0 || opcion <= 7);
    scanner.close();
    // Data.generateData(90000); // <- funcion para generar los archivos de datos
    // Si se pone mas 500 000 el programa se rompe porque BubbleSort demora mucho en ordenarlo.
  }

  public static void printStatsHeapSort (int n) {
    int arr[] = Data.getArray(n);
    long[] countCompare = {0};
    System.out.println("- Heap Sort");

    long initTime = System.nanoTime();
    insertionHeap(arr);
    heapSort(arr, arr.length, countCompare);
    long endTime = System.nanoTime();

    System.out.println("Tiempo de Heap Sort: " + (endTime - initTime) + " nanosegundos.");
    System.out.println("Numero de intercambios: " + countCompare[0]);
  }

  public static void printStatsBubbleSort (int n) {
    int arr[] = Data.getArray(n);
    long[] countCompare = {0};
    System.out.println("- Bubble Sort");

    long initTime = System.nanoTime();
    bubbleSort(arr, arr.length, countCompare);
    long endTime = System.nanoTime();

    System.out.println("Tiempo de Bubble Sort: " + (endTime - initTime) + " nanosegundos.");
    System.out.println("Numero de intercambios: " + countCompare[0]);
  }
  
  public static void insertionHeap (int[] arr) {
    int index = 1;
    while (index < arr.length) {
      int auxIndex = index;
      while (auxIndex > 0) {
        int parentIndex = (auxIndex - 1) / 2;
        if (arr[auxIndex] > arr[parentIndex]) {
          int temp = arr[auxIndex];
          arr[auxIndex] = arr[parentIndex];
          arr[parentIndex] = temp;
          auxIndex = parentIndex;
        } else {
          break;
        }
      }
      index++;
    }
  }

  public static void heapify (int arr[], int maxRange, long[] countCompare) {
    int index = 0;
    int maxIndex = 0;
    while (index <= maxRange) {
      int childLeft = index*2 + 1;
      int childRight = index*2 + 2;

      if (childLeft > maxRange && childRight > maxRange) {
        break;
      }
      if (childLeft > maxRange && childRight <= maxRange) {
        maxIndex = childRight;
      }
      if (childRight > maxRange && childLeft <= maxRange) {
        maxIndex = childLeft;
      }
      if (childLeft <= maxRange && childRight <= maxRange ) {
        maxIndex = arr[childLeft] > arr[childRight] ? childLeft : childRight;
      }

      //change
      if (arr[index] < arr[maxIndex]) {
        int temp = arr[index];
        arr[index] = arr[maxIndex];
        arr[maxIndex] = temp;
        index = maxIndex;
        countCompare[0]++;
      } else {
        break;
      }
    }
  }

  public static void heapSort (int[] arr, int N, long[] countCompare) {
    for (int i = 1; i <= N - 1; i++) {
      int temp = arr[N - i];
      arr[N - i] = arr[0];
      arr[0] = temp;
      if (i < N - 1) {
        heapify(arr, N - i - 1, countCompare);
      }
    }
  }

  public static void bubbleSort (int[] arr, int n, long[] countCompare) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          countCompare[0]++;
        }
      }
    }
  }
}
