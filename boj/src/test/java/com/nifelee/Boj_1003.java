package com.nifelee;

import java.util.Scanner;

public class Boj_1003 {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int[][] p = new int[41][2];
      p[0][0] = 1;
      p[1][1] = 1;

      for (int i = 2; i < 41; i++) {
        for (int j = 0; j < 2; j++) {
          p[i][j] = p[i - 1][j] + p[i - 2][j];
        }
      }

      int n = scanner.nextInt();
      for (int i = 0; i < n; i++) {
        int x = scanner.nextInt();
        System.out.println(p[x][0] + " " + p[x][1]);
      }
    }
  }

}
