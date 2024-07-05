package src;

public class HashTableRL {
  private static int length = 31;
  private String[] arr = new String[HashTableRL.length];

  public HashTableRL () {}

  public static int hash (String name) {
    int hash = 0;
    int primo = HashTableRL.length;
    char[] charsOfName = name.toCharArray();
    for (char charName: charsOfName) {
      hash += charName * hash + primo * charName;
    }
    return Math.abs(hash) % HashTableRL.length;
  }

  public void addRL (String name) {
    int key = hash(name);
    if (this.arr[key] == null) {
      this.arr[key] = name;
    } else {
      int i = key;
      while (this.arr[i] != null) {
        i++;
      }
      this.arr[i] = name;
    }
  }

  public String buscarRL (String name) {
    int key = hash(name);
    if (this.arr[key] == null) {
      return null;
    } else {
      int i = key;
      while (!this.arr[i].equals(name)) {
        i++;
      }
      return this.arr[i];
    }
  }
}
