package com.nifelee.lessons;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//후보키 (Kakao 2018)
//https://programmers.co.kr/learn/courses/30/lessons/42890
@Slf4j
public class Solution_42890 {

  @Test
  public void test1() {
    //0, [1, 2]
    String[][] relation = {
        //0     1         2          3
        {"100", "ryan",   "music",   "2"}, //0
        {"200", "apeach", "math",    "2"}, //1
        {"300", "tube",   "computer","3"}, //2
        {"400", "con",    "computer","4"}, //3
        {"500", "muzi",   "music",   "3"}, //4
        {"600", "apeach", "music",   "2"}  //5
    };
    Assertions.assertThat(solution(relation)).isEqualTo(2);
  }

  @Test
  public void test2() {
    //0, [1,2], [1,3]
    String[][] relation = {
        //0     1         2          3
        {"100", "ryan",   "music",   "1"}, //0
        {"200", "apeach", "math",    "2"}, //1
        {"300", "tube",   "computer","3"}, //2
        {"400", "con",    "computer","4"}, //3
        {"500", "muzi",   "music",   "1"}, //4
        {"600", "apeach", "music",   "1"}  //5
    };
    Assertions.assertThat(solution(relation)).isEqualTo(3);
  }

  //0, 1, 2, 3
  //[0, 1], [0, 2], [0, 3], [1, 2], [1, 3], [2, 3]
  //[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]
  //[0, 1], [1, 2]
  //[0, 1, 2, 3] - 모든 경우의 수의 중복
  private boolean[] visited;
  private int answer = 0;
  public int solution(String[][] relation) {
    int length = relation[0].length;

    visited = new boolean[length];
    List<Graph> graphs = new ArrayList<>();

    for (int i=0; i<length; i++) {
      graphs.add(new Graph(i, i));

      for (int j=i+1; j<length; j++) {
        graphs.add(new Graph(i, j));
      }
    }

    dfs(relation, graphs, 0);

    return answer;
  }

  private void dfs(String[][] relation, List<Graph> graphs, int start) {
    visited[start] = true;

    for (int i=0; i<graphs.size(); i++) {
      Graph graph = graphs.get(i);
      if (graph.source == start && !visited[graph.source]) {

      }
    }
  }

  private void check(String[][] relation, int start, int end) {
    String key = getValue(relation, 0, end);

    Set<String> set = new HashSet<>();
    for (int i=0; i<relation.length; i++) {
      String temp = getValue(relation, i, end);
    }
  }

  private String getValue(String[][] relation, int row, int column) {
    String value = relation[row][row];
    if (row != column)
      value += relation[row][column];
    return value;
  }

  @ToString
  private static class Graph {
    final int source;
    final int target;

    Graph(int source, int target) {
      this.source = source;
      this.target = target;
    }
  }

}
