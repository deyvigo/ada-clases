package search.src;

// Arbol de Busqueda Binaria
public class ArbolBB {
  private NodoABB root;

  public ArbolBB () {
    this.root = null;
  }

  public void addNodoABB (NodoABB n) {
    if (root == null) {
      root = n;
      return;
    }
    
    NodoABB tracker = this.root;
    while (true) {
      int comparision = tracker.getDato().getFirst().getNombre().compareTo(n.getDato().getFirst().getNombre());
      if (comparision == 0) {
        break;
      } else if (comparision < 0) {
        if (tracker.getRight() == null) {
          tracker.addRight(n);
          break;
        }
        tracker = tracker.getRight();
      } else {
        if (tracker.getLeft() == null) {
          tracker.addLeft(n);
          break;
        }
        tracker = tracker.getLeft();
      }
    }
  }

  public static void mostrarArbolBB (NodoABB n) {
    if (n == null) {
      return;
    } else {
      System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
      n.getDato().mostrar("-- Asesor --", "-- Clientes --");
      System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
      mostrarArbolBB(n.getLeft());
      mostrarArbolBB(n.getRight());
    }
  }

  public NodoABB getRoot () {
    return this.root;
  }

  public static NodoABB searchByName (NodoABB n, String name) {
    if (n == null) {
      return null;
    }

    int comparision = name.compareToIgnoreCase(n.getDato().getFirst().getNombre());
    if (comparision == 0) {
      return n;
    } else if (comparision < 0) {
      return searchByName(n.getLeft(), name);
    } else {
      return searchByName(n.getRight(), name);
    }
  }
}
