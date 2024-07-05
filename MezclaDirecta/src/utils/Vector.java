package utils;

public class Vector {
  int size = 0;
  int[] arr;

  public Vector () {
    this.arr = new int[size];
  }

  public int getSize() {
    return this.size;
  }

  public int[] getArray () {
    return this.arr;
  }

  public void changeArr () {
    int newArr[] = new int[size + 1];
    for (int i = 0; i < this.arr.length; i++) {
      newArr[i] = this.arr[i];
    }
    this.arr = newArr;
  }

  public void add (int number) {
    if (this.size == 0) {
      int[] arr = {number};
      this.arr = arr;
      size++;
      return;
    }
    changeArr();
    this.arr[size] = number;
    size++;
  }
}
