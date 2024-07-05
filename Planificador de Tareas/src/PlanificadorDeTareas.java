import java.util.Vector;

import src.Task;

public class PlanificadorDeTareas {

  public static void main(String[] args) {
    Vector<Task> tareas = new Vector<Task>();
    menu(tareas);
  }

  public static int maxBeneficios(int N, Vector<Task> tasks) {
    // Ordena las tareas por beneficio en orden descendente
    tasks.sort((a, b) -> b.benefit - a.benefit);

    // Array para rastrear las tareas asignadas a cada plazo
    boolean[] slots = new boolean[N];
    int totalBenefit = 0;

    // Iterar sobre cada tarea
    for (Task task : tasks) {
      // Encuentra el último plazo disponible para esta tarea
      for (int j = Math.min(N, task.plazo) - 1; j >= 0; j--) {
        if (!slots[j]) {
          // Asigna la tarea a este plazo
          slots[j] = true;
          totalBenefit += task.benefit;
          break;
        }
      }
    }
    return totalBenefit;
  }

  public static void menu (Vector<Task> tareas) {
    int opcion = 0;
    int position = 0;
    do {
      System.out.println("1. Agregar tarea");
      System.out.println("2. Mostrar tareas");
      System.out.println("3. Usar Datos de Prueba");
      System.out.println("4. Calcular beneficio máximo");
      System.out.println("5. Salir");
      System.out.print("Opción: ");
      opcion = Integer.parseInt(System.console().readLine());
      switch (opcion) {
        case 1:
          position++;
          System.out.print("Beneficio: ");
          int benefit = Integer.parseInt(System.console().readLine());
          System.out.print("Plazo: ");
          int plazo = Integer.parseInt(System.console().readLine());
          tareas.add(new Task(position, benefit, plazo));
          break;
        case 2:
          for (Task tarea : tareas) {
            System.out.println("Posición: " + tarea.position + ", Beneficio: " + tarea.benefit + ", Plazo: " + tarea.plazo);
          }
          break;
        case 3:
          tareas.add(new Task(1, 100, 2));
          tareas.add(new Task(2, 10, 1));
          tareas.add(new Task(3, 15, 2));
          tareas.add(new Task(4, 27, 1));
          break;
        case 4:
          System.out.print("Número máximo de plazos disponibles: ");
          int N = Integer.parseInt(System.console().readLine());
          int maxBenefit = maxBeneficios(N, tareas);
          System.out.println("Max beneficio: " + maxBenefit);
          break;
        case 5:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción inválida");
          break;
      }
    } while (opcion != 4);
  }
  
}
