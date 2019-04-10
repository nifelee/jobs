package com.nifelee;

import java.util.Scanner;

public class Boj_2747 {

  public static void main(String[] args) {
    int[] fibonacci = new int[46];
    fibonacci[1] = 1;

    try (Scanner s = new Scanner(System.in)) {
      int x = s.nextInt();

      for (int i=2; i<=x; i++) {
        fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
      }

      System.out.println(fibonacci[x]);
    }
  }

}
