package src;

// Nodo de Arbol de Busqueda Binaria
public class NodoABB {
  private ListaEnlazada dato;
  private NodoABB right;
  private NodoABB left;

  public NodoABB () {
    this.right = null;
    this.left = null;
    this.dato = new ListaEnlazada();
  }

  public void addRight (NodoABB r) {
    this.right = r;
  }

  public void addLeft (NodoABB l) {
    this.left = l;
  }

  public ListaEnlazada getDato () {
    return this.dato;
  }

  public NodoABB getLeft () {
    return this.left;
  }

  public NodoABB getRight () {
    return this.right;
  }
}
