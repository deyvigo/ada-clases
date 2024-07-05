package src;

public class ArbolBinario {
  private NodoAB root;

  public ArbolBinario () {
    this.root = null;
  }

  public NodoAB getRoot () {
    return this.root;
  }

  public void addNodo (NodoAB n) {
    if (this.root == null) {
      this.root = n;
      return;
    }
    NodoAB tracker = this.root;
    while (true) {
      if (n.getName().compareTo(tracker.getName()) < 0) {
        if (tracker.getLeft() == null) {
          tracker.setLeft(n);
          break;
        }
        tracker = tracker.getLeft();
      } else {
        if (tracker.getRight() == null) {
          tracker.setRight(n);
          break;
        }
        tracker = tracker.getRight();
      }
    }
  }

  public NodoAB buscar (String name) {
    if (this.root == null) {
      return null;
    }
    NodoAB track = this.root;
    while (track != null) {
      if (track.getName().equals(name)) {
        return track;
      }
      if (track.getName().compareTo(name) < 0) {
        track = track.getRight();
      } else {
        track = track.getLeft();
      }
    }
    return null;
  }
}
