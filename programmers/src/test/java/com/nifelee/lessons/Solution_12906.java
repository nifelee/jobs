package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//같은 숫자는 싫어
//https://programmers.co.kr/learn/courses/30/lessons/12906
@Slf4j
public class Solution_12906 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new int[]{1,1,3,3,0,1,1})).isEqualTo(new int[]{1,3,0,1});
  }

  public int[] solution(int[] arr) {
    List<Integer> list = new ArrayList<>();
    int prev = -1;
    for (int i : arr) {
      if (i != prev)
        list.add(i);

      prev = i;
    }

    int[] answer = new int[list.size()];
    int index = 0;
    for (int i : list) {
      answer[index++] = i;
    }
    return answer;
  }

}
