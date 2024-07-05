package src;

public class Node {
  private int exponente;
  private int coeficiente;
  private Node sgt;

  public Node (int coeficiente, int exponente) {
    this.exponente = exponente;
    this.coeficiente = coeficiente;
    this.sgt = null;
  }

  public void setSgt (Node n) {
    this.sgt = n;
  }

  public Node getSgt () {
    return this.sgt;
  }

  public void setExp (int exponente) {
    this.exponente = exponente;
  }

  public int getExp () {
    return this.exponente;
  }

  public void setCoef (int coeficiente) {
    this.coeficiente = coeficiente;
  }

  public int getCoef () {
    return this.coeficiente;
  }

  public void showFactor () {
    if (this.exponente == 0) {
      System.out.print(this.coeficiente);
    } else if (this.exponente == 1) {
      System.out.print(this.coeficiente + "x");
    } else {
      System.out.print(this.coeficiente + "x^" + this.exponente);
    }
  }
}
