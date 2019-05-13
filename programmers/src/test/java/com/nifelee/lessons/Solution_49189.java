package com.nifelee.lessons;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//가장 먼 노드
//https://programmers.co.kr/learn/courses/30/lessons/49189
@Slf4j
public class Solution_49189 {

  @Test
  public void test() {
    int n = 6;
    int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

    int x = solution(n, edge);
    Assertions.assertThat(x).isEqualTo(3);
  }

  private int solution(int n, int[][] edge) {
    List<Node> nodes = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];

    //init
    for (int i=1; i<=n; i++) {
      nodes.add(new Node(i));
    }

    //adj
    for (int[] ints : edge) {
      nodes.get(ints[0] - 1).addAdj(nodes.get(ints[1] - 1));
      nodes.get(ints[1] - 1).addAdj(nodes.get(ints[0] - 1));
    }

    visit(nodes.get(0), visited, queue, 0);
    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (Node adj : node.adj) {
        if (!visited[adj.vertex])
          visit(adj, visited, queue, node.depth + 1);
      }
    }

    for (Node node : nodes)
      log.debug("{}", node);

    int maxDepth = nodes.stream().mapToInt(node -> node.depth).max().getAsInt();
    return (int) nodes.stream().filter(node -> node.depth == maxDepth).count();
  }

  private void visit(Node node, boolean[] visited, Queue<Node> queue, int depth) {
    visited[node.vertex] = true;
    queue.offer(node);
    node.depth = depth;
  }

  @ToString(exclude = "adj")
  private static class Node {
    private int vertex;
    private List<Node> adj = new ArrayList<>();
    private int depth;

    Node(int vertex) {
      this.vertex = vertex;
    }

    void addAdj(Node node) {
      this.adj.add(node);
    }
  }

}
