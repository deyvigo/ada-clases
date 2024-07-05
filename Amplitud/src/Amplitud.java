import java.util.List;
import java.util.Scanner;

import structures.Graph;
import structures.Vertex;

public class Amplitud {

  public static void main(String[] args) {
    menu();
  }

  public static void menu () {
    Graph graph = new Graph();
    int opcion, vertex, from, to;
    List<Vertex> salida;
    System.out.println("---------------------------------------");
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("1. Usar el grafo del laboratorio. \n2. Crear un nuevo grafo.\n3. Salir");
      opcion = scanner.nextInt();
      switch (opcion) {
        case 1:
          graph.addVertex(1);
          graph.addVertex(2);
          graph.addVertex(3);
          graph.addVertex(4);
          graph.addVertex(5);
      
          graph.addEdge(1, 2);
          graph.addEdge(1, 4);
          graph.addEdge(1, 5);
          graph.addEdge(2, 3);
          graph.addEdge(2, 5);
          graph.addEdge(3, 4);
          graph.addEdge(5, 4);
          
          salida = graph.amplitud(1);
        
          System.out.println("\n************************************");
          System.out.println("Recorrido por amplitud: ");
      
          for (Vertex v: salida) {
            System.out.print(v.getData() + " ");
          }
          System.out.println("\n************************************");
          
          break;
        case 2:
          graph = new Graph();
          do {
            System.out.println("---------------------------------------");
            System.out.println("1. Agregar un vertice. \n2. Agregar una arista.\n3. Terminar (Obtener recorrido por amplitud)");
            opcion = scanner.nextInt();
            switch (opcion) {
              case 1:
                System.out.println("Ingresar un vertice: (int)");
                vertex = scanner.nextInt();
                graph.addVertex(vertex);
                break;
              case 2:
                System.out.println("Ingresar el vertice del que parte la arista: ");
                from = scanner.nextInt();
                System.out.println("Ingresar el vertice final de la arista:");
                to = scanner.nextInt();
                graph.addEdge(from, to);
                break;
            }
          } while (opcion == 1 || opcion == 2);

          salida = graph.amplitud(graph.getFirst());
          
          System.out.println("\n************************************");
          System.out.println("Recorrido por amplitud: ");
      
          for (Vertex v: salida) {
            System.out.print(v.getData() + " ");
          }
          System.out.println("\n************************************");

          System.out.println("---------------------------------------");
          break;
      }
      System.out.println("---------------------------------------");
    } while (opcion == 1 || opcion == 2);
    scanner.close();
  } 
}
