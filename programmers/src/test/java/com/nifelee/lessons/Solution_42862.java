package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

//https://programmers.co.kr/learn/courses/30/lessons/42862
@Slf4j
public class Solution_42862 {

  @Test
  public void test() {
    Assertions.assertThat(solution(5, new int[]{2, 4}, new int[]{1, 3, 5})).isEqualTo(5);
    Assertions.assertThat(solution(5, new int[]{2, 4}, new int[]{3})).isEqualTo(4);
    Assertions.assertThat(solution(3, new int[]{3}, new int[]{1})).isEqualTo(2);
    Assertions.assertThat(solution(3, new int[]{1, 2}, new int[]{2, 3})).isEqualTo(2);
  }

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;

    for (int i=0; i<lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (lost[i] == reserve[j]) {
          answer++;
          lost[i] = -1;
          reserve[j] = -1;
          break;
        }
      }
    }

    for (int i=0; i<lost.length; i++) {
      if (lost[i] < 0)
        continue;

      for (int j=0; j<reserve.length; j++) {
        if (reserve[j] == -1)
          continue;

        if (lost[i] == reserve[j]) {
          answer++;
          reserve[j] = -1;
          break;
        } else if (Math.abs(lost[i] - reserve[j]) == 1) {
          answer++;
          reserve[j] = -1;
          break;
        }
      }
    }
    return answer;
  }

}
