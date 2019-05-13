package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

//K번째수
//https://programmers.co.kr/learn/courses/30/lessons/42748
@Slf4j
public class Solution_42748 {

  @Test
  public void test() {
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    int[] result = {5, 6, 3};

    Assertions.assertThat(solution(array, commands)).isEqualTo(result);
  }

  public int[] solution(int[] array, int[][] commands) {
    int len = commands.length;
    int[] answer = new int[len];

    for (int i=0; i<len; i++) {
      int[] x = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
      log.debug("{}", x);
      Arrays.sort(x);
      answer[i] = x[commands[i][2] - 1];
    }
    return answer;
  }

}
