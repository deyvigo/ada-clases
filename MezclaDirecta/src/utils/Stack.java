package utils;

public class Stack {
  private Nodo top;
  private int size = 0;

  public Stack () {
    this.top = null;
  }

  public void push (int dato) {
    if (top == null) {
      top = new Nodo(dato);
      size++;
      return;
    }
    Nodo newNodo = new Nodo(dato);
    newNodo.SetNext(this.top);
    this.top = newNodo;
    size++;
    // Nodo tmp = top;
    // while (tmp.getNext() != null) {
    //   tmp = tmp.getNext();
    // }
    // tmp.SetNext(new Nodo(dato));
  }

  public Nodo pop () {
    if (this.top == null) {
      return null;
    }
    Nodo tmp = this.top;
    this.top = tmp.getNext();
    tmp.SetNext(null);
    size--;
    return tmp;
  }

  public int size () {
    return this.size;
  }

  public boolean isEmpty () {
    return this.size == 0;
  }

  public int peek () {
    if (this.top == null) {
      return 10000;
    }
    return this.top.getDato();
  }

  public void showStack () {
    Nodo tmp = top;
    while (tmp != null) {
      System.out.println(tmp.getDato());
      tmp =  tmp.getNext();
    }
  }
}
