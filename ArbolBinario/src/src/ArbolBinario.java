package src;

import java.util.Stack;

public class ArbolBinario {
  private Nodo root;

  public ArbolBinario () {
    this.root = null;
  }

  public Nodo getRoot () {
    return this.root;
  }

  public void addNodo (Nodo n) {
    if (this.root == null) {
      this.root = n;
      return;
    }
    Nodo track = this.root;
    while (true) {
      if (track.getDato() >= n.getDato()) {
        if (track.getLeft() == null) {
          track.addLeft(n);
          break;
        }
        track = track.getLeft();
      } else {
        if (track.getRight() == null) {
          track.addRight(n);
          break;
        }
        track = track.getRight();
      }
    }
  }

  public static void mostrar (Nodo n) {
    if (n == null) {
      return;
    } else {
      mostrar(n.getLeft());
      mostrar(n.getRight());
      System.out.println(n.getDato());
    }
  }

  public void mostrarPostOrden () {
    if (this.root == null) {
      return;
    }

    Stack<Nodo> stack = new Stack<>();
    Stack<Nodo> salida = new Stack<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      Nodo actual = stack.pop();
      salida.push(actual);

      if (actual.getLeft() != null) {
        stack.push(actual.getLeft());
      }

      if (actual.getRight() != null) {
        stack.push(actual.getRight());
      }
    }
    System.out.println("\nRecorrido postOrden iterativo: ");
    while (!salida.isEmpty()) {
      System.out.print(salida.pop().getDato() + " ");
    }
    System.out.println("\n");
  }

  public void mostrarPreOrden () {
    if (this.root == null) {
      return;
    }

    Stack<Nodo> stack = new Stack<>();
    Stack<Nodo> salida = new Stack<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      Nodo actual = stack.pop();
      salida.push(actual);

      if (actual.getRight() != null) {
        stack.push(actual.getRight());
      }

      if (actual.getLeft() != null) {
        stack.push(actual.getLeft());
      }
    }
    System.out.println("\nRecorrido preOrden iterativo: ");
    while(!salida.isEmpty()) {
      stack.push(salida.pop());
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop().getDato() + " ");
    }
    System.out.println("\n");
  }

  public void mostrarInOrder () {
    Stack<Nodo> pila = new Stack<>();
    Nodo current = this.root;
    System.out.println("\nRecorrido inOrden iterativo: ");
    while (current != null || !pila.isEmpty()) {
      while (current != null) {
        pila.push(current);
        current = current.getLeft();
      }
      current = pila.pop();
      System.out.print(current.getDato() + " ");
      current = current.getRight();
    }
    System.out.println("\n");
  }
}
