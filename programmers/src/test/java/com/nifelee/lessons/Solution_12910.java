package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

//나누어 떨어지는 숫자 배열
//https://programmers.co.kr/learn/courses/30/lessons/12910
@Slf4j
public class Solution_12910 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new int[]{5, 9, 7, 10}, 5)).isEqualTo(new int[]{5, 10});
    Assertions.assertThat(solution(new int[]{2, 36, 1, 3}, 1)).isEqualTo(new int[]{1, 2, 3, 36});
    Assertions.assertThat(solution(new int[]{3, 2, 6}, 10)).isEqualTo(new int[]{-1});
  }

  //[5, 9, 7, 10]	5	[5, 10]
  //[2, 36, 1, 3]	1	[1, 2, 3, 36]
  //[3,2,6]	10	[-1]
  public int[] solution(int[] arr, int divisor) {
    int[] answer = Arrays.stream(arr)
        .filter(a -> a % divisor == 0)
        .sorted()
        .toArray();

    if (answer.length == 0)
      answer = new int[]{-1};

    return answer;
  }

}
