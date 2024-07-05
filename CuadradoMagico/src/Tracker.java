public class Tracker {
  private int x;
  private int y;
  private int rango;

  public Tracker (int x, int y, int rango) {
    this.x = x;
    this.y = y;
    this.rango = rango;
  }

  public int getX () {
    return this.x;
  }

  public int getY () {
    return this.y;
  }

  public void moverUnoDerecha () {
    if (this.y >= rango) {
      this.y = 0;
    } else {
      this.y++;
    }
  }

  public void moverUnoIzquierda () {
    if (this.y <= 0) {
      this.y = rango;
    } else {
      this.y--;
    }
  }

  public void moverUnoArriba () {
    if (this.x <= 0) {
      this.x = rango;
    } else {
      this.x--;
    }
  }

  public void moverUnoAbajo () {
    if (this.x >= rango) {
      this.x = 0;
    } else {
      this.x++;
    }
  }
}
