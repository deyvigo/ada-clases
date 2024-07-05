package structures;

import java.util.Set;
import java.util.TreeSet;

public class Vertex implements Comparable<Vertex> {
  private int data;
  private Set<Vertex> neighbors;

  public Vertex (int data) {
    this.data = data;
    this.neighbors = new TreeSet<>();
  }

  public int getData () {
    return this.data;
  }

  public void addNeighbor (Vertex n) {
    this.neighbors.add(n);
  }

  public Set<Vertex> getNeighbors () {
    return this.neighbors;
  }

  @Override
  public int compareTo(Vertex other) {
    return Integer.compare(this.data, other.data);
  }
}
