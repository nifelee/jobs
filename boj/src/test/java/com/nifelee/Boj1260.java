package com.nifelee;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000),
 * 간선의 개수 M(1 ≤ M ≤ 10,000),
 * 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * 입력으로 주어지는 간선은 양방향이다.
 *
 * 출력
 * 첫째 줄에 DFS를 수행한 결과를,
 * 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
 * V부터 방문된 점을 순서대로 출력하면 된다.
 */
@Slf4j
public class Boj1260 {

  private static int V;
  private static int E;
  private static int[][] graph;
  private static boolean[] visited;

  // 4 5 1 1 2 1 3 1 4 2 4 3 4
  // 5 5 3 5 4 5 2 1 2 3 4 3 1
  // 1000 1 1000 999 1000
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    V = scanner.nextInt();
    E = scanner.nextInt();
    int start = scanner.nextInt();

    graph = new int[V+1][V+1];
    visited = new boolean[V+1];

    int x, y;
    for (int i=1; i<=E; i++) {
      x = scanner.nextInt();
      y = scanner.nextInt();

      graph[x][y] = graph[y][x] = 1;
    }

    for (int[] arr : graph)
      log.debug("{}", arr);

    log.debug("dfs ...");
    dfs(start);

    initVisited();

    log.debug("bfs...");
    bfs(start);
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);

    visited[start] = true;
    log.debug("{}", start);

    int temp;
    while (!queue.isEmpty()) {
      temp = queue.poll();

      for (int i=0; i<=V; i++) {
        if (graph[temp][i] == 1 && !visited[i]) {
          queue.offer(i);
          visited[i] = true;
          log.debug("{}", i);
        }
      }
    }
  }

  private static void dfs(int start) {
    visited[start] = true;
    log.debug("{}", start);

    for (int i=1; i<=V; i++) {
      if (graph[start][i] == 1 && !visited[i]) {
        //log.debug("{}에서 {}로 이동", start, i);
        dfs(i);
      }
    }
  }

  private static void initVisited() {
    for (int i=0; i<visited.length; i++)
      visited[i] = false;
  }

}
