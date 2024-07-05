package search.src;

public class Nodo {
  private String nombre;
  private Nodo sgt;

  public Nodo (String nombre) {
    this.nombre = nombre;
    this.sgt = null;
  }

  public void setSgt (Nodo n) {
    this.sgt = n;
  }

  public Nodo getSgt () {
    return this.sgt;
  }

  public String getNombre () {
    return this.nombre;
  }
}
