package com.nifelee.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 깊이 우선 탐색 (DFS)
 * - 특정 노드를 출발하여 깊게 들어 갈 수 있을때 까지 들어가고 들어 갈 곳이 없다면 다시 나오는 알고리즘
 * : 일반적으로 Stack을 사용하여 탐색
 * : 시간/순서
 *
 * https://ggmouse.tistory.com/312
 */
@Slf4j
public class DepthFirstSearch {

  //http://wonwoo.ml/index.php/post/239
  private static int[] visited = new int[10];
  private static int[][] DFS = {
     //0  1  2  3  4  5  6  7
      {0, 0, 0, 0, 0, 0, 0, 0}, //0
      {0, 0, 1, 1, 0, 0, 0, 0}, //1
      {0, 1, 0, 0, 1, 0, 0, 0}, //2
      {0, 1, 0, 0, 0, 1, 1, 1}, //3
      {0, 0, 1, 0, 0, 0, 0, 0}, //4
      {0, 0, 0, 1, 0, 0, 0, 0}, //5
      {0, 0, 0, 1, 0, 0, 0, 0}, //6
      {0, 0, 0, 1, 0, 0, 0, 0}  //7
  };

  @Test
  public void dfs() {
    DFS(1);
  }

  private static void DFS(int v) {
    //정점을 방문했다고 표시
    visited[v] = 1;
    for (int i = 1; i <= 7; i++) {
      //정점을 방문하지 않고 인접행렬이라면
      if (visited[i] != 1 && DFS[v][i] == 1 ) {
        log.debug("{}에서 {}로 이동!", v, i);
        DFS(i);
      }
    }
  }

}
