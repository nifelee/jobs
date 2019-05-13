package com.nifelee.lessons;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//네트워크
//https://programmers.co.kr/learn/courses/30/lessons/43162
@Slf4j
public class Solution_43162 {

  @Test
  public void test() {
    Assertions.assertThat(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})).isEqualTo(2);
    Assertions.assertThat(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})).isEqualTo(1);
  }

  //n	computers	return
  //3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
  //3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
  public int solution(int n, int[][] computers) {
    Computer[] coms = new Computer[n];
    for (int i=0; i<n; i++)
      coms[i] = new Computer(i);

    for (int i=0; i<computers.length; i++) {
      for (int j=0; j<computers[i].length; j++) {
         if (i != j && computers[i][j] == 1) {
          coms[i].computers.add(coms[j]);
        }
      }
    }

    int answer = 0;
    for (Computer com : coms) {
      if (!com.visited) answer++;

      visited(com.computers);
    }
    return answer;
  }

  private void visited(List<Computer> computers) {
    for (Computer com : computers) {
      if (!com.visited) {
        com.visited = true;
        visited(com.computers);
      }
    }
  }

  @ToString(of = "id")
  class Computer {
    int id;
    boolean visited;
    List<Computer> computers = new ArrayList<>();

    Computer(int id) {
      this.id = id;
    }
  }

}
