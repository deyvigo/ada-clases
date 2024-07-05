package src;

public class Polinomio {
  private Node init;

  public Polinomio () {
    this.init = null;
  }

  public void addUnordered (Node n) {
    if (this.init == null) {
      this.init = n;
      return;
    }
    Node last = this.init;

    while (last.getSgt() != null) {
      last = last.getSgt();
    }

    last.setSgt(n);
  }

  public void addOrdered (Node n) {
    if (this.init == null) {
      this.init = n;
      return;
    }
    if (this.init.getExp() < n.getExp()) {
      n.setSgt(this.init);
      this.init = n;
    }
    Node track = this.init;
    while (track.getSgt().getExp() < n.getExp()) {
      track = track.getSgt();
    }
    track.setSgt(n);
  }

  public void showPoly () {
    Node track = this.init;
    while (track != null) {
      track.showFactor();
      if (track.getSgt() != null) {
        System.out.print(" + ");
      }
      track = track.getSgt();
    }
    System.out.println();
  }
}
