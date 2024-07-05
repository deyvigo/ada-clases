package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// directed graph

public class Graph {
  private Map<Integer, Vertex> vertices;
  private int firstVertex;

  public Graph () {
    this.vertices = new HashMap<>();
  }

  public void addVertex (int data) {
    if(this.vertices.isEmpty()) {
      this.firstVertex = data;
    }
    if (!vertices.containsKey(data)) {
      vertices.put(data, new Vertex(data));
    }
  }

  public int getFirst () {
    return this.firstVertex;
  }

  public void addEdge (int fromData, int toData) {
    Vertex from = this.vertices.get(fromData);
    Vertex to = this.vertices.get(toData);
    if (from != null && to != null) {
      from.addNeighbor(to);
    }
  }

  public List<Vertex> amplitud (int startData) {
    Vertex start = this.vertices.get(startData);
    if (start == null) return null;

    Queue<Vertex> queue = new LinkedList<>();
    List<Vertex> salida = new ArrayList<>();
    queue.add(start);

    System.out.println("\nQueue: ");
    for (Vertex v: queue) {
      System.out.print(v.getData() + " ");
    }

    System.out.println("\nSalida: ");
    for (Vertex v: salida) {
      System.out.print(v.getData() + " ");
    }

    while (!queue.isEmpty()) {
      Vertex current = queue.poll();
      if (salida.contains(current)) continue;

      salida.add(current);

      for (Vertex neighbor: current.getNeighbors()) {
        queue.add(neighbor);
      }

      System.out.println("\nQueue: ");
      for (Vertex v: queue) {
        System.out.print(v.getData() + " ");
      }

      System.out.println("\nSalida: ");
      for (Vertex v: salida) {
        System.out.print(v.getData() + " ");
      }
    }

    return salida;
  }
}
