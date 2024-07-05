package src;

public class Nodo {
  private int dato;
  private Nodo left;
  private Nodo right;

  public Nodo (int dato) {
    this.left = null;
    this.right = null;
    this.dato = dato;
  }

  public int getDato () {
    return this.dato;
  }

  public void addLeft (Nodo l) {
    this.left = l;
  }

  public void addRight (Nodo r) {
    this.right = r;
  }

  public Nodo getLeft () {
    return this.left;
  }

  public Nodo getRight () {
    return this.right;
  }
}
