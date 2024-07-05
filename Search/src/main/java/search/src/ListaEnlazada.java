package search.src;

public class ListaEnlazada {
  private Nodo inicio;
  private int cantidad;

  public ListaEnlazada () {
    this.inicio = null;
    this.cantidad = 0;
  }

  public void addNodo (String name) {
    Nodo tmp = new Nodo(name);
    if (this.inicio == null) {
      this.inicio = tmp;
    } else {
      getLast().setSgt(tmp);
    }
    cantidad++;
  }

  public Nodo getFirst () {
    return this.inicio;
  }

  public Nodo getLast () {
    Nodo tmp = inicio;
    while (tmp.getSgt() != null) {
      tmp = tmp.getSgt();
    }
    return tmp;
  }

  public int getCantidad () {
    return this.cantidad;
  }

  public void mostrar (String first, String second) {
    Nodo tmp = this.inicio;
    int index = 0;
    while (tmp != null) {
      if (index == 0) {
        System.out.println("\u001B[34m" + first + "\u001B[0m");
      } else if (index == 1) {
        System.out.println("\u001B[32m" + second + "\u001B[0m");
      }
      System.out.println(tmp.getNombre());
      index++;
      tmp = tmp.getSgt();
    }
  }
}
