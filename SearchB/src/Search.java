import java.util.Scanner;

import src.*;

public class Search {
  public static void main(String[] args) {
    ArbolBB asesores = new ArbolBB();
    ArbolBB clientes = new ArbolBB();

    initializer(asesores, clientes);
    
    menu(asesores, clientes);
  }

  public static void addAsesor (ArbolBB a, String name) {
    NodoABB tmp = new NodoABB();
    tmp.getDato().addNodo(name);
    a.addNodoABB(tmp);
  }

  public static void addClient (NodoABB main, ArbolBB clients, String asesor, String cliente) {
    NodoABB tmp = ArbolBB.searchByName(main, asesor);
    if (tmp == null) {
      System.out.println("\u001B[31m" + "No existe el asesor" + "\u001B[0m");
      return;
    }
    tmp.getDato().addNodo(cliente);
    NodoABB client = new NodoABB();
    client.getDato().addNodo(cliente);
    client.getDato().addNodo(asesor);
    clients.addNodoABB(client);
  }

  public static void searchClients (NodoABB a, String name) {
    NodoABB tmp = ArbolBB.searchByName(a, name);
    if (tmp == null) {
      System.out.println("No existen registros de " + name);
      return;
    }
    System.out.println("--------------------------------------------------");
    tmp.getDato().mostrar("Asesor", "Clientes");
    System.out.println("--------------------------------------------------");
  }

  public static void searchAsessor (NodoABB a, String name) {
    NodoABB tmp = ArbolBB.searchByName(a, name);
    if (tmp == null) {
      System.out.println("No existen registros de " + name);
      return;
    }
    System.out.println("--------------------------------------------------");
    tmp.getDato().mostrar("Cliente", "Asesor");
    System.out.println("--------------------------------------------------");
  }

  public static void menu (ArbolBB asesores, ArbolBB clientes) {
    Scanner s = new Scanner(System.in);
    int option = 0;
    String name;
    do {
      System.out.println("Digite una opcion:\n1. Listar los cliente segun asesor.\n2. Conocer al asesor segun nombre del cliente.\n3. Listar a todos los asistentes con sus clientes.");
      
      option = s.nextInt();
      s.nextLine();
      switch (option) {
        case 1:
          System.out.println("Ingresa el nombre del asesor: ");            
          name = s.nextLine();
          searchClients(asesores.getRoot(), name);
          break;
        case 2:
          System.out.println("Ingresa el nombre del cliente: ");            
          name = s.nextLine();
          searchAsessor(clientes.getRoot(), name);
          break;
        case 3:
          ArbolBB.mostrarArbolBB(asesores.getRoot());
          break;
      }
      
    } while (option == 1 || option == 2 || option == 3);
    s.close();
  }

  public static void initializer (ArbolBB a, ArbolBB c) {
    addAsesor(a, "Gabriel");
    addAsesor(a, "Sofía");
    addAsesor(a, "Mateo");
    addAsesor(a, "Valentina");
    addAsesor(a, "Miguel");
    addAsesor(a, "Lorena");
    addAsesor(a, "Diego");
    addAsesor(a, "Ana");
    addAsesor(a, "Lucía");
    addAsesor(a, "Juan");

    addClient(a.getRoot(), c, "Gabriel", "Ana");
    addClient(a.getRoot(), c, "Gabriel", "Pedro");
    addClient(a.getRoot(), c, "Gabriel", "María");
    addClient(a.getRoot(), c, "Gabriel", "Luis");
    addClient(a.getRoot(), c, "Gabriel", "Laura");
    addClient(a.getRoot(), c, "Gabriel", "Carlos");
    addClient(a.getRoot(), c, "Gabriel", "Sofía");
    addClient(a.getRoot(), c, "Gabriel", "Diego");
    addClient(a.getRoot(), c, "Gabriel", "Elena");
    addClient(a.getRoot(), c, "Gabriel", "Juan");

    addClient(a.getRoot(), c, "Sofía", "Manuel");
    addClient(a.getRoot(), c, "Sofía", "Julia");
    addClient(a.getRoot(), c, "Sofía", "David");
    addClient(a.getRoot(), c, "Sofía", "Lucía");
    addClient(a.getRoot(), c, "Sofía", "Pablo");
    addClient(a.getRoot(), c, "Sofía", "Carmen");
    addClient(a.getRoot(), c, "Sofía", "Javier");
    addClient(a.getRoot(), c, "Sofía", "Valeria");
    addClient(a.getRoot(), c, "Sofía", "Alejandro");

    addClient(a.getRoot(), c, "Mateo", "Fernanda");
    addClient(a.getRoot(), c, "Mateo", "Martín");
    addClient(a.getRoot(), c, "Mateo", "Isabella");
    addClient(a.getRoot(), c, "Mateo", "Andrés");
    addClient(a.getRoot(), c, "Mateo", "Valentina");
    addClient(a.getRoot(), c, "Mateo", "Francisco");
    addClient(a.getRoot(), c, "Mateo", "Camila");
    addClient(a.getRoot(), c, "Mateo", "Gonzalo");
    addClient(a.getRoot(), c, "Mateo", "Renata");

    addClient(a.getRoot(), c, "Valentina", "Tomás");
    addClient(a.getRoot(), c, "Valentina", "Paula");
    addClient(a.getRoot(), c, "Valentina", "Miguel");
    addClient(a.getRoot(), c, "Valentina", "Gabriela");
    addClient(a.getRoot(), c, "Valentina", "Santiago");
    addClient(a.getRoot(), c, "Valentina", "Victoria");
    addClient(a.getRoot(), c, "Valentina", "Emilio");
    addClient(a.getRoot(), c, "Valentina", "Daniela");

    addClient(a.getRoot(), c, "Miguel", "Mateo");
    addClient(a.getRoot(), c, "Miguel", "Eva");
    addClient(a.getRoot(), c, "Miguel", "Bruno");
    addClient(a.getRoot(), c, "Miguel", "Natalia");
    addClient(a.getRoot(), c, "Miguel", "Alex");
    addClient(a.getRoot(), c, "Miguel", "Raquel");
    addClient(a.getRoot(), c, "Miguel", "Fernando");
    addClient(a.getRoot(), c, "Miguel", "Alba");

    addClient(a.getRoot(), c, "Lorena", "Joaquín");
    addClient(a.getRoot(), c, "Lorena", "Adriana");
    addClient(a.getRoot(), c, "Lorena", "Hugo");
    addClient(a.getRoot(), c, "Lorena", "Mónica");
    addClient(a.getRoot(), c, "Lorena", "Lucas");
    addClient(a.getRoot(), c, "Lorena", "Elsa");

    addClient(a.getRoot(), c, "Diego", "Irene");
    addClient(a.getRoot(), c, "Diego", "Maximiliano");
    addClient(a.getRoot(), c, "Diego", "Mariana");
    addClient(a.getRoot(), c, "Diego", "Eduardo");
    addClient(a.getRoot(), c, "Diego", "Olivia");
    addClient(a.getRoot(), c, "Diego", "Roberto");

    addClient(a.getRoot(), c, "Ana", "Alicia");
    addClient(a.getRoot(), c, "Ana", "Ricardo");
    addClient(a.getRoot(), c, "Ana", "Catalina");
    addClient(a.getRoot(), c, "Ana", "Felipe");
    addClient(a.getRoot(), c, "Ana", "Sara");

    addClient(a.getRoot(), c, "Lucía", "Emilia");
    addClient(a.getRoot(), c, "Lucía", "Matías");
    addClient(a.getRoot(), c, "Lucía", "Carolina");
    addClient(a.getRoot(), c, "Lucía", "Gustavo");
    addClient(a.getRoot(), c, "Lucía", "Nerea");
    addClient(a.getRoot(), c, "Lucía", "Federico");

    addClient(a.getRoot(), c, "Juan", "Isabel");
    addClient(a.getRoot(), c, "Juan", "Sebastián");
    addClient(a.getRoot(), c, "Juan", "Estefanía");
    addClient(a.getRoot(), c, "Juan", "Héctor");
  }
}
