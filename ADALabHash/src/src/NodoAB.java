package src;

public class NodoAB {
  private String name;
  private NodoAB left;
  private NodoAB right;

  public NodoAB (String name) {
    this.name = name;
    this.left = null;
    this.right = null;
  }

  public String getName () {
    return this.name;
  }

  public NodoAB getLeft () {
    return this.left;
  }

  public NodoAB getRight () {
    return this.right;
  }

  public void setLeft (NodoAB left) {
    this.left = left;
  }

  public void setRight (NodoAB right) {
    this.right = right;
  }
}
