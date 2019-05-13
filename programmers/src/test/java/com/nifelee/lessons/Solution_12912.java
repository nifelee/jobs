package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

//두 정수 사이의 합
//https://programmers.co.kr/learn/courses/30/lessons/12912
@Slf4j
public class Solution_12912 {

  @Test
  public void test() {
    Assertions.assertThat(solution(3, 5)).isEqualTo(12L);
    Assertions.assertThat(solution(4, 10)).isEqualTo(49L);
    Assertions.assertThat(solution(3, 3)).isEqualTo(3L);
    Assertions.assertThat(solution(3, -3)).isEqualTo(0L);
    Assertions.assertThat(solution(-3, 1)).isEqualTo(-5L);
  }

  public long solution(int a, int b) {
    long n = Math.abs(a - b) + 1;
    // 등차수열 합
    return n * (a + b) / 2;
  }

}
