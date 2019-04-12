package com.nifelee.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 다익스트라 알고리즘
 */
@Slf4j
public class DijkstraSearch {

  private static final int INF = 2147483647;
  //private static int[] dist; // 시작 정점에서 목적 정점까지의 거리
  //private static boolean[] visit; // 정점을 방문했나 안했나

  public static void main(String[] args) {
    int V = 5; // 정점의 개수
    //int E = 6; // 간선의 개수
    int S = 1; // 시작 정점의 번호

    int[] dist = new int[V + 1]; // 시작 정점에서 목적 정점까지의 거리
    boolean[] visit = new boolean[V + 1]; // 정점을 방문했나 안했나

    // 각 정점의 연결된 간선을 저장
    List<Edge>[] a = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      dist[i] = INF; // 모든 정점은 일단 무한
      a[i] = new ArrayList<>();
    }

    dist[S] = 0; // 시작정점의 거리는 0

    a[5].add(new Edge(1, 1));
    a[1].add(new Edge(2, 2));
    a[1].add(new Edge(3, 3));
    a[2].add(new Edge(3, 4));
    a[2].add(new Edge(4, 5));
    a[3].add(new Edge(4, 6));

    Queue<Edge> pq = new PriorityQueue<>(); // 우선순위 큐
    pq.offer(new Edge(S, 0)); //시작 정점을 우선순위 큐에 넣음.

    while (!pq.isEmpty()) {
      Edge edge = pq.poll(); // 큐에 들어있는 간선중 가장 가중치가 낮은 것 찾음.
      if (visit[edge.dest])
        continue;

      visit[edge.dest] = true;

      for (Edge k : a[edge.dest]) {
        if (!visit[k.dest]) {
          dist[k.dest] = Math.min(dist[k.dest], dist[edge.dest] + k.weight);
          pq.offer(new Edge(k.dest, dist[k.dest]));
        }
      }
    } //end of while

    for (int i = 1; i <= V; i++) {
      if (dist[i] == INF) {
        System.out.println("INF");
      } else {
        System.out.println(dist[i]);
      }
    }
  }

  static class Edge implements Comparable<Edge> {
    int dest; // 간선의 목적지
    int weight; // 간선의 가중치

    Edge(int dest, int weight) {
      this.dest = dest;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }

}
