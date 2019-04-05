package com.nifelee.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 넓이 우선 탐색 (BFS)
 * - 시작 정점을 방문한 후 시작 정점에 인접한 모든 정점들을 우선 방문하는 방법
 *
 * https://ggmouse.tistory.com/312
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
@Slf4j
public class BreadthFirstSearch {

  //http://wonwoo.ml/index.php/post/255
  private static int[][] BFS = {
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
  private static int rear = 0, front = 0; // 전단과 후단을 나타내는 변수
  private static int[] queue = new int[10];
  private static int[] visit = new int[10];

  @Test
  public void bfs() {
    bfs(1);
  }

  private void bfs(int s){
    visit[s] = 1;
    queue[rear++] = s;

    //큐에서 다 빼낼때까지
    while (front < rear){
      s = queue[front++];
      for(int i = 1; i <=7; i++){
        if(BFS[s][i] == 1 && visit[i] != 1){
          visit[i] = 1;
          log.debug("{}에서 {}로 이동!", s, i);
          queue[rear++] = i;
        }
      }
    }
  }

}
