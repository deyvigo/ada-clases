package utils;

public class Nodo {
  private int dato;
  private Nodo next;

  public Nodo (int dato) {
    this.dato = dato;
    this.next = null;
  }

  public int getDato () {
    return this.dato;
  }

  public void SetNext (Nodo next) {
    this.next = next;
  }

  public Nodo getNext () {
    return this.next;
  }
}
