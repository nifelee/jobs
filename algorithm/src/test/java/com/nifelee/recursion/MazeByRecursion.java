package com.nifelee.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class MazeByRecursion {

  private static final int N = 8;

  private static final int PATHWAY_COLOR = 0; //white
  private static final int WALL_COLOR = 1;    //blue
  private static final int BLOCKED_COLOR = 2; //red
  private static final int PATH_COLOR = 3;    //green

  private static int[][] maze = {
     //0  1  2  3  4  5  6  7
      {0, 0, 0, 0, 0, 0, 0, 1}, //0
      {0, 1, 1, 0, 1, 1, 0, 1}, //1
      {0, 0, 0, 1, 0, 0, 0, 1}, //2
      {0, 1, 0, 0, 1, 1, 0, 0}, //3
      {0, 1, 1, 1, 0, 0, 1, 1}, //4
      {0, 1, 0, 0, 0, 1, 0, 1}, //5
      {0, 0, 0, 1, 0, 0, 0, 1}, //6
      {0, 1, 1, 1, 0, 1, 0, 0}  //7
  };

  private boolean findPath(int x, int y) {
    if (x < 0 || y < 0 || x >= N || y >= N) {
      return false;
    } else if (maze[x][y] != PATHWAY_COLOR) {
      return false;
    } else if (x == N-1 && y == N-1) {
      maze[x][y] = PATH_COLOR;
      return true;
    } else {
      maze[x][y] = PATH_COLOR;

      if (findPath(x - 1, y) || findPath(x + 1, y) ||
          findPath(x, y + 1) || findPath(x, y - 1))
        return true;

      maze[x][y] = BLOCKED_COLOR;
      return false;
    }
  }

  private void printMaze() {
    for (int x=0; x<N; x++)
      log.debug("{}", maze[x]);

    log.debug("");
  }

  @Test
  public void test() {
    printMaze();
    findPath(0, 0);
    printMaze();
  }

}
