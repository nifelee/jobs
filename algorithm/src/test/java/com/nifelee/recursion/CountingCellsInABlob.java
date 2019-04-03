package com.nifelee.recursion;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 인접한 셀(대각선 포함)의 1의 갯수
 * @implNote http://ucc.pknu.ac.kr/em/56f638fe12d18
 */
@Slf4j
public class CountingCellsInABlob {

  private static final int LENGTH = 8;

  private static final int FOUND = 1;
  private static final int COUNTED = 2;

  private static int[][] cells = {
     //0  1  2  3  4  5  6  7
      {1, 0, 0, 0, 0, 0, 0, 1}, //0
      {0, 1, 1, 0, 0, 1, 0, 0}, //1
      {1, 1, 0, 0, 1, 0, 1, 0}, //2
      {0, 0, 0, 0, 0, 1, 0, 0}, //3
      {0, 1, 0, 1, 0, 1, 0, 0}, //4
      {0, 1, 0, 1, 0, 1, 0, 0}, //5
      {1, 0, 0, 0, 1, 0, 0, 1}, //6
      {0, 1, 1, 0, 0, 1, 1, 1}  //7
  };

  @Test
  public void test() {
    int count = countingCells(cells, 3, 5);
    Assertions.assertThat(count).isEqualTo(13);
  }

  private int countingCells(int[][] cells, int x, int y) {
    printCells(x, y);

    if (x < 0 || y < 0 || x >= LENGTH || y >= LENGTH) {
      return 0;
    } else if (cells[x][y] != FOUND) {
      return 0;
    } else {
      cells[x][y] = COUNTED;

      return  1 +
          countingCells(cells, x - 1, y + 1) + countingCells(cells, x, y + 1) +
          countingCells(cells, x + 1, y + 1) + countingCells(cells, x - 1, y) +
          countingCells(cells, x + 1, y) + countingCells(cells, x - 1, y - 1) +
          countingCells(cells, x, y - 1) + countingCells(cells, x + 1, y - 1);

    }
  }

  private void printCells(int x, int y) {
    for (int i=0; i<LENGTH; i++)
      log.debug("{} //{}", cells[i], i);

    log.debug("");
    log.debug("x:{}, y:{}", x, y);
  }

}
