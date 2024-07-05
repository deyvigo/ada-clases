package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import search.src.*;

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
    tmp.getDato().mostrar("-- Asesor --", "-- Clientes --");
    System.out.println("--------------------------------------------------");
  }

  public static void searchAsessor (NodoABB a, String name) {
    NodoABB tmp = ArbolBB.searchByName(a, name);
    if (tmp == null) {
      System.out.println("No existen registros de " + name);
      return;
    }
    System.out.println("--------------------------------------------------");
    tmp.getDato().mostrar("-- Cliente --", "-- Asesor --");
    System.out.println("--------------------------------------------------");
  }

  public static void menu (ArbolBB asesores, ArbolBB clientes) {
    Scanner s = new Scanner(System.in);
    int option = 0;
    String name;
    do {
      System.out.println("Digite una opcion:\n1. Listar los clientes segun asesor.\n2. Conocer al asesor segun nombre del cliente.\n3. Listar a todos los asesores con sus clientes.");
      
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
    try {
      String path = "src/main/java/search/data/data.json";
      String jsonContent = new String(Files.readAllBytes(Paths.get(path)));

      JSONArray asesores = new JSONArray(jsonContent);
      for (int i = 0; i < asesores.length(); i++) {
        JSONObject asesor = asesores.getJSONObject(i);
        addAsesor(a, asesor.getString("asesor"));
        JSONArray clientes = asesor.getJSONArray("clientes");
        for (int j = 0; j < clientes.length(); j++) {
          JSONObject cliente = clientes.getJSONObject(j);
          addClient(a.getRoot(), c, asesor.getString("asesor"), cliente.getString("cliente"));
          // System.out.println(asesor.getString("asesor") + " || " + cliente.getString("cliente"));
        }
      }
    } catch (IOException | JSONException e) {
      e.printStackTrace();
    }
  }
}
