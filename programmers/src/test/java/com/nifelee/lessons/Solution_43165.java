package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.TreeMap;

//https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
@Slf4j
public class Solution_43165 {

  private int count;

  @Test
  public void test() {
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;

    int x = solution(numbers, target);
    Assertions.assertThat(x).isEqualTo(5);
  }

  public int solution(int[] numbers, int target) {
    dfs(numbers, target, 0);
    return count;
  }

  private void dfs(int[] numbers, int target, int index) {
    if (index == numbers.length) {
      int sum = 0;
      for (int number : numbers)
        sum += number;

      if (sum == target)
        count++;
    } else {
      dfs(numbers, target, index + 1);

      numbers[index] *= -1;
      dfs(numbers, target, index + 1);
    }
  }

}
