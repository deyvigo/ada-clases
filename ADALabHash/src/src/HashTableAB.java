package src;

public class HashTableAB {
  private static int length = 23; // primo para minimizar las colisiones
  private ArbolBinario[] arr = new ArbolBinario[HashTableAB.length];

  public HashTableAB () {}

  public static int hash (String name) {
    int hash = 0;
    int primo = HashTableAB.length;
    char[] charsOfName = name.toCharArray();
    for (char charName: charsOfName) {
      hash += charName * hash + primo * charName;
    }
    return Math.abs(hash) % HashTableAB.length;
  }

  public void addAB (NodoAB n) {
    int key = hash(n.getName());

    if (this.arr[key] == null) {
      this.arr[key] = new ArbolBinario();
      this.arr[key].addNodo(n);
    } else {
      this.arr[key].addNodo(n);
    }
  }

  public NodoAB buscarAB (String username) {
    int key = hash(username);
    if (this.arr[key] == null) {
      return null;
    }

    ArbolBinario aBinario = this.arr[key];
    System.out.println(aBinario.getRoot().getName());
    NodoAB response = aBinario.buscar(username);

    return response;
  }
}
