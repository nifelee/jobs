package com.nifelee;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

@Slf4j
public class Boj_1753 {

  private static final int INF = Integer.MAX_VALUE;

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int V = scanner.nextInt();
      int E = scanner.nextInt();
      int K = scanner.nextInt();

      Graph[] graphs = new Graph[V+1];
      for (int i=1; i<=V; i++) {
        graphs[i] = new Graph(i);
      }
      graphs[K].weight = 0;

      for (int i=1; i<=E; i++) {
        int vertex = scanner.nextInt();
        int edge = scanner.nextInt();
        int weight = scanner.nextInt();

        graphs[vertex].adj.add(new Edge(edge, weight));
      }

      Queue<Graph> queue = new PriorityQueue<>();
      queue.offer(graphs[K]);

      while (!queue.isEmpty()) {
        Graph fromGraph = queue.poll();
        if (fromGraph.visited)
          continue;

        fromGraph.visited = true;

        for (Edge edge : fromGraph.adj) {
          Graph toGraph = graphs[edge.vertex];

          if (!toGraph.visited) {
            toGraph.weight = Math.min(toGraph.weight, fromGraph.weight + edge.weight);
            queue.offer(toGraph);
          }
        }
      }

      for (int i=1; i<graphs.length; i++) {
        log.debug("{}", graphs[i]);
      }
    }
  }

  @ToString(of = {"vertex", "weight", "adj"})
  @RequiredArgsConstructor
  private static class Graph implements Comparable<Graph> {
    final int vertex;
    boolean visited;
    int weight = INF;
    List<Edge> adj = new ArrayList<>();

    @Override
    public int compareTo(Graph graph) {
      return this.weight - graph.weight;
    }
  }

  @ToString
  @AllArgsConstructor
  private static class Edge {
    int vertex;
    int weight;
  }

}
