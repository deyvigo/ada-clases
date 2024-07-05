package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Data {
  public static void generateData (int quantity) {
    Random random = new Random();
    String name = "src/data/" + quantity + ".txt";
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))){
      for (int i = 0; i < quantity; i++) {
        int numeroAleatorio = random.nextInt(quantity);
        if (i == quantity - 1) {
          bw.write("" + numeroAleatorio);
        } else {
          bw.write(numeroAleatorio + ",");
        }
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static int[] getArray (int quantity) {
    int[] arr;
    String name = "src/data/" + quantity + ".txt";
    try (BufferedReader br = new BufferedReader(new FileReader(name))){
      StringBuilder sb = new StringBuilder();
      char[] buffer = new char[1024];
      int numCharsRead;
      
      // Leer el archivo en fragmentos
      while ((numCharsRead = br.read(buffer, 0, buffer.length)) != -1) {
        sb.append(buffer, 0, numCharsRead);
      }



      String line = sb.toString();
      String[] parts = line.split(",");
      arr = new int[parts.length];
      for (int i = 0; i < parts.length; i++) {
        arr[i] = Integer.parseInt(parts[i]);
      }
      return arr;
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
}
