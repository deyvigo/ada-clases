import src.Polinomio;
import src.Node;

public class ProductoPolinomios {
  public static void main(String[] args) {
    Polinomio p = new Polinomio();
    p.addUnordered(new Node(15, 0));
    p.addUnordered(new Node(10, 2));
    p.addUnordered(new Node(5, 3));
    System.out.println("Polinomio 1:");
    p.showPoly();

    Polinomio q = new Polinomio();
    q.addUnordered(new Node(2, 3));
    q.addUnordered(new Node(3, 4));
    q.addUnordered(new Node(1, 0));
    q.addUnordered(new Node(10, 1));
    System.out.println("Polinomio 2:");
    q.showPoly();
  }
}
